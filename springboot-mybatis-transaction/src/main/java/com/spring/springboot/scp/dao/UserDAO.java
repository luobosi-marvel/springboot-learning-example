/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.dao;

import com.spring.springboot.scp.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDAO
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */
@Repository
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
            @Result(property = "startTime", column = "start_time"),
    })
    User findByName(@Param("name") String name);


    @Insert({"INSERT account SET id=#{id}, name=#{name}, password=#{password}, age=#{age}, start_time=#{startTime}"})
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