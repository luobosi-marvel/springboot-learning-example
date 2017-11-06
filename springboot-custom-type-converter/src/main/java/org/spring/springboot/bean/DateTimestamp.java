/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.bean;

import lombok.Getter;

/**
 * DateTimestamp
 *
 * @author 萝卜丝
 * @since 2017-11-06
 */
public class DateTimestamp {

    @Getter
    private Long timestamp;

    public DateTimestamp(Long timestamp) {
        if (timestamp == null)
            throw new NullPointerException("timestamp is null!");
        this.timestamp = timestamp;
    }
}