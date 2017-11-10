/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.converter;

import org.spring.springboot.bean.Amount;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.HashSet;
import java.util.Set;

/**
 * AmountConverter
 * 自定义属性转换器
 *
 * @author 萝卜丝
 * @since 2017-11-10
 */
public class AmountConverter implements GenericConverter {

    /**
     * long/Long -> 将金额扩大 100 倍
     *
     * @return set
     */
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> pairs = new HashSet<>();
        pairs.add(new ConvertiblePair(Long.class, Amount.class));
        pairs.add(new ConvertiblePair(String.class, Amount.class));
        return pairs;
    }

    @Override
    public Object convert(Object o, TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
        Long amount = 0L;
        if (o instanceof Long) {
            amount = (Long) o;
        } else if (o instanceof String) {
            amount = Long.parseLong((String) o);
        }
        return new Amount(amount * 100);
    }
}