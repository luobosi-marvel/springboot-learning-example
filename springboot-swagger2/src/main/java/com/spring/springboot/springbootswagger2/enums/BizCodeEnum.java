/*
 * Copyright (C) 2009-2018 Hangzhou Iroly Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.enums;

/**
 * Date: 2019-02-13
 * Time: 16:11
 * Description: 异常错误码
 *
 * @author qiezi
 */
public enum BizCodeEnum {

    /**
     * 系统异常
     */
    REQUEST_FAIL_EXCEPTION("1001", "服务异常,请稍后重试! "),
    MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION("1002", "server error,missingServletRequestParameterException! "),
    HTTP_MESSAGE_NOT_READABLE_EXCEPTION("1003", "server error,httpMessageNotReadableException! "),
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION("1004", "server error,methodArgumentNotValidException! "),
    BIND_EXCEPTION("1005", "server error,bindException! "),
    CONSTRAINT_VIOLATION_EXCEPTION("1006", "server error,constraintViolationException! "),
    VALIDATION_EXCEPTION("1007", "server error,validationException! "),
    NO_HANDLER_FOUND_EXCEPTION("1008", "server error,noHandlerFoundException! "),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION("1009", "server error,httpRequestMethodNotSupportedException! "),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION("1010", "server error,httpMediaTypeNotSupportedException! "),
    UN_OAUTH_EXCEPTION("1011", "请先授权!"),
    UN_USER_AGENT_EXCEPTION("1012", "UA错误!"),
    PARAM_INVLID("1013", "参数错误"),

    /**
     * C端错误码
     */
    AUTH_MA_ERROR("1101", "微信小程序授权错误,请稍后重试!"),
    REGISTER_DISTRIBUTOR_ERROR("1102", "注册分销员错误"),
    UPDATE_DISTRIBUTOR_ERROR("1103", "更新分销员信息错误"),
    BIND_BANK_CARD_ERROR("1104", "绑定银行卡错误"),
    REGISTER_FRANCHISEE_ERROR("1105", "注册加盟商错误"),
    GET_DISTRIBUTOR_INFO_ERROR("1106", "获取分销员信息错误"),
    GET_DISTRIBUTOR_PROPERTY_ERROR("1107", "获取分销员资产错误"),
    CREATE_WITHDRAW_FLOW_ERROR("1108", "创建提现流水错误"),
    INVITE_NEW_CUSTOMER_ERROR("1109", "邀请新用户错误"),
    DELETE_NEW_CUSTOMER_ERROR("1110", "删除用户错误"),
    UPDATE_INVITE_RECORD_ERROR("1111", "更新邀请记录状态错误"),
    BALANCE_IS_NOT_ENOUGH("1112", "余额不足"),
    SEND_SMS_CODE_ERROR("1113", "短信验证码获取太频繁, 请重用"),
    SMS_CODE_ERROR("1114", "短信验证码验证错误"),
    REPEAT_PASSWORD_ERROR("1115", "重复密码错误"),
    CHANGE_PASSWORD_ERROR("1116", "修改密码错误"),

    /**
     * B端错误码
     */
    TOKEN_ERROR("1201","token错误"),

    TOKEN_EXPIRED("1202","token过期"),

    PASSWORD_ERROR("1203","密码错误"),

    GET_BACK_USER_ERROR("1204","获取加盟商用户信息错误"),

    UPDATE_BACK_DISTRIBUTOR_ERROR("1205","冻结/解冻分销员信息错误"),

    UPDATE_BACK_CUSTOMER_ERROR("1206","审核客户信息错误"),

    SET_COMMISSION_ERROR("1207","设置佣金比例错误"),

    GET_COMMISSION_ERROR("1208","获取佣金比例错误"),

    AUDIT_WITHDRAW_ERROR("1209","审核提现错误"),

    GET_STORE_INFO_ERROR("1210","获取店铺信息错误"),

    UPDATE_CUSTOMER_ERROR("1211", "更新用户资料失败"),

    AUTHORITY_ERROR("1212", "权限异常"),

    ADD_WEBSITE_CONFIG_ERROR("1213", "添加网站配置失败"),

    UPDATE_WEBSITE_CONFIG_ERROR("1214", "修改网站配置失败"),

    ADD_BANNER_ERROR("1215", "添加banner失败"),

    UPDATE_BANNER_ERROR("1216", "修改banner失败"),

    ADD_STORE_ERROR("1217", "添加store失败"),

    UPDATE_STORE_ERROR("1218", "修改store失败"),
    
    DELETE_STORE_ERROR("1219", "删除store失败"),
    
    ADD_ARTICLE_ERROR("1220", "添加ARTICLE失败"),

    UPDATE_ARTICLE_ERROR("1221", "修改ARTICLE失败"),
    
    QUERY_ARTICLE_ERROR("1222", "查询ARTICLE失败"),

    DELETE_ARTICLE_ERROR("1223", "删除ARTICLE失败"),

    BACKUSER_FRONZE("1224", "加盟商被冻结"),

            ;

    /**
     * 返回码
     */
    private String code;
    /**
     * 错误码描述
     */
    private String message;

    BizCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

