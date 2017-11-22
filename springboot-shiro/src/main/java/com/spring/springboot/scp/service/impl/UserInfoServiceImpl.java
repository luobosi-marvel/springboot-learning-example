/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.service.impl;

import com.spring.springboot.scp.bean.UserInfo;
import com.spring.springboot.scp.repository.UserInfoRepository;
import com.spring.springboot.scp.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserInfoServiceImpl
 *
 * @author 萝卜丝
 * @since 2017-09-12
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByName(String name) {
        System.out.println("UserInfoServiceImpl.findByUsername");
        return this.userInfoRepository.findByName(name);
    }
}