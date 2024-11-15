package com.shuke.springbootinit.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shuke.springbootinit.domain.User;
import com.shuke.springbootinit.domain.vo.PageVo;

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
}
