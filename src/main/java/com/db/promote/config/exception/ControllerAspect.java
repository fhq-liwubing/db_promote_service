package com.db.promote.config.exception;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author kun
 * @version 2018-12-06 20:10
 */
@Aspect
@Component
public class ControllerAspect {

    private static final Logger log = LoggerFactory.getLogger(ControllerAspect.class);

    @Around(value = "execution(public * com.db.promote.controller.CommonController.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String method = pjp.getSignature().getName();
        Object result = pjp.proceed();
        log.info("请求地址：{}，响应：{}", method, JSON.toJSONString(result));
        return result;
    }

}
