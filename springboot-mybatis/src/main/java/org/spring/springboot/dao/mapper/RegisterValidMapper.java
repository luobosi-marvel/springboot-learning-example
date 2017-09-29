/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.dao.mapper;


import org.spring.springboot.domain.RegisterValid;

/**
 * RegisterValidMapper
 *
 * @author 萝卜丝
 * @since 2017-09-19
 */
public interface RegisterValidMapper {

    /**
     * 往注册校验表中插入一条数据
     * @param registerValid 注册校验信息
     * @return 插入成功返回 1， 失败返回 0
     */
    int insert(RegisterValid registerValid);

    /**
     * 根据用户 id 查询该用户第一次登录时间
     * @param userLoginId 用户id
     * @return 第一次登录时间
     */
    long queryByUserLoginId(String userLoginId);
}