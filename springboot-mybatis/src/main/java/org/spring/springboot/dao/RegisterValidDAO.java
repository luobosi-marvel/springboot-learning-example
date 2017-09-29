/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.dao;


import org.spring.springboot.dao.mapper.RegisterValidMapper;
import org.spring.springboot.domain.RegisterValid;

import javax.annotation.Resource;

/**
 * RegisterValidDAO
 * 注册校验 DAO
 * @author 萝卜丝
 * @since 2017-09-19
 */
public class RegisterValidDAO {

    @Resource
    private RegisterValidMapper registerValidMapper;

    /**
     * 插入一条注册校验信息
     * @param registerValid 注册校验信息
     * @return 插入成功返回 1， 失败返回 0
     */
    public int insert(RegisterValid registerValid) {
        // 如果用户第一次登录时间为空则插入一条注册校验信息，否则不插入
        return firstLoginTimeIsEmpty(registerValid.getUserLoginId()) ? registerValidMapper.insert(registerValid) : 0;
    }

    /**
     * 判断用户第一次登录时间是否为空
     * @return 为空返回 true，否则返回 false
     */
    private boolean firstLoginTimeIsEmpty(String userLoginId) {
        return registerValidMapper.queryByUserLoginId(userLoginId) == 0;
    }
}