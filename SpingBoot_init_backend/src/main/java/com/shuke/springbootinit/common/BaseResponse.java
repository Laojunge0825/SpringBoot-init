package com.shuke.springbootinit.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: BaseResponse
 * @Description:
 * @author: 舒克、舒克
 * @Date: 2024/11/15 14:28
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public BaseResponse(int code , String msg , T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(ErrorCode errorCode){
        this(errorCode.getCode(),errorCode.getMsg(),null);
    }
}
