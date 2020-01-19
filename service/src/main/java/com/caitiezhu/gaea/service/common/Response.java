package com.caitiezhu.gaea.service.common;

import com.caitiezhu.gaea.service.enums.ErrorCode;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @Description TODO
 * @Author cai yang
 * @Date 2020/1/19 5:17 下午
 **/
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
public class Response<T> {

    private Integer errno;

    private String errmsg;

    private T data;

    public static <T> Response<T> build(T data) {
        return build(ErrorCode.SUCCESS, data);
    }

    public Response() {
        errno = ErrorCode.SUCCESS.getCode();
    }

    public static <T> Response<T> build(ErrorCode error, T data) {
        Response<T> response = new Response<>();
        response.setErrno(error.getCode());
        response.setErrmsg(error.getShowMsg());
        response.setData(data);
        return response;
    }

    public static <T> Response<T> build(ErrorCode error) {
        return build(error, null);
    }

    public static <T> Response<T> build(int code, String msg) {
        Response<T> response = new Response<>();
        response.setErrno(code);
        response.setErrmsg(msg);
        return response;
    }

}
