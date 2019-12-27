package com.caitiezhu.gaea.gitlab.model;

import lombok.Data;

@Data
public class GitProject {
    private Integer id;

    private String name;

    private String nameWithNamespace;

    private String httpUrlToRepo;

    private String webUrl;
}
