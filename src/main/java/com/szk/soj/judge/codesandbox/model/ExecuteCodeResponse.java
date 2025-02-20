package com.szk.soj.judge.codesandbox.model;


import com.szk.soj.model.dto.questionsubmit.JudgeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExecuteCodeResponse {
    private List<String> outputList;
    //接口传回的信息
    private String message;
    private Integer status;
    private JudgeInfo judgeInfo;

}
