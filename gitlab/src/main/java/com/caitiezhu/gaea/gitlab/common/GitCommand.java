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

    private static void deletAllFiles(File file) {
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
