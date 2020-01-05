package com.caitiezhu.gaea.gitlab.common;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class GitCommand {

    public static Git clone(String remoteUrl, String branch, String repoDir) throws GitAPIException {
        File path = new File(repoDir);
        if (path.exists()) {
            deletAllFiles(path);
        }
        CredentialsProvider provider = new UsernamePasswordCredentialsProvider("caitiezhu", "caiyang123");
        return Git.cloneRepository()
                .setCredentialsProvider(provider)
                .setURI(remoteUrl)
                .setBranch(branch)
                .setDirectory(path)
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
