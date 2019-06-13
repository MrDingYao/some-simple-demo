package com.santu.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONUtil;
import com.santu.common.domain.User;
import org.junit.Test;

import java.net.HttpCookie;
import java.util.List;

public class HttpUtilTest {

    private String url = "http://www.bai.com";

    @Test
    public void get() {
        User user = new User("dingyao", "dsj", 18, "shanghai");
        String file = "D:\\temp\\temp.bat";
        HttpResponse httpResponse = HttpUtil.createGet(url)
                .body(JSONUtil.toJsonStr(user))
                .form("file", FileUtil.file(file))
                .timeout(10000)
                .header("Authentication", "abcd")
                .execute();
        String body = httpResponse.body();
        byte[] bytes = httpResponse.bodyBytes();
        HttpCookie code = httpResponse.getCookie("code");
        List<HttpCookie> cookies = httpResponse.getCookies();
    }

    @Test
    public void post() {
        HttpResponse httpResponse = HttpUtil.createPost(url).execute();
    }

    @Test
    public void put() {
        HttpResponse httpResponse = HttpUtil.createRequest(Method.PUT, url).execute();
    }

    @Test
    public void delete() {
        HttpResponse httpResponse = HttpUtil.createRequest(Method.DELETE, url).execute();
    }
}
