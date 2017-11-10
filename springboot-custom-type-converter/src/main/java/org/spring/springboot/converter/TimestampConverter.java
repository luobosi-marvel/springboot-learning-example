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
     * 添加要转换的类型，如果还需要将 Double 类型转换 Long 类型也需要在下面添加
     * @return set
     */
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> pairs = new HashSet<>();
        // 使 Long 类型可以转成 DateTimestamp 的类型
        pairs.add(new ConvertiblePair(Long.class, DateTimestamp.class));
        // 使 long 类型可以转成 DateTimestamp 的类型
        pairs.add(new ConvertiblePair(long.class, DateTimestamp.class));
        // 使 String 类型可以转成 DateTimestamp 的类型
        pairs.add(new ConvertiblePair(String.class, DateTimestamp.class));
        // 使 Integer 类型可以转成 DateTimestamp 的类型
        pairs.add(new ConvertiblePair(Integer.class, DateTimestamp.class));
        // 使 int 类型可以转成 DateTimestamp 的类型
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