package com.szk.soj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szk.soj.annotation.AuthCheck;
import com.szk.soj.common.BaseResponse;
import com.szk.soj.common.ErrorCode;
import com.szk.soj.common.ResultUtils;
import com.szk.soj.constant.UserConstant;
import com.szk.soj.exception.BusinessException;
import com.szk.soj.model.dto.question.QuestionQueryRequest;
import com.szk.soj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.szk.soj.model.entity.Question;
import com.szk.soj.model.entity.QuestionSubmit;
import com.szk.soj.model.entity.User;
import com.szk.soj.model.vo.QuestionSubmitVO;
import com.szk.soj.service.QuestionSubmitService;
import com.szk.soj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.szk.soj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交
 *
 * @author szk
 * @from <a href="https://szk.icu">编程导航知识星球</a>
 */
@RestController
//@RequestMapping("/question_submit")
@Slf4j
@Deprecated
public class QuestionSubmitController {

//    @Resource
//    private QuestionSubmitService questionSubmitService;
//
//    @Resource
//    private UserService userService;
//
//    /**
//     * 提交题目
//     *
//     * @param questionSubmitAddRequest
//     * @param request
//     * @return resultNum 本次点赞变化数
//     */
//    @PostMapping("/")
//    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
//                                               HttpServletRequest request) {
//        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        // 登录才能点赞
//        final User loginUser = userService.getLoginUser(request);
//        long questionId = questionSubmitAddRequest.getQuestionId();
//        Long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
//        return ResultUtils.success(questionSubmitId);
//    }
//
//    /**
//     * 分页获取题目提交列表（除了管理员外，普通用户只能看到非答案，提交代码等公开信息）
//     *
//     * @param questionSubmitQueryRequest
//     * @return
//     */
//    @PostMapping("/list/page")
//    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
//                                                                         HttpServletRequest request) {
//        long current = questionSubmitQueryRequest.getCurrent();
//        long size = questionSubmitQueryRequest.getPageSize();
//        final User loginUser = userService.getLoginUser(request);
//        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
//                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
//        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
//    }

}
