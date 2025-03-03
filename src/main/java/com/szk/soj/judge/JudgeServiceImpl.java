package com.szk.soj.judge;

import cn.hutool.json.JSONUtil;
import com.szk.soj.common.ErrorCode;
import com.szk.soj.exception.BusinessException;
import com.szk.soj.judge.codesandbox.CodeSandbox;
import com.szk.soj.judge.codesandbox.CodeSandboxFactory;
import com.szk.soj.judge.codesandbox.CodeSandboxProxy;
import com.szk.soj.judge.codesandbox.model.ExecuteCodeResponse;
import com.szk.soj.judge.codesandbox.model.ExecuteCodeResquest;
import com.szk.soj.judge.strategy.JudgeContext;
import com.szk.soj.model.dto.question.JudgeCase;
import com.szk.soj.judge.codesandbox.model.JudgeInfo;
import com.szk.soj.model.entity.Question;
import com.szk.soj.model.entity.QuestionSubmit;
import com.szk.soj.model.enums.QuestionSubmitStatusEnum;
import com.szk.soj.service.QuestionService;
import com.szk.soj.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JudgeServiceImpl implements JudgeService{
    @Resource
    private QuestionSubmitService questionSubmitService;
    @Resource
    private QuestionService questionService;
    @Resource
    private JudgeManager judgeManager;

    @Value("${codesandbox.type:example}")
    private String type;
    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        System.out.println("111111111111111111111111111111111111111111111111111111111111");
        //传入提交题目id获取对应题目、提交信息 代码编程语言等
        QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);
        if(questionSubmit == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR,"提交信息不存在");
        }
        Long questionId = questionSubmit.getQuestionId();
        Question question = questionService.getById(questionId);
        if(question == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR,"题目不存在");
        }
        //只判处于等待状态的题，不重复判题
        if(!questionSubmit.getStatus().equals(QuestionSubmitStatusEnum.WAITING.getValue())){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"题目正在判题");
        }
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean b = questionSubmitService.updateById(questionSubmitUpdate);
        if(!b){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"题目状态更新错误");
        }

        //调用代码沙箱，获取执行结果
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        ExecuteCodeResquest executeCodeResquest = ExecuteCodeResquest.builder().code(code).language(language).inputList(inputList).build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeResquest);//沙箱执行结果
        List<String> outputList = executeCodeResponse.getOutputList();
        //根据沙箱执行结果设置题目提交的状态和信息
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setQuestion(question);
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestionSubmit(questionSubmit);
        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);

        questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCESS.getValue());
        questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        b = questionSubmitService.updateById(questionSubmitUpdate);
        if(!b){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"题目状态更新错误");
        }
        QuestionSubmit questionSubmitResult = questionSubmitService.getById(questionId);

        return questionSubmitResult;

    }
}
