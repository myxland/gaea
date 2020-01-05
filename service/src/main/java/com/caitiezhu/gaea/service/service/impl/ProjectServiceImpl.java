package com.caitiezhu.gaea.service.service.impl;

import com.caitiezhu.gaea.agent.SSHExecutor;
import com.caitiezhu.gaea.agent.module.Remote;
import com.caitiezhu.gaea.gitlab.common.GitCommand;
import com.caitiezhu.gaea.service.service.ProjectService;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private static String LOCAL_PATH = "/Users/caitiezhu/IdeaProjects/gaea/";
    private static String REMOTE_PATH = "/root/";

    @Override
    public void cloneProject(String url, String branch, String projectName) throws GitAPIException, JSchException {
        String inLocalProject = LOCAL_PATH + projectName;
        String inRemoteProject = REMOTE_PATH + projectName;
        Git git = GitCommand.clone(url, branch, inLocalProject);
        Remote remote = new Remote();
        Session session = SSHExecutor.getSession(remote);
        session.connect();
        SSHExecutor.upLoadFile(session, inLocalProject, REMOTE_PATH);
        StringBuffer command = new StringBuffer()
                .append("cd " + projectName).append(";")
                .append("ll").append(";")
                .append("mvn clean package");
//        SSHExecutor.remoteExecute(session, "cd " + inRemoteProject).forEach(System.out::println);
//        SSHExecutor.remoteExecute(session, "ll").forEach(System.out::println);
//        SSHExecutor.remoteExecute(session, "mvn clean package").forEach(System.out::println);
        SSHExecutor.remoteExecute(session, command.toString()).forEach(System.out::println);
    }
}
