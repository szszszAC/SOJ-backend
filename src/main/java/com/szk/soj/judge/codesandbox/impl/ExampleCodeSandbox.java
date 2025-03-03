package com.szk.soj.judge.codesandbox.impl;

import com.szk.soj.judge.codesandbox.CodeSandbox;
import com.szk.soj.judge.codesandbox.model.ExecuteCodeResponse;
import com.szk.soj.judge.codesandbox.model.ExecuteCodeResquest;
import com.szk.soj.judge.codesandbox.model.JudgeInfo;
import com.szk.soj.model.enums.JudgeInfoMessageEnum;
import com.szk.soj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeResquest executeCodeResquest) {
        List<String> inputList = executeCodeResquest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCESS.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPT.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
