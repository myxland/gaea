package com.caitiezhu.gaea.service.model.po;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BizLine {
    private Long id;
    private String bizLine;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
}
