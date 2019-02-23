package com.jomchen.test.services;

import com.jomchen.test.model.User;
import com.jomchen.test.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;

    public User queryById(String id) {
        return userMapper.queryById(id);
    }

}
