/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.dao;

import org.junit.Test;
import org.spring.springboot.BaseTest;
import org.spring.springboot.dao.mapper.ScanCodeMapper;
import org.spring.springboot.domain.ScanCode;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * ScanCodeDAOTest
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */
public class ScanCodeDAOTest extends BaseTest{

    @Resource
    private ScanCodeMapper scanCodeMapper;

    @Test
    public void testInsert() {
        ScanCode scanCode = new ScanCode();
        scanCode.setScanCodeId(UUID.randomUUID().toString());
        scanCode.setCustomerRegisterId(UUID.randomUUID().toString());
        scanCodeMapper.insert(scanCode);
    }
}