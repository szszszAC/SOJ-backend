package com.szk.soj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szk.soj.model.dto.question.QuestionQueryRequest;
import com.szk.soj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.szk.soj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.szk.soj.model.entity.Question;
import com.szk.soj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.szk.soj.model.entity.User;
import com.szk.soj.model.vo.QuestionSubmitVO;
import com.szk.soj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author Mayn
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2025-02-17 22:33:09
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);



    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
