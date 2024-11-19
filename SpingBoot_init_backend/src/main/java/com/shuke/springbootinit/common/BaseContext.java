package com.shuke.springbootinit.common;

/**
 * @ClassName: BaseContext
 * @Description: 设置threadLocal类  用于获取 设置 移除当前用户
 * @author: 舒克、舒克
 * @Date: 2024/11/18 9:44
 */
public class BaseContext {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void setUserID(Integer id){
        threadLocal.set(id);
    }

    public static Integer getUser(){
        return threadLocal.get();
    }

    public static void removeUser(){
        threadLocal.remove();
    }

}
