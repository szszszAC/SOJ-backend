package com.szk.soj.service;

import com.szk.soj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.szk.soj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.szk.soj.model.entity.User;

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

}
