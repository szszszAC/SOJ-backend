package com.szk.soj.judge.strategy;

import com.szk.soj.model.dto.question.JudgeCase;
import com.szk.soj.judge.codesandbox.model.JudgeInfo;
import com.szk.soj.model.entity.Question;
import com.szk.soj.model.entity.QuestionSubmit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 上下文（用于定义在策略中的参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudgeContext {
    private JudgeInfo judgeInfo;
    private List<String> inputList;
    private List<String> outputList;
    private Question question;
    private List<JudgeCase> judgeCaseList;
    private QuestionSubmit questionSubmit;
}
