package com.jomchen.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * create by Jomchen on 2018/11/21
 */
@Aspect
@Component
@Order(1)
public class AllAop {

    @Around("@annotation(com.jomchen.test.utils.TestAnnotation)")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("-------------------> around1");
        Object result = pjp.proceed();
        System.out.println("-------------------> around2");
        return result;
    }

}
