package com.szk.soj.judge.strategy;

import com.szk.soj.judge.codesandbox.model.JudgeInfo;

public interface JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
