/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.dao;

import com.spring.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * UserDAO
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */
@Mapper
public interface UserDAO {

    /**
     * 根据名字查找用户信息
     *
     * @param name 用户名
     */
    @Select("SELECT * FROM account WHERE name=#{name}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "age", column = "age"),
    })
    User findByName(@Param("name") String name);


    @Insert("INSERT account SET id=#{id}, name=#{name}, password=#{password}, age=#{age}")
    int insert(User user);

    @Delete("DELETE FROM account WHERE id=#{id}")
    void deleteById(int id);

    @Update("update account set name=#{name},age=#{age} where id=#{id}")
    void update(User user);

    @Select("select * from account where id=#{id}")
    User getUser(int id);

    @Select("select * from account")
    List<User> getAllUsers();

}