package com.shuke.springbootinit.common;

/**
 * @ClassName: ErrorCode
 * @Description:  自定义错误码
 * @author: 舒克、舒克
 * @Date: 2024/11/15 14:32
 */
public enum ErrorCode {
    SYSTEM_ERROR(501,"系统错误"),
    PARAMS_ERROR(401,"请求参数错误")
    ;

    private int code;

    private String msg;

    ErrorCode(int code, String msg) {
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
