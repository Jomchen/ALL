package com.lemonwind.test.config.mybatis;


import com.alibaba.druid.pool.DruidDataSource;
import com.lemonwind.test.model.User;
import com.lemonwind.test.mybatis.mapper.UserMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * create by lemonwind on 2018/12/17
 */
public class MybatisConfig {

    public static void main(String[] args) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://192.168.0.105:3306/test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&useSSL=false");
        druidDataSource.setUsername("lemonwind");
        druidDataSource.setPassword("lemonwind");
        druidDataSource.setMaxActive(20);
        druidDataSource.setInitialSize(1);
        druidDataSource.setMaxWait(60000);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, druidDataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);

        configuration.addMapper(UserMapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = null;

        int k = 2;
        User user = new User(
                ""+k,
                "姓名"+k,
                20+k,
                "地址",
                "",
                false,
                20190130161600L+k,
                20190130161600L+k
        );


        /*try {
            sqlSession = sqlSessionFactory.openSession(false);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int jj = userMapper.add(user);
            System.out.println(jj + "------------------------->");
            System.out.println(jj + "------------------------->");
            System.out.println(jj + "------------------------->");
        } finally {
            sqlSession.close();
        }*/

        try {
            sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User result = userMapper.queryById("0");
            System.out.println("。。。。。。。。。。。。。。。。。。。 >>");
            System.out.println(result);
            System.out.println("。。。。。。。。。。。。。。。。。。。 >>");
        } finally {
            sqlSession.close();
        }
    }


}
