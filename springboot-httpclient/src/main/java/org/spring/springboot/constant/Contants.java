/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.constant;

/**
 * Contants
 *
 * @author 萝卜丝
 * @since 2017-11-01
 */
public class Contants {

    /**
     * 关于 url 的一下常量
     */
    public interface Url {
        /** 远程地址 */
        String REMOTEURL = "http://upload.2dfire-daily.com/uploadfile";
        /** 项目接口 */
        String PROJECTNAME = "AdvertisingPlatform";

        String PATH = "advertisingplatform";
        /** 图片下载地址前缀 */
        String IMAGETDOWNURLPREFIX = " https://download.2dfire.com/";

        /** 临时文件夹 */
        String TEMP = "D:\\temp\\";
    }


}