package com.shuke.springbootinit.config;

import com.shuke.springbootinit.interceptor.JwtInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @ClassName: WebConfig
 * @Description:  配置类 注册web层相关组件
 * @author: 舒克、舒克
 * @Date: 2024/11/18 10:29
 */
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器， 指定拦截的路径和排除的路径
        registry.addInterceptor(jwtInterceptor)
                // 拦截所有请求路径
                .addPathPatterns("/**")

                // 排除登录请求路径
                .excludePathPatterns("/user/login","/user/register");
    }
}
