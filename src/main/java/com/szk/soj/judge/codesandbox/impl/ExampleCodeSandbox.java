package com.szk.soj.judge.codesandbox.impl;

import com.szk.soj.judge.codesandbox.CodeSandbox;
import com.szk.soj.judge.codesandbox.model.ExecuteCodeResponse;
import com.szk.soj.judge.codesandbox.model.ExecuteCodeResquest;

public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeResquest executeCodeResquest) {
        System.out.println("示例代码沙箱");
        return null;
    }
}
