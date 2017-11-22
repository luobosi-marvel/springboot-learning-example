/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.contorller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

/**
 * ExceptionProcess(对文件上传的异常已经拦截)
 *
 * @author 萝卜丝
 * @since 2017-10-27
 */
@ControllerAdvice
public class ExceptionProcess {

    /**
     * 异常处理，返回值处理和 SpringMVC 一样
     *
     * @param throwable 所有异常的父类
     * @return 返回结果
     */
    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    public String handleAll(Throwable throwable) {
        return "超出了文件大小";
    }

}