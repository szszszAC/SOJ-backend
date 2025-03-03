package com.szk.soj.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.szk.soj.common.ErrorCode;
import com.szk.soj.exception.BusinessException;
import com.szk.soj.judge.codesandbox.CodeSandbox;
import com.szk.soj.judge.codesandbox.model.ExecuteCodeResponse;
import com.szk.soj.judge.codesandbox.model.ExecuteCodeResquest;
import org.apache.commons.lang3.StringUtils;

public class RemoteCodeSandbox implements CodeSandbox {
    private static final String AUTH_REQUEST_HEADER="auth";
    private static final String AUTH_REQUEST_SECRET="secretKey";
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeResquest executeCodeResquest) {
        System.out.println("远程代码沙箱");
        String url = "http://localhost:8090/executecode";
        String json = JSONUtil.toJsonStr(executeCodeResquest);
        String responseStr = HttpUtil.createPost(url).header(AUTH_REQUEST_HEADER,AUTH_REQUEST_SECRET).body(json).execute().body();
        if(StringUtils.isBlank(responseStr)){
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = "+responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
