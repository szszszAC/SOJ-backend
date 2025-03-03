package com.szk.soj.model.dto.question;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 创建请求
 *
 * @author szk
 * @from <a href="https://szk.icu">编程导航知识星球</a>
 */
@Data
public class QuestionAddRequest implements Serializable {

    /**
     * 标题
     */
    private String title;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 标签列表（栈 队列 链表...难度, json数组）
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 判题用例 json数组
     */
    private List<JudgeCase> judgeCase;

    /**
     * 判题配置 json数组
     */
    private JudgeConfig judgeConfig;

    private static final long serialVersionUID = 1L;
}