package com.shuke.springbootinit.interceptor;

import com.shuke.springbootinit.common.BaseContext;
import com.shuke.springbootinit.common.ErrorCode;
import com.shuke.springbootinit.config.JwtProperty;
import com.shuke.springbootinit.util.JWTUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: JwtInterceptor
 * @Description:  jwt 拦截器
 * @author: 舒克、舒克
 * @Date: 2024/11/18 9:54
 */
@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {


    @Autowired
    private JwtProperty jwtProperty;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response , Object handle){
        if(!(handle instanceof HandlerMethod)){
            // 拦截到的不是动态方法  是静态资源直接放行
            return  true;
        }

        // 从请求头中获取令牌
        String token = request.getHeader(jwtProperty.getTokenName());

        // 校验 token
        if(JWTUtil.validateToken(token)){
            log.info("token 校验通过");
            Claims claims  = JWTUtil.parseJWT(jwtProperty.getTokenName(),token).getBody();
            Integer id = Integer.valueOf(claims.get("id").toString());
            BaseContext.setUserID(id);
            return  true;
        }
        response.setStatus(ErrorCode.JWT_ERROR.getCode());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 可以在这里添加请求处理后的一些后置操作，如果有的话
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 请求完成后，清理ThreadLocal中的用户信息，避免内存泄漏
        BaseContext.removeUser();
    }
}
