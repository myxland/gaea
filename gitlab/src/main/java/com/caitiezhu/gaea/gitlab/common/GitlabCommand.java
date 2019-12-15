package com.caitiezhu.gaea.gitlab.common;

import com.caitiezhu.gaea.gitlab.exception.EmptyArgsException;
import com.google.common.base.Strings;

public class GitlabCommand {

    public String doClone(String accessToken, String repo, String branch, String codePath) throws EmptyArgsException {
        if (Strings.isNullOrEmpty(repo) || Strings.isNullOrEmpty(branch) || Strings.isNullOrEmpty(codePath)) {
            throw new EmptyArgsException();
        }
        return String.format("git clone https://oauth2:%s@%s -b %s %s",accessToken, repo, branch, codePath);
    }

    public String checkVersion() {
        return "git --version";
    }

    public String showAllBranch() {
        return "git branch --all";
    }
}
