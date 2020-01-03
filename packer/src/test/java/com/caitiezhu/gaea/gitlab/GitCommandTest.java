package com.caitiezhu.gaea.gitlab;

import com.caitiezhu.gaea.gitlab.common.GitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GitlabApplication.class)
public class GitCommandTest {

    @Test
    public void cloneTest() throws GitAPIException {
        String remoteUrl = "https://git.lug.ustc.edu.cn/caitiezhu/test-repo.git";
        String branch = "master";
        String repoDir = "test-repo";
        Git git = GitCommand.clone(remoteUrl, branch, repoDir);
        System.out.println(git);
    }
}
