package com.caitiezhu.gaea.gitlab.common;

import com.alibaba.fastjson.JSONArray;
import com.caitiezhu.gaea.gitlab.http.DefaultHttpClient;
import com.caitiezhu.gaea.gitlab.http.HttpResponse;
import com.caitiezhu.gaea.gitlab.bean.Gitlab;
import com.caitiezhu.gaea.gitlab.model.GitProject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GitlabApiRouter {

    @Autowired
    private Gitlab gitlab;

    public String getAccessToken(String username, String password) throws IOException {
        String url = gitlab.getAddress() + "/oauth/token";
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(){{
            add(new BasicNameValuePair("grant_type", "password"));
            add(new BasicNameValuePair("username", username));
            add(new BasicNameValuePair("password", password));
        }};
        HttpResponse response = DefaultHttpClient.doPost(url, parameters);
        System.out.println(response);
        return null;
    }

    public List<GitProject> listProjects(String accessToken) throws IOException, URISyntaxException {
        String url = gitlab.getAddress() + "/api/v4/projects?owned=true&sample=true";
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(){{
            add(new BasicNameValuePair("private_token", accessToken));
        }};
        HttpResponse response = DefaultHttpClient.doGet(url, parameters);
        JSONArray dataArray = JSONArray.parseArray(response.getMsg());

        List<GitProject> projects = dataArray.toJavaList(GitProject.class);
        return projects;
    }
}
