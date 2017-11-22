/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.domain.base;

import lombok.Data;

import java.io.Serializable;

/**
 * Base
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@Data
public abstract class Base implements Serializable{
    private static final long serialVersionUID = -4345674787359789811L;

    /** 是否有效，0:无效；1:有效 */
    private int isValid = 1;
    /** 创建时间 */
    private long createTime = System.currentTimeMillis();
    /** 操作时间 */
    private long opTime = System.currentTimeMillis();
    /** 版本号 */
    private int lastVer = 1;
}