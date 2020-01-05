package com.caitiezhu.gaea.service.controller;

import com.caitiezhu.gaea.service.service.ProjectService;
import com.jcraft.jsch.JSchException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/clone")
    public void cloneProject(String url, String branch, String projectName) throws GitAPIException, JSchException {
        projectService.cloneProject(url, branch, projectName);
    }
}
