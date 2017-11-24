/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.util;

/**
 * StringUtil
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-24
 */
public class StringUtil {

    public static void main(String[] args) {
        String str = new String("marvel");

        getString(str);

        System.out.println(str);
    }

    public static void getString(String s) {
        s = "luobosi";
    }

}