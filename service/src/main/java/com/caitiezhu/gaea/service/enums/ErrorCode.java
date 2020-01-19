package com.caitiezhu.gaea.service.enums;

/**
 * @Description TODO
 * @Author cai yang
 * @Date 2020/1/19 5:20 下午
 **/
public enum ErrorCode {

    SUCCESS(0, "SUCCESS"),
    FAIL(10, "FAIL");

    private int code;

    private String showMsg;

    ErrorCode(int code, String showMsg) {
        this.code = code;
        this.showMsg = showMsg;
    }

    public int getCode() {
        return code;
    }

    public String getShowMsg() {
        return showMsg;
    }
}
