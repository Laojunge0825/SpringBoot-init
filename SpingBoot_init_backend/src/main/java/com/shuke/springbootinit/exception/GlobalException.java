package com.shuke.springbootinit.exception;

import com.shuke.springbootinit.common.BaseResponse;
import com.shuke.springbootinit.common.ErrorCode;
import com.shuke.springbootinit.common.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalException
 * @Description:  全局异常管理
 * @author: 舒克、舒克
 * @Date: 2024/11/15 16:39
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(BaseException.class)
    public BaseResponse<?> baseExceptionHandle(BaseException e){
        log.error("BaseException",e);
        return Results.error(e.getCode() , e.getMessage() );
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandle(RuntimeException e){
        log.error("RunTimeException",e);
        return Results.error(ErrorCode.SYSTEM_ERROR );
    }

}
