package com.szk.soj.judge;

import com.szk.soj.model.entity.QuestionSubmit;
import com.szk.soj.model.vo.QuestionSubmitVO;

public interface JudgeService {
     QuestionSubmit doJudge(long questionSubmitId);
}
