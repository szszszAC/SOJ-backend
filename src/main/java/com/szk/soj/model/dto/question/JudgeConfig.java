package com.szk.soj.model.dto.question;

import lombok.Data;

@Data
public class JudgeConfig {
    private Long timeLimit; //时间限制 ms
    private Long memoryLimit;//内存限制 KB
    private Long stackLimit;//堆栈限制 KB
}
