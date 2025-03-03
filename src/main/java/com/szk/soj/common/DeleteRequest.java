package com.szk.soj.common;

import java.io.Serializable;
import lombok.Data;

/**
 * 删除请求
 *
 * @author szk
 * @from <a href="https://szk.icu">编程导航知识星球</a>
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}