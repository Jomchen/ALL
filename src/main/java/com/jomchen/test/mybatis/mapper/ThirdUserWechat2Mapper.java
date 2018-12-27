package com.jomchen.test.mybatis.mapper;

import com.jomchen.test.model.ThirdUserWechat;
import org.apache.ibatis.annotations.Select;

/**
 * create by Jomchen on 2018/12/18
 */
public interface ThirdUserWechat2Mapper {

    @Select("SELECT * FROM third_user_wechat WHERE id = #{id}")
    ThirdUserWechat queryById(String id);

}
