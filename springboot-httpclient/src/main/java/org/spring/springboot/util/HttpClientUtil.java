/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.spring.springboot.constant.Contants;
import org.spring.springboot.vo.ResultRrlVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * HttpClientUtil
 *
 * @author 萝卜丝
 * @since 2017-11-01
 */
public class HttpClientUtil {

    public static String saveToOss(File imageFile, String name) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();


        // 把一个普通参数和文件上传给下面这个地址 是一个servlet
        HttpPost httpPost = new HttpPost(Contants.Url.REMOTEURL);

        FileBody file = new FileBody(imageFile);
        StringBody path = new StringBody(Contants.Url.PATH, ContentType.create("text/plain", Consts.UTF_8));
        StringBody projectName = new StringBody(Contants.Url.PROJECTNAME, ContentType.create("text/plain", Consts.UTF_8));
        StringBody rename = new StringBody(name, ContentType.create("text/plain", Consts.UTF_8));

        HttpEntity httpEntity = MultipartEntityBuilder.create()
                .addPart("file", file)
                .addPart("path", path)
                .addPart("projectName", projectName)
                .addPart("rename", rename)
                .build();

        httpPost.setEntity(httpEntity);

        // 发起请求 并返回请求的响应
        CloseableHttpResponse response = httpClient.execute(httpPost);

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            HttpEntity resEntity = response.getEntity();
            String result = EntityUtils.toString(resEntity);
            ResultRrlVO o = JSON.parseObject(result, ResultRrlVO.class);
            return Contants.Url.IMAGETDOWNURLPREFIX + o.getData();
        }

        return "";
    }


    public static String saveToOss(File fileimg) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(Contants.Url.REMOTEURL);
        StringBody path = new StringBody(Contants.Url.PATH);
        StringBody projectName = new StringBody(Contants.Url.PROJECTNAME);
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
            ResultRrlVO o = JSON.parseObject(result, ResultRrlVO.class);
            return Contants.Url.IMAGETDOWNURLPREFIX + o.getData();
        }
        return "";
    }

}