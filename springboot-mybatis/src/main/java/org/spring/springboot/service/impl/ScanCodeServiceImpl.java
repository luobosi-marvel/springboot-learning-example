/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.service.impl;

import org.spring.springboot.dao.ScanCodeDAO;
import org.spring.springboot.domain.ScanCode;
import org.spring.springboot.service.ScanCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ScanCodeServiceImpl
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */
@Service
public class ScanCodeServiceImpl implements ScanCodeService{

    @Resource
    private ScanCodeDAO scanCodeDAO;

    @Override
    public void insert(ScanCode scanCode) {
        scanCodeDAO.insert(scanCode);
    }
}