package com.jomchen.test.mybatis.mapper;

import com.jomchen.test.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by Jomchen on 2018/12/18
 */
@Mapper
public interface UserMapper {

    User queryById(@Param("id") String id);

    int add(User user);

    List<User> getList();

}
