package com.szk.soj.judge;

import com.szk.soj.judge.strategy.DefaultJudgeStrategy;
import com.szk.soj.judge.strategy.JavaLanguageJudgeStrategy;
import com.szk.soj.judge.strategy.JudgeContext;
import com.szk.soj.judge.strategy.JudgeStrategy;
import com.szk.soj.judge.codesandbox.model.JudgeInfo;
import com.szk.soj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题策略管理
 */
@Service
public class JudgeManager {

    JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if("java".equals(language)){
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
