package com.caitiezhu.gaea.service.service;

import com.jcraft.jsch.JSchException;
import org.eclipse.jgit.api.errors.GitAPIException;

public interface ProjectService {

    void cloneProject(String url, String branch, String projectName) throws GitAPIException, JSchException;
}
