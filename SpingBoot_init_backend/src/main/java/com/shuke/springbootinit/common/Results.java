package com.shuke.springbootinit.common;

/**
 * @ClassName: Results
 * @Description:
 * @author: 舒克、舒克
 * @Date: 2024/11/15 14:37
 */
public class Results {

    /**
     * @Author 舒克、舒克
     * @Description 成功
     * @Date 14:39 2024/11/15
     * @Param
     * @return
     **/
    public static  <T>BaseResponse<T> success(T data){
        return new BaseResponse<T>(0,"ok",data);
    }

    /**
     * @Author 舒克、舒克
     * @Description 失败
     * @Date 14:41 2024/11/15
     * @Param
     * @return
     **/
    public static BaseResponse error(ErrorCode errorCode){
        return new BaseResponse(errorCode);
    }
}
