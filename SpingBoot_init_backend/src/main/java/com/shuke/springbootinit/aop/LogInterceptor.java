package com.shuke.springbootinit.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @ClassName: LogInterceptor
 * @Description:  日志拦截器
 * @author: 舒克、舒克
 * @Date: 2024/11/15 14:52
 */
@Aspect
@Component
@Slf4j
public class LogInterceptor {

    @Around("execution(* com.shuke.springbootinit.controller.*.*(..))")
    public Object doInterceptor(ProceedingJoinPoint point) throws Throwable {
        // 计时
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 获取请求路径
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes)requestAttributes).getRequest();
        // 生成唯一请求id
        String requestId = UUID.randomUUID().toString();
        String url = httpServletRequest.getRequestURI();
        // 获取请求参数
        Object [] args = point.getArgs();
        String reqParams = "[" + StringUtils.join(args, ",") + "]";
        // 输出请求日志
        log.info("request start, id: {}, url: {}, path: {}, ip: {}, params: {}",
                requestId,url,httpServletRequest,httpServletRequest.getRemoteHost(),reqParams);
        // 执行原方法
        Object obj = point.proceed();
        // 输出响应日志
        stopWatch.stop();
        long totalTimeMIllis = stopWatch.getTotalTimeMillis();
        log.info("requrst end, id: {}, cost: {}ms",requestId , totalTimeMIllis);
        return obj;
    }
}
