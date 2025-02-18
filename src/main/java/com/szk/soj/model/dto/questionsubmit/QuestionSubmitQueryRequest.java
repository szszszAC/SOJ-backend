package com.szk.soj.model.dto.questionsubmit;

import com.szk.soj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 *
 * @author <a href="https://github.com/liszk">程序员鱼皮</a>
 * @from <a href="https://szk.icu">编程导航知识星球</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {


    /**
     * 编程语言
     */
    private String language;

    /**
     * 提交状态
     */
    private Integer status;


    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * user id
     */
    private Long userId;


    private static final long serialVersionUID = 1L;
}