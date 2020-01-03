package com.caitiezhu.gaea.agent.module;

import lombok.Data;

@Data
public class Remote {

    private String user = "root";
    private String host = "47.96.173.145";
    private int port = 22;
    private String password = "Caiyang123";
//    private String identity = "~/.ssh/id_rsa";
//    private String passphrase = "";
}