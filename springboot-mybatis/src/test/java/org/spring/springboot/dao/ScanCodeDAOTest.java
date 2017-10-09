/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.dao;

import org.junit.Test;
import org.spring.springboot.BaseTest;

import javax.annotation.Resource;

/**
 * ScanCodeDAOTest
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */
public class ScanCodeDAOTest extends BaseTest{

    @Resource
    private ScanCodeDAO scanCodeDAO;

    @Test
    public void testInsert() {
        System.out.println(scanCodeDAO);
    }
}