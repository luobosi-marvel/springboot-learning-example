/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.domain.base;

import lombok.Data;

import java.io.Serializable;

/**
 * DO基类
 */
@Data
public abstract class Base implements Serializable {

    private static final long serialVersionUID = -6063070493950685513L;

    /**
     * 是否有效，0:无效；1:有效
     */
    private int isValid = 1;

    /**
     * 创建时间
     */
    private long createTime = System.currentTimeMillis();

    /**
     * 操作时间
     */
    private long opTime = System.currentTimeMillis();

    /**
     * 版本号
     */
    private int lastVer = 1;

}
