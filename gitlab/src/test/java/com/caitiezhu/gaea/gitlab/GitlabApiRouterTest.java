//package com.caitiezhu.gaea.gitlab;
//
//import com.caitiezhu.gaea.git.common.GitlabApiRouter;
//import com.caitiezhu.gaea.git.model.Gitlab;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.IOException;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = GitApplication.class)
//public class GitlabApiRouterTest {
//    @Autowired
//    private Gitlab gitab;
//
//    @Test
//    public void gitlabModelInjectionTest() {
//        System.out.println(gitab.getAddress());
//    }
//
//    @Test
//    public void getAccessTokenTest() throws IOException {
//        GitlabApiRouter.getAccessToken("caitiezhu", "caiyang123");
//    }
//}
