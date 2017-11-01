/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.util;

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

import java.io.File;
import java.io.IOException;

/**
 * HttpClientUtil
 *
 * @author 萝卜丝
 * @since 2017-11-01
 */
public class HttpClientUtil {

    public static String saveToOss(File fileimg, String uploadUrl, String project, String uppath, String httpClientDownUrl) throws IOException {
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
        if (statusCode == HttpStatus.SC_OK) {
            HttpEntity resEntity = response.getEntity();
            String result = EntityUtils.toString(resEntity);
            //ResultUrlVo o = JSON.parseObject(result, ResultUrlVo.class);
            return httpClientDownUrl + "/" ;//o.getData();
        }
        return "";
    }

    /**
     * 测试http请求是否可以调用
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String remoteUrl = "http://upload.2dfire-daily.com/uploadfile";
        String path = "wechatactivity/activity_a/mchId";
        String projectName = "WeChatActivity";
        File file = new File("E://img/1/1.png");
        String httpClientDownUrl = "http://download.2dfire.com";
        String downFiles = "http://download.2dfire.com/downfiles";
        // String result = saveToOss(file, remoteUrl, projectName, path, httpClientDownUrl);
        String result = getDownUrl("wechatactivity/activity_a/time/7c591345dc467d7e1606c10f5c7579b8.jpg,wechatactivity/activity_a/time/7c591345dc467d7e1606c10f5c7579b8.jpg", downFiles, projectName);
        //打印目标文件的服务器地址
        System.out.println(result);
    }

    /**
     * @param file          目录名称
     * @param httpClientUrl 下载地址
     * @param project       项目名
     * @return 返回zip包的url地址
     */
    public static String getDownUrl(String file, String httpClientUrl, String project) throws IOException {
        String resultUrl = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(httpClientUrl);
        StringBody fileNames = new StringBody(file);
        StringBody projectName = new StringBody(project);
        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("projectName", projectName);
        reqEntity.addPart("fileNames", fileNames);
        post.setEntity(reqEntity);
        HttpResponse response = httpClient.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            HttpEntity resEntity = response.getEntity();
            String result = EntityUtils.toString(resEntity);
            //ResultUrlVo o = JSON.parseObject(result, ResultUrlVo.class);
            //resultUrl = o.getData() + o.getMessage() + "  " + o.getCode();
        }
        return null;

    }


}