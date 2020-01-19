package com.caitiezhu.gaea.service.model.po;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private Long id;
    private String email;
    private String username;
    private String nameZh;
    private String aboutMe;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String password;
}
