package com.shuke.springbootinit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuke.springbootinit.common.BaseResponse;
import com.shuke.springbootinit.common.Results;
import com.shuke.springbootinit.domain.User;
import com.shuke.springbootinit.domain.vo.LoginUserVo;
import com.shuke.springbootinit.domain.vo.PageVo;
import com.shuke.springbootinit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: UserController
 * @Description:
 * @author: 舒克、舒克
 * @Date: 2024/11/15 14:42
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Author 舒克、舒克
     * @Description  分页查询
     * @Date 16:03 2024/11/15
     * @Param
     * @return
     **/
    @RequestMapping("/findByPage")
    public BaseResponse<Page<User>> findBypage(@RequestBody PageVo pageVo){
        return Results.success(userService.findByPage(pageVo));
    }

    /**
     * @Author 舒克、舒克
     * @Description  用户注册
     * @Date 16:03 2024/11/15
     * @Param
     * @return
     **/
    @RequestMapping("/register")
    public BaseResponse<Long> register(@RequestBody User user){
        return Results.success(userService.register(user));
    }

    @RequestMapping("/login")
    public BaseResponse<LoginUserVo> register(@RequestBody User user  , HttpServletRequest request){
        return Results.success(userService.login(user , request));
    }

}
