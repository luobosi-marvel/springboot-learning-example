/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.proxy.sp.service.impl;

import com.marvel.proxy.sp.service.MarvelService;
import com.marvel.proxy.sp.service.TestService;

import javax.annotation.Resource;

/**
 * TestServiceImpl
 *
 * @author luobosi@2dfire.com
 * @since 2018-06-30
 */
public class TestServiceImpl implements TestService{

    @Resource
    private MarvelService marvelService;

    @Override
    public void sayHello() {
        System.out.println(marvelService);
        // marvelService.marvel();
        System.out.println("hello marvel");
    }

}