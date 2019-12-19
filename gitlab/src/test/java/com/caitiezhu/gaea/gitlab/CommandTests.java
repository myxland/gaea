//package com.caitiezhu.gaea.gitlab;
//
//import com.caitiezhu.gaea.gitlab.common.Executor;
//import com.caitiezhu.gaea.gitlab.common.GitlabCommand;
//import com.caitiezhu.gaea.gitlab.exception.EmptyArgsException;
//import junit.framework.Assert;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CommandTests {
//    GitlabCommand commander = new GitlabCommand();
//
//    @Test
//    public void cloneCommand() throws EmptyArgsException {
//        String repo = "https://github.com/caitiezhu/gaea.git";
//        String branch = "master";
//        String codePath = "gaea";
//        String got = commander.doClone(repo, branch, codePath);
//        String excepted = String.format("git clone %s -b %s %s", repo, branch, codePath);
//        Assert.assertEquals(excepted, got);
//    }
//
//    @Test
//    public void checkVersion() throws IOException {
//        String command = commander.checkVersion();
//        String got = Executor.exec(command).get(0);
//        String excepted = "git version 2.24.0";
//        Assert.assertEquals(excepted, got);
//    }
//
//    @Test
//    public void showAllBranch() throws IOException {
//        String command = commander.showAllBranch();
//        List<String> got = Executor.exec(command);
//        List<String> excepted = new ArrayList<String>(){{
//            add("* feature/caitiezhu_20191211");
//            add("master");
//            add("remotes/origin/HEAD -> origin/master");
//            add("remotes/origin/feature/caitiezhu_20191211");
//            add("remotes/origin/master");
//        }};
//        Assert.assertEquals(excepted, got);
//    }
//}
