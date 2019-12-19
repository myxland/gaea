package com.caitiezhu.gaea.gitlab.common;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GitCommand {

    public static Git clone(String remoteUrl, String branch, File repoDir) throws GitAPIException {
        if (repoDir.exists()) {
            deletAllFiles(repoDir);
        }
        return Git.cloneRepository()
                .setURI(remoteUrl)
                .setBranch(branch)
                .setDirectory(repoDir)
                .call();
    }

    public static void checkout(Git git) throws GitAPIException {
        List<Ref> list =  git.branchList().call();
        System.out.println(list);
    }

    public static void main(String[] args) throws GitAPIException {
        File file = new File("/Users/didi/Documents/gaea");
        Git git = clone("https://github.com/caitiezhu/gaea.git", "master", file);
        checkout(git);
    }

    public static void deletAllFiles(File file) {
        if (file == null) {
            return;
        }
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                Arrays.asList(Objects.requireNonNull(file.listFiles())).forEach(GitCommand::deletAllFiles);
                file.delete();
            }
        }
    }
}
