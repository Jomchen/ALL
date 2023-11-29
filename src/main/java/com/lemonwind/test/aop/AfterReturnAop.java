package com.lemonwind.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * create by lemonwind on 2018/11/27
 */
@Aspect
@Component
@Order(1)
public class AfterReturnAop {

    @AfterReturning(pointcut = "@annotation(com.lemonwind.test.utils.TestAnnotation)", returning = "result")
    public void process(JoinPoint pjp, Object result) {
        System.out.println("-------------------> afterReturning");
    }

}
