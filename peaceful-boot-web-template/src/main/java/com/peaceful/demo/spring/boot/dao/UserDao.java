package com.peaceful.demo.spring.boot.dao;

import com.peaceful.demo.spring.boot.domin.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author WangJun
 * @version 1.0 16/6/4
 */
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User findById(long id);


}
