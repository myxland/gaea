package com.caitiezhu.gaea.gitlab;

import com.caitiezhu.gaea.gitlab.common.GitlabApiRouter;
import com.caitiezhu.gaea.gitlab.model.Gitlab;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GitlabApplication.class)
public class GitlabApiRouterTest {
    @Resource
    private GitlabApiRouter router;

    @Test
    public void gitlabModelInjectionTest() {
    }

    @Test
    public void getAccessTokenTest() throws IOException {
        String result = router.getAccessToken("caitiezhu", "caiyang123");
        System.out.println(result);
    }
}
