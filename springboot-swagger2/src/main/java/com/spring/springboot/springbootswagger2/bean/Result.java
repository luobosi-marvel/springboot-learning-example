/*
 * Copyright (C) 2009-2018 Hangzhou Iroly Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.bean;

import java.io.Serializable;

/**
 * Date: 2019-02-13
 * Time: 15:36
 * Description:接口返回对象封装常量
 *
 * @author qiezi
 */
public interface Result<T> extends Serializable {

    /**
     * 设置请求成功标志。
     *
     * @param success 成功标志
     */
    void setSuccess(boolean success);

    /**
     * 请求是否成功。
     *
     * @return 如果成功，则返回<code>true</code>
     */
    boolean isSuccess();

    /**
     * 当出现业务异常或系统异常时，返回相应的错误码
     *
     * @return 返回码
     */
    String getResultCode();


    /**
     * 设置返回码
     *
     * @param code
     */
    void setResultCode(String code);

    /**
     * 取得model对象
     *
     * @return model对象
     */
    T getModel();

    /**
     * 设置model对象。
     *
     * @param model model对象
     */
    void setModel(T model);

    /**
     * 返回信息
     *
     * @return
     */
    String getMessage();

    /**
     * 返回错误信息
     *
     * @param message
     */
    void setMessage(String message);

}

