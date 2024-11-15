package com.shuke.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuke.springbootinit.domain.User;
import com.shuke.springbootinit.mapper.UserMapper;
import com.shuke.springbootinit.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author 16422
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-15 11:53:19
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




