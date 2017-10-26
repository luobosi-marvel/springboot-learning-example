/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.dao;

import com.spring.springboot.bean.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * AccountDAO
 *
 * @author 萝卜丝
 * @since 2017-10-21
 */
@Component
@Mapper
public interface AccountDAO {


    /**
     * 根据用户名查找用户信息
     *
     * @param name 用户名
     */
    @Select("SELECT * FROM account WHERE name = #{name}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "accountState", column = "account_state"),
    })
    Account findByName(@Param("name") String name);

    @Insert({"INSERT INTO account SET id = #{id}, name= #{name}, password = #{password}, " +
            "account_state = #{accountState}"})
    void insert(Account account);
}