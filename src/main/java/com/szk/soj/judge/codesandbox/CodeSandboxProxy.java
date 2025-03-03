package com.szk.soj.judge.codesandbox;

import com.szk.soj.judge.codesandbox.model.ExecuteCodeResponse;
import com.szk.soj.judge.codesandbox.model.ExecuteCodeResquest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CodeSandboxProxy implements CodeSandbox {

    private final CodeSandbox codeSandbox;
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeResquest executeCodeResquest) {
        log.info("代码沙箱请求信息："+executeCodeResquest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeResquest);
        log.info("代码沙箱相应信息："+executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
