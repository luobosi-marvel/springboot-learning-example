/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.impl;

import com.spring.springboot.service.MarvelServiceFacade;
import org.springframework.stereotype.Service;

/**
 * MarvelServiceImpl
 *
 * @author 萝卜丝
 * @since 2017-09-28
 */
@Service("marvelServiceImpl")
public class MarvelServiceImpl implements MarvelServiceFacade{

    @Override
    public void printMarvel() {
        System.out.println("没错，我就是我，不一样的烟火");
    }
}