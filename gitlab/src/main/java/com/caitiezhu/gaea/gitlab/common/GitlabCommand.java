//package com.caitiezhu.gaea.gitlab.common;
//
//import com.caitiezhu.gaea.gitlab.exception.EmptyArgsException;
//import com.google.common.base.Strings;
//
//public class GitlabCommand {
//
//    public String doClone(String repo, String branch, String codePath) throws EmptyArgsException {
//        if (Strings.isNullOrEmpty(repo) || Strings.isNullOrEmpty(branch) || Strings.isNullOrEmpty(codePath)) {
//            throw new EmptyArgsException();
//        }
//        return String.format("git clone %s -b %s %s", repo, branch, codePath);
//    }
//
//    public String checkVersion() {
//        return "git --version";
//    }
//
//    public String showAllBranch() {
//        return "git branch --all";
//    }
//}
