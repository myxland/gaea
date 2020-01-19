package com.caitiezhu.gaea.service.model.vo;

import lombok.Data;

/**
 * @Description TODO
 * @Author cai yang
 * @Date 2020/1/19 5:16 下午
 **/
@Data
public class RegisterVO {
    private String email;
    private String username;
    private String nameZh;
    private String aboutMe;
    private String password;
}
