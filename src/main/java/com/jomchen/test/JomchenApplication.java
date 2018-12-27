package com.jomchen.test;

import com.jomchen.test.mybatis.mapper.ThirdUserWechatMapper;
import com.jomchen.test.model.ThirdUserWechat;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * create by Jomchen on 2018/11/19
 */
@SpringBootApplication
@PropertySource({"service.properties"})
@ImportResource({"mybatis-config.xml"})
public class JomchenApplication {

    public static void main(String[] args) {
        SpringApplication.run(JomchenApplication.class, args);
    }

    /*public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ThirdUserWechatMapper thirdUserWechatMapper = sqlSession.getMapper(ThirdUserWechatMapper.class);
        *//*ThirdUserWechat2Mapper thirdUserWechatMapper = sqlSession.getMapper(ThirdUserWechat2Mapper.class);*//*
        ThirdUserWechat thirdUserWechat = thirdUserWechatMapper.queryById("12345");
        System.out.println("START 。。。。。。。。。。。。。。。。。 START");
        System.out.println("START 。。。。。。。。。。。。。。。。。 START");
        System.out.println(thirdUserWechat);
        System.out.println("END 。。。。。。。。。。。。。。。。。 END");
        System.out.println("END 。。。。。。。。。。。。。。。。。 END");
    }*/

}
