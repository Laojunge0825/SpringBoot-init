package com.shuke.springbootinit.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: LoginUserVo
 * @Description:  用户登录视图  脱敏
 * @author: 舒克、舒克
 * @Date: 2024/11/15 15:31
 */
@Data
public class LoginUserVo implements Serializable {

    private int id;

    private String name;

    private String password;

    private String role;

    private String token;
}
