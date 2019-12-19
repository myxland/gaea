//package com.caitiezhu.gaea.gitlab.common;
//
//import com.caitiezhu.gaea.gitlab.http.DefaultHttpClient;
//import com.caitiezhu.gaea.gitlab.http.HttpResponse;
//import com.caitiezhu.gaea.gitlab.model.Gitlab;
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GitlabApiRouter {
//    private static Gitlab gitlabHelper;
//
//    @Autowired
//    private Gitlab gitlab;
//
//    @PostConstruct
//    public void initStaticBean() {
//        GitlabApiRouter.gitlabHelper = this.gitlab;
//    }
//
//    public static String getAccessToken(String username, String password) throws IOException {
//        String url = gitlabHelper.getAddress() + "/oauth/token";
//        String grantType = "password";
//        List<NameValuePair> parameters = new ArrayList<NameValuePair>(){{
//            add(new BasicNameValuePair("grant_type", grantType));
//            add(new BasicNameValuePair("username", username));
//            add(new BasicNameValuePair("password", password));
//        }};
//        HttpResponse response = DefaultHttpClient.doPost(url, parameters);
//        System.out.println(response);
//        return null;
//    }
//}
