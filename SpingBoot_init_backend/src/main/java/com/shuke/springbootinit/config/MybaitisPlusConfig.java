package com.shuke.springbootinit.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MybaitisPlusConfig
 * @Description:  MybatisPlus  配置
 * @author: 舒克、舒克
 * @Date: 2024/11/15 14:48
 */
@Configuration
public class MybaitisPlusConfig {

    /**
     * @Author 舒克、舒克
     * @Description  拦截器配置
     * @Date 14:50 2024/11/15
     * @Param
     * @return
     **/
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return  interceptor;
    }
}
