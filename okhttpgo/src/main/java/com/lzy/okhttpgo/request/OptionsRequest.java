package com.lzy.okhttpgo.request;

import com.lzy.okhttpgo.model.HttpHeaders;
import com.lzy.okhttpgo.utils.HttpUtils;
import com.lzy.okhttpgo.utils.OkLogger;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * ================================================
 * 作    者：廖子尧
 * 版    本：1.0
 * 创建日期：2016/1/16
 * 描    述：Options请求
 * 修订历史：
 * ================================================
 */
public class OptionsRequest extends BaseBodyRequest<OptionsRequest> {

    public OptionsRequest(String url) {
        super(url);
    }

    @Override
    protected Request generateRequest(RequestBody requestBody) {
        try {
            headers.put(HttpHeaders.HEAD_KEY_CONTENT_LENGTH, String.valueOf(requestBody.contentLength()));
        } catch (IOException e) {
            OkLogger.e(e);
        }
        Request.Builder requestBuilder = HttpUtils.appendHeaders(headers);
        return requestBuilder.method("OPTIONS", requestBody).url(url).tag(tag).build();
    }
}