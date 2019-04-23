/*
 * Copyright (C) 2009-2018 Hangzhou Iroly Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2019-02-13
 * Time: 15:38
 * Description:
 *
 * @author qiezi
 */
public class ResultMap<T> extends HashMap {
    /**
     * 接口调用是否成功，0：失败，1：成功
     */
//    @ApiModelProperty(name = "code", value = "1", notes = "接口调用是否成功，0：失败，1：成功")
    public static final String CODE = "code";
    /**
     * 业务编码 接口调用错误业务编码
     */
//    @ApiModelProperty(name = "errorCode", value = "1", notes = "业务编码 接口调用错误业务编码")
    public static final String ERROR_CODE = "errorCode";
    /**
     * 数据对象 成功需要返回消息，在data里加一个属性（比如：“showMsg”）
     */
//    @ApiModelProperty(name = "data", value = "1", notes = "数据对象 成功需要返回消息，在data里加一个属性（比如：“showMsg”）")
    public static final String DATA = "data";
    /**
     * 错误消息内容
     */
//    @ApiModelProperty(name = "message", value = "1", notes = "错误消息内容")
    public static final String MESSAGE = "message";
    /**
     * 异常
     */
//    @ApiModelProperty(name = "ERROR", value = "0", notes = "异常")
    public static final int ERROR = 0;
    /**
     * 成功
     */
//    @ApiModelProperty(name = "SUCCESS", value = "1", notes = "成功")
    public static final int SUCCESS = 1;

    public ResultMap(T t) {
        //初始化默认为成功
        put(CODE, SUCCESS);
        //如果传入的是result对象类型，则将result对象转换为ResultMap对象,如还有其他转换对象，可以在下面再加一个else,我们尽量统一远程dubbo接口返回对象为Result
        if (t instanceof Result) {
            Result result = (Result) t;
            //当接口调用失败时，返回 errorCode、message两个字段
            if (!result.isSuccess()) {
                put(CODE, ERROR);
                put(ERROR_CODE, result.getResultCode());
                put(MESSAGE, result.getMessage());
            }
            if (null != result.getModel()) {
                put(DATA, result.getModel());
            }
            //当对象为Map时。属于特殊情况， 不需要放到key为data的属性中，直接copy返回
        } else if (t instanceof Map) {
            putAll((Map) t);
        } else {
            put(DATA, t);
        }
    }

    public ResultMap(String errorCode, String message) {
        put(CODE, ERROR);
        put(ERROR_CODE, errorCode);
        put(MESSAGE, message);

    }

    public ResultMap() {
        put(CODE, SUCCESS);  //初始化默认 为 成功
    }

    public ResultMap(boolean success) {
        put(CODE, success ? SUCCESS : ERROR);
    }

    public void setSuccess(boolean success) {
        put(CODE, success ? SUCCESS : ERROR);
    }

    public void setErrorCode(String errorCode) {
        put(ERROR_CODE, errorCode);
    }

    public void setMessage(String message) {
        put(MESSAGE, message);
    }

    public void setData(T t) {
        put(DATA, t);
    }
}

