package com.caitiezhu.gaea.gitlab;

import com.caitiezhu.gaea.gitlab.common.GitlabApiRouter;
import com.caitiezhu.gaea.gitlab.bean.Gitlab;
import com.caitiezhu.gaea.gitlab.model.GitBranch;
import com.caitiezhu.gaea.gitlab.model.GitProject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GitlabApplication.class)
public class GitlabApiRouterTest {
    @Autowired
    private Gitlab gitab;
    @Autowired
    private GitlabApiRouter router;

    private String token = "168d4a5eabf4e515e21c3d01c84904b3865e74d39cafbcb24cc4ac82dc7026a8";

    @Test
    public void gitlabModelInjectionTest() {
        System.out.println(gitab.getAddress());
    }

    @Test
    public void getAccessTokenTest() throws IOException {
        router.getAccessToken("caitiezhu", "caiyang123");
    }

    @Test
    public void listProjects() throws IOException, URISyntaxException {
        String accessToken = "xyZb-TseBdy-XcXVB3sg";
        List<GitProject> projects = router.listProjects(accessToken);
        System.out.println(projects);
    }

    @Test
    public void listBranches() throws IOException, URISyntaxException {
        String accessToken = "xyZb-TseBdy-XcXVB3sg";
        List<GitBranch> branches = router.listBranches(15631409L, accessToken);
        System.out.println(branches);
    }
}
