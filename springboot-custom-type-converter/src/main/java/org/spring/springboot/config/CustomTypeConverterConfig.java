/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.config;

import org.spring.springboot.converter.AmountConverter;
import org.spring.springboot.converter.TimestampConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * CustomTypeConverterConfig
 * 添加我们自定义的转换器到 spring 中
 *
 * @author 萝卜丝
 * @since 2017-11-06
 */
@Configuration
public class CustomTypeConverterConfig {
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @PostConstruct
    public void addConversionConfig() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();
            // 在这里我们需要添加我们自定义的转换器
            genericConversionService.addConverter(new TimestampConverter());
            genericConversionService.addConverter(new AmountConverter());
        }
    }


/*    @Bean
    public ConversionServiceFactoryBean getConversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<GenericConverter> converters = new HashSet<>();
        converters.add(new TimestampConverter());
        bean.setConverters(converters);
        return bean;
    }*/
}