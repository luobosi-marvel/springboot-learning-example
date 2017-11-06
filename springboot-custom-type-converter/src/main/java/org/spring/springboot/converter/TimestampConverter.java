/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.converter;

import org.spring.springboot.bean.DateTimestamp;
import org.spring.springboot.util.DateUtil;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TimestampConverter
 *
 * @author 萝卜丝
 * @since 2017-11-06
 */
public class TimestampConverter implements GenericConverter {

    /**
     * long/Long -> DateTimestamp
     *
     * @return set
     */
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> pairs = new HashSet<>();
        pairs.add(new ConvertiblePair(Long.class, DateTimestamp.class));
        pairs.add(new ConvertiblePair(long.class, DateTimestamp.class));
        pairs.add(new ConvertiblePair(String.class, DateTimestamp.class));
        pairs.add(new ConvertiblePair(Integer.class, DateTimestamp.class));
        pairs.add(new ConvertiblePair(int.class, DateTimestamp.class));
        return pairs;
    }

    @Override
    public Object convert(Object o, TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
        Long timestamp;
        if (o instanceof Long) {
            //long
            timestamp = (Long) o;
        } else if (o instanceof String)
            //string
            timestamp = Long.parseLong((String) o);
        else
            //integer
            timestamp = (Long) o;

        Long formatted = DateUtil.getTimeStemp(DateUtil.formatYMD(new Date(timestamp)));
        return new DateTimestamp(formatted);
    }
}