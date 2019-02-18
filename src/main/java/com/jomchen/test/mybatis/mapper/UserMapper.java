package com.jomchen.test.mybatis.mapper;

import com.jomchen.test.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * create by Jomchen on 2018/12/18
 */
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User queryById(@Param("id") String id);

    @Insert(
            "INSERT INTO user(id,username,age,address,remark,deletec,create_time,update_time) VALUES(" +
            "#{id},#{username},#{age},#{address},#{remark},#{deletec},#{createTime},#{updateTime}" +
            ")"
    )
    int add(User user);

    List<User> getList();

}
