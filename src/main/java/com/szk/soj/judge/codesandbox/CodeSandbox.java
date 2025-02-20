package com.szk.soj.judge.codesandbox;

import com.szk.soj.judge.codesandbox.model.ExecuteCodeResponse;
import com.szk.soj.judge.codesandbox.model.ExecuteCodeResquest;

public interface CodeSandbox {
    ExecuteCodeResponse executeCode(ExecuteCodeResquest executeCodeResquest);
}
