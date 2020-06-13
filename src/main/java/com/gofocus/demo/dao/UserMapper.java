package com.gofocus.demo.dao;

import com.gofocus.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: GoFocus
 * @Date: 2020-06-07 18:15
 * @Description:
 */

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findUserById(@Param("id") Integer id);

    @Select("select * from user where username = #{username}")
    User findUserByUsername(@Param("username") String username);

    @Insert("insert into user (username,encrypted_password,created_at,modified_at) values (#{username},#{password},now(),now())")
    void save(@Param("username") String username, @Param("password") String password);
}
