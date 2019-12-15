package com.caitiezhu.gaea.gitlab;

import com.caitiezhu.gaea.gitlab.common.GitlabApiRouter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;

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
        String token = router.getAccessToken("caitiezhu", "caiyang123");
        System.out.println(token);
    }

    @Test
    public void checkAccessTokenTest() throws IOException, URISyntaxException {
        String holdToken = "168d4a5eabf4e515e21c3d01c84904b3865e74d39cafbcb24cc4ac82dc7026a8";
        boolean result = router.checkAccessToken(holdToken);
        System.out.println(result);
    }
}
