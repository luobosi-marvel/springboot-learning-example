/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.dao.mapper;


import com.spring.springboot.scp.bo.ScanCode;

/**
 * ScanCodeMapper
 *
 * @author 萝卜丝
 * @since 2017-09-19
 */
public interface ScanCodeMapper {

    /**
     * 插入一条扫码纪录
     * @param scanCode 扫码纪录
     * @return 插入成功返回 1， 失败返回 0
     */
    int insert(ScanCode scanCode);

    /**
     * 根据用户注册ID 返回扫码纪录
     * @param customerRegisterId 用户注册id
     * @return 扫码纪录
     */
    ScanCode queryByCustomerRegisterId(String customerRegisterId);

    /**
     * 更新一条纪录
     * @param scanCode 扫码纪录
     * @return 更新成功返回 1， 失败返回 0
     */
    int update(ScanCode scanCode);
}