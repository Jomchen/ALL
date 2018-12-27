package com.jomchen.test.mybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Enumeration;
import java.util.Properties;

/**
 * create by Jomchen on 2018/12/20
 */
@Intercepts({@Signature(
        type= Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class})})
public class ExamplePlugin  implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("开始开始开始开始开始开始开始开始开始开始开始开始");
        Object[] obj = invocation.getArgs();
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i] + "****************");
        }
        System.out.println(obj + ">>>>>>>>>");
        System.out.println(obj + ">>>>>>>>>");
        System.out.println(obj + ">>>>>>>>>");
        System.out.println("结束结束结束结束结束结束结束结束结束结束结束结束");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        Enumeration d = properties.propertyNames();
        while(d.hasMoreElements()) {
            Object v = d.nextElement();
            System.out.println("--------------------------" + v);
            System.out.println("--------------------------" + v);
            System.out.println("--------------------------" + v);
            System.out.println("--------------------------" + v);
        }

    }
}
