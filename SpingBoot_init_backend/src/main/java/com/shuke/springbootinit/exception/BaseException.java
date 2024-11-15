package com.shuke.springbootinit.exception;

import com.shuke.springbootinit.common.ErrorCode;

/**
 * @ClassName: BaseException
 * @Description:   自定义异常
 * @author: 舒克、舒克
 * @Date: 2024/11/15 15:36
 */
public class BaseException extends RuntimeException{

   private final int code;

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }


    public BaseException(ErrorCode errorCode){
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }

   public BaseException(ErrorCode errorCode, String msg){
       super(msg);
       this.code = errorCode.getCode();
   }

    public int getCode() {
        return code;
    }

}
