/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.repository;

import com.spring.springboot.scp.bean.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * UserInfoRepository
 *
 * @author 萝卜丝
 * @since 2017-09-12
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    /**
     * 通过 username 查找用户信息
     * @param name 用户账号
     * @return 查找之后的对象
     */
    UserInfo findByName(String name);
}