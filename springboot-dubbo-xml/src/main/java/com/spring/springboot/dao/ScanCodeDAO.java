/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.dao;

import com.spring.springboot.bo.ScanCode;
import com.spring.springboot.dao.mapper.ScanCodeMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * ScanCodeDAO
 * 扫码DAO
 *
 * @author 萝卜丝
 * @since 2017-09-19
 */
@Repository
public class ScanCodeDAO {

    @Resource
    private ScanCodeMapper scanCodeMapper;


    /**
     * 插入一条扫码信息
     *
     * @param scanCode 扫码数据
     */
    public void insert(ScanCode scanCode) {
        scanCodeMapper.insert(scanCode);
    }

    /**
     * 更新一条扫码信息
     *
     * @param scanCode 扫码数据
     */
    public void update(ScanCode scanCode) {
        scanCodeMapper.update(scanCode);
    }


    /**
     * 查询 CanCode
     *
     * @param customerRegisterId 用户注册Id
     * @return 为null返回 true，否则返回 false
     */
    public ScanCode queryCanCode(String customerRegisterId) {
        return scanCodeMapper.queryByCustomerRegisterId(customerRegisterId);
    }
}