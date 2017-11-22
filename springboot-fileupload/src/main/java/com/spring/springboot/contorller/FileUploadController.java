/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.contorller;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * FileUploadController
 *
 * @author 萝卜丝
 * @since 2017-09-15
 */
@Controller
public class FileUploadController {

    @Value("${image.type}")
    private String suffixList;

    @GetMapping("/file")
    public String file() {
        return "file";
    }

    @GetMapping("/mutifile")
    public String mutifile() {
        return "mutifile";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestBody MultipartFile file,
                                   @RequestParam("name") String name,
                                   @RequestParam("file_size") Integer fileSize) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();

            if (isNotContains(fileName)) {
                return "非法格式";
            }

            try {
                /*
                    这段代码执行完成之后，图片上传到了工程的根路径；
                 */
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (Exception e) {
                System.out.println("上传失败");
                e.printStackTrace();
            }
            return "上传成功";
        } else {
            return "上传成功";
        }
    }



    @PostMapping("/batch/upload")
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        boolean isMutipart = ServletFileUpload.isMultipartContent(request);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); i++) {
            // 分别获取每个文件内容
            file = files.get(i);
            // 如果文件不为空，则将文件读取出来
            if (!file.isEmpty()) {
                try {
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(file.getBytes());
                    stream.flush();
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                continue;
            }
        }

        return "文件上传成功";
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