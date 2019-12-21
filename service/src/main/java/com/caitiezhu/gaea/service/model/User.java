package com.caitiezhu.gaea.service.model;

import lombok.Data;

@Data
public class User {
    private Long id;

    private String email;

    private String username;

    private String nameZh;

    private String aboutMe;

    private String password;
}
