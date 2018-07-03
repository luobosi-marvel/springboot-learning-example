/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.marvel.proxy.sp.service.impl;

import com.marvel.proxy.sp.service.MarvelService;
import org.springframework.stereotype.Service;

/**
 * MarvelServiceImpl
 *
 * @author luobosi@2dfire.com
 * @since 2018-06-30
 */
@Service
public class MarvelServiceImpl implements MarvelService {

    @Override
    public void marvel() {
        System.out.println("hello hello hello");
    }
}