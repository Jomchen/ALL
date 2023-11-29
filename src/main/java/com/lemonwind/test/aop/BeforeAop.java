package com.lemonwind.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * create by lemonwind on 2018/11/27
 */
@Aspect
@Component
@Order(1)
public class BeforeAop {

    @Before(value = "@annotation(com.lemonwind.test.utils.TestAnnotation)")
    public void kkk(JoinPoint pjp) {
        System.out.println("-------------------> before");
    }

}
