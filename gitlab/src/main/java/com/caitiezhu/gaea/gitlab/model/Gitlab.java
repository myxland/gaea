package com.caitiezhu.gaea.gitlab.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Gitlab {
    @Value("${gitlab.address}")
    private String address;

    public String getAddress() {
        return address;
    }
}
