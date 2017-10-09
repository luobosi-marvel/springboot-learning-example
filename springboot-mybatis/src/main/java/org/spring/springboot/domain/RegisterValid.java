/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.domain;

import lombok.Data;

/**
 * RegisterValid
 * 注册校验表
 * @author 萝卜丝
 * @since 2017-09-19
 */

@Data
public class RegisterValid {

    /**
     * 用户登录Id
     */
    private String userLoginId;
    /**
     * 顾客注册 Id
     */
    private String customerRegisterId;
    /**
     *
     */
    private String registerValidId;
    /**
     * 第一次登录时间
     */
    private long firstLoginTime;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 修改时间
     */
    private long opTime;
    /**
     * 最后修改时间
     */
    private long lastVer;
    /**
     * 是否有效<br/>
     * 1：有效
     * 2：无效
     */
    private int isValid;
}