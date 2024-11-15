package com.shuke.springbootinit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuke.springbootinit.common.BaseResponse;
import com.shuke.springbootinit.common.Results;
import com.shuke.springbootinit.domain.User;
import com.shuke.springbootinit.domain.vo.PageVo;
import com.shuke.springbootinit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/findByPage")
    public BaseResponse<Page<User>> findBypage(@RequestBody PageVo pageVo){
        return Results.success(userService.findByPage(pageVo));
    }
}
