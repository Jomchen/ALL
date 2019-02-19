package com.jomchen.test.config.freemarker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;

/**
 * create by Jomchen on 2018/12/17
 */
@Configuration
public class Freemarker {

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        /* ---------------------------
            1. 这个是指定视力的根路径
            2. 如果此路径设为“/a/b”，那么视图会视“/a/b”为根路径，
               不管是找资源还是找模板都是在此路径下找
            3. 如果设成“classpath:/”，那么项目的逻辑根视为视图的根；依目前项目配置，
               是 src/main/resource 和 src/main/java
        ---------------------------*/
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:/");
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");
        freeMarkerConfigurer.setFreemarkerVariables(new HashMap<String, Object>() {
            // 模板数据初始化
            {
                put("adminName", "Jomchen");
                put("adminAge", 22);
            }
        });
        return freeMarkerConfigurer;
    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        freeMarkerViewResolver.setPrefix("/template/views/");
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setContentType("text/html; charset=UTF-8");
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setOrder(0);
        freeMarkerViewResolver.setRequestContextAttribute("request");
        freeMarkerViewResolver.setExposeRequestAttributes(true);
        freeMarkerViewResolver.setExposeSessionAttributes(true);
        freeMarkerViewResolver.setExposeSpringMacroHelpers(true);
        return freeMarkerViewResolver;
    }

}
