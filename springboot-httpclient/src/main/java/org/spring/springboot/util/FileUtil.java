/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.util;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.spring.springboot.constant.Contants;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * FileUtil
 *
 * @author 萝卜丝
 * @since 2017-11-01
 */
public class FileUtil {

    /**
     * 文件类型转换
     *
     * @param multipartFile
     * @return
     */
    public static File transferToFile(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(Contants.Url.TEMP + fileName);
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            out.write(multipartFile.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new File(Contants.Url.TEMP + fileName);
    }
}