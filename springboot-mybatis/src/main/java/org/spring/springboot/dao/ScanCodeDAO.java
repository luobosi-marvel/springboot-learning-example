/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.dao;

import com.dfire.soa.consumer.fm.bo.ScanCode;
import com.dfire.soa.consumer.fm.dao.mapper.ScanCodeMapper;

import javax.annotation.Resource;

/**
 * ScanCodeDAO
 * 扫码DAO
 * @author 萝卜丝
 * @since 2017-09-19
 */
public class ScanCodeDAO {

    @Resource
    private ScanCodeMapper scanCodeMapper;

    /**
     * 插入一条扫码信息
     * @param scanCode 扫码信息
     * @return 插入成功返回 1， 失败返回 0
     */
    public int insert(ScanCode scanCode) {
        return scanCodeIsNull(scanCode.getCustomerRegisterId()) ? scanCodeMapper.insert(scanCode) : 0;
    }

    /**
     * 判断用户第一次登录时间是否为空
     * @param customerRegisterId 用户注册Id
     * @return 为null返回 true，否则返回 false
     */
    private boolean scanCodeIsNull(String customerRegisterId) {
        return scanCodeMapper.queryByCustomerRegisterId(customerRegisterId) == null;
    }
}