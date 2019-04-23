/*
 * Copyright (C) 2009-2018 Hangzhou Iroly Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.util;

import com.spring.springboot.springbootswagger2.bean.ResultMap;
import com.spring.springboot.springbootswagger2.enums.BizCodeEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * Date: 2019-02-13
 * Time: 16:41
 * Description:
 *
 * @author qiezi
 */
public class ApiResultUtil {

    /**
     * 错误码
     */
    public static final String FAIL_CODE = "0";

    /**
     * 默认的返回结果
     *
     * @return Result
     */
    public static ResultMap defaultResult() {
        return new ResultMap();
    }

    /**
     * 成功的返回结果
     *
     * @param data 返回内容
     * @return Result
     */
    public static ResultMap successResult(Object data) {
        ResultMap result = defaultResult();
        result.setData(data);
        return result;
    }

    /**
     * 失败的返回结果
     *
     * @param errorCode    返回码
     * @param errorMessage 错误信息
     * @return Result
     */
    public static ResultMap failResult(String errorCode, String errorMessage) {
        ResultMap result = defaultResult();
        result.setSuccess(false);
        if (StringUtils.isBlank(errorCode)) {
            result.setErrorCode(FAIL_CODE);
        } else {
            result.setErrorCode(errorCode);
        }
        result.setMessage(errorMessage);
        return result;
    }

    public static ResultMap failResult(BizCodeEnum bizCodeEnum) {
        return failResult(bizCodeEnum.getCode(), bizCodeEnum.getMessage());
    }
}

