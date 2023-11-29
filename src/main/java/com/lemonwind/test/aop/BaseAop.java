package com.lemonwind.test.aop;

import com.lemonwind.test.utils.AopOrders;
import com.lemonwind.test.utils.RequestIdContext;
import com.lemonwind.test.utils.RequestIdGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(AopOrders.BASE_ORDER)
public class BaseAop {

    Logger logger = LoggerFactory.getLogger(BaseAop.class);

    @Around("execution(public * com.lemonwind.test.controllers..*Controller.*(..))")
    public Object proccess(ProceedingJoinPoint pjp) {
        String requestId = RequestIdGenerator.generate();
        RequestIdContext.set(requestId);

        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable e) {
            logger.error(e.getMessage(), e.getCause());
        }
        RequestIdContext.remove();
        return obj;
    }

}
