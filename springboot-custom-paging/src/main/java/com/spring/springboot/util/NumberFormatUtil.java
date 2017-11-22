/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.util;

import javax.servlet.http.HttpServletRequest;

/**
 * NumberFormatUtil 数字格式转换的工具类
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
public class NumberFormatUtil {

    /**
     * 将 request 域里的指定的值转换成 int 类型
     * @param request   request 域对象
     * @param key       指定参数的 key
     * @return          转换之后的值
     */
    public static Long procRequestLong(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        if (value == null || "".equals(value)) {
            value = "0";
        }
        return Long.parseLong(value);

    }
}