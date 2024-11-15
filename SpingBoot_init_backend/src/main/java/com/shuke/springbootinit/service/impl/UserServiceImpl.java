package com.shuke.springbootinit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuke.springbootinit.common.ErrorCode;
import com.shuke.springbootinit.domain.User;
import com.shuke.springbootinit.domain.vo.LoginUserVo;
import com.shuke.springbootinit.domain.vo.PageVo;
import com.shuke.springbootinit.exception.BaseException;
import com.shuke.springbootinit.mapper.UserMapper;
import com.shuke.springbootinit.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

import static com.shuke.springbootinit.constant.UserConstant.USER_LOGIN_STATE;

/**
* @author 16422
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-15 11:53:19
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    private static final String SALT = "shuke";

    @Override
    public Page<User> findByPage(PageVo pageVo) {
        return baseMapper.selectPage(new Page<>(pageVo.getPageNum(),pageVo.getPageSize()),null);
    }

    @Override
    public long register(User user) {
        if(StringUtils.isAnyBlank(user.getName(),user.getPassword())){
            throw new BaseException(ErrorCode.PARAMS_ERROR);
        }
        synchronized (user.getName().intern()){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name" , user.getName());
            long count = baseMapper.selectCount(queryWrapper);
            if(count > 0){
                throw  new BaseException(ErrorCode.PARAMS_ERROR,"用户名已存在");
            }

            //加密
            String encryptPassword = DigestUtils.md5DigestAsHex((SALT+user.getPassword()).getBytes());

            user.setPassword(encryptPassword);
            long res =  baseMapper.insert(user);
            if(res != 1){
                throw new BaseException(ErrorCode.SYSTEM_ERROR , "注册失败，数据库异常");
            }
            return user.getId();
        }

    }

    @Override
    public LoginUserVo login(User user , HttpServletRequest request) {
        if(StringUtils.isAnyBlank(user.getName(),user.getPassword())){
            throw new BaseException(ErrorCode.PARAMS_ERROR);
        }
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT+user.getPassword()).getBytes());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name" , user.getName())
                .eq("password", encryptPassword);
        User u = baseMapper.selectOne(queryWrapper);
        if( u == null){
            throw new BaseException(ErrorCode.PARAMS_ERROR,"用户名或者密码错误");
        }
        // 记录用户的登录态
        request.getSession().setAttribute(USER_LOGIN_STATE,u);
        return this.getLoginUserVO(u);
    }

    @Override
    public LoginUserVo getLoginUserVO(User user) {
        if (user == null) {
            return null;
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        BeanUtils.copyProperties(user, loginUserVo);
        return loginUserVo;
    }
}




