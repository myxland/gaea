package com.caitiezhu.gaea.gitlab.common;

import com.alibaba.fastjson.JSONObject;
import com.caitiezhu.gaea.gitlab.http.DefaultHttpClient;
import com.caitiezhu.gaea.gitlab.http.HttpResponse;
import com.caitiezhu.gaea.gitlab.model.Gitlab;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GitlabApiRouter {

    @Autowired
    private Gitlab gitlab;

    public String getAccessToken(String username, String password) throws IOException {
        String url = gitlab.getAddress() + "/oauth/token";
        String grantType = "password";
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(){{
            add(new BasicNameValuePair("grant_type", grantType));
            add(new BasicNameValuePair("username", username));
            add(new BasicNameValuePair("password", password));
        }};
        HttpResponse response = DefaultHttpClient.doPost(url, parameters);
        String msg = response.getMsg();
        return String.valueOf(JSONObject.parseObject(msg).get("access_token"));
    }
}
