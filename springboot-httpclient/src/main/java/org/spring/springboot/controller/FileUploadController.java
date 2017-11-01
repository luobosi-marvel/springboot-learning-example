/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.controller;

import org.spring.springboot.util.FileUtil;
import org.spring.springboot.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileUploadController
 *
 * @author 萝卜丝
 * @since 2017-11-1
 */
@Controller
public class FileUploadController {

    @Value("${image.type}")
    private String suffixList;

    @GetMapping("/file")
    public String file() {
        return "file";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file")MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();

            if (isNotContains(fileName)) {
                return "非法格式";
            }

            InputStream inputStream = file.getInputStream();


            return HttpClientUtil.saveToOss(FileUtil.transferToFile(file));
        }
            return null;
    }

    /**
     * 判断是否为允许的上传文件类型,true表示允许
     */
    private boolean isNotContains(String fileName) {
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".")
                + 1, fileName.length());
        if (suffixList.contains(suffix.trim().toLowerCase())) {
            return false;
        }
        return true;
    }


}