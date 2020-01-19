package com.caitiezhu.gaea.service.service.impl;

import com.caitiezhu.gaea.agent.SSHExecutor;
import com.caitiezhu.gaea.agent.module.Remote;
import com.caitiezhu.gaea.gitlab.common.GitCommand;
import com.caitiezhu.gaea.service.service.ProjectService;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.SneakyThrows;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private static String LOCAL_PATH = "/Users/didi/IdeaProjects/gaea/";
    private static String REMOTE_PATH = "/root/";

    @Override
    public void cloneProject(String url, String branch, String projectName) throws GitAPIException, JSchException {
        //local project path
        String inLocalProject = LOCAL_PATH + projectName;
        //remote project path
        String inRemoteProject = REMOTE_PATH + projectName;

        GitCommand.clone(url, branch, inLocalProject);

        Session session = SSHExecutor.getSession(new Remote());
        session.connect();
        //upload project and shell
        SSHExecutor.upLoadFile(session, inLocalProject, inRemoteProject);
        SSHExecutor.upLoadFile(session, "/Users/didi/IdeaProjects/gaea/shell/start.sh", inRemoteProject);
        //execute command
        SSHExecutor.remoteExecute(session, "sh /root/demo/start.sh demo").forEach(System.out::println);
        System.out.println("finished");
        session.disconnect();
    }
}
