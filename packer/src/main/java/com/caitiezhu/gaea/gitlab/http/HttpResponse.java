package com.caitiezhu.gaea.gitlab.http;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpResponse {
    private Integer code;
    private String msg;
}
