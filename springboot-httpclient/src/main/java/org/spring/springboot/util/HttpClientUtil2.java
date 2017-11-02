/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.spring.springboot.constant.Contants;
import org.spring.springboot.vo.ResultRrlVO;

import java.io.File;
import java.io.IOException;

/**
 * HttpClientUtil2
 *
 * @author 萝卜丝
 * @since 2017-11-01
 */
public class HttpClientUtil2 {


    public static String saveToOss(File fileimg, String uploadUrl, String project, String uppath) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(uploadUrl);
        StringBody path = new StringBody(uppath);
        StringBody projectName = new StringBody(project);
        //文件参数
        FileBody file = new FileBody(fileimg);
        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("file", file);
        reqEntity.addPart("path", path);
        reqEntity.addPart("projectName", projectName);
        post.setEntity(reqEntity);
        HttpResponse response = httpClient.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
/*        if (statusCode == HttpStatus.SC_OK) {
            HttpEntity resEntity = response.getEntity();
            String result = EntityUtils.toString(resEntity);
            ResultRrlVO o = JSON.parseObject(result, ResultRrlVO.class);
            return Contants.Url.IMAGETDOWNURLPREFIX + o.getData();
        }*/
        return "";
    }



    /**
     * 测试http请求是否可以调用
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String remoteUrl = Contants.Url.REMOTEURL;
        String path = Contants.Url.PATH;
        String projectName = Contants.Url.PROJECTNAME;
        File file = new File("D://temp//f3ed3709f26d7ffbebe3a46315fd41f3.jpg");
        String result = saveToOss(file, remoteUrl, projectName, path);
        System.out.println(result);
    }

}