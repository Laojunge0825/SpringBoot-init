package com.shuke.springbootinit.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shuke.springbootinit.domain.User;
import com.shuke.springbootinit.domain.vo.LoginUserVo;
import com.shuke.springbootinit.domain.vo.PageVo;

import javax.servlet.http.HttpServletRequest;

/**
* @author 16422
* @description 针对表【user】的数据库操作Service
* @createDate 2024-11-15 11:53:19
*/
public interface UserService extends IService<User> {

    /**
     * 分页查询
     **/
    Page<User> findByPage(PageVo pageVo);

    /**
     * 用户注册
     **/
    long register(User user);

    /**
     * 用户登录
     **/
    LoginUserVo login(User user , HttpServletRequest request);


    /**
     * 获取脱敏的已登录用户信息
     */
    LoginUserVo getLoginUserVO(User user);
}
