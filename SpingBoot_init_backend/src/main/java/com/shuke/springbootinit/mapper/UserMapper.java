package com.shuke.springbootinit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuke.springbootinit.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 16422
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-11-15 11:53:19
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




