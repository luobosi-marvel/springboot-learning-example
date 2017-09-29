/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.domain;

/**
 * RegisterValid
 * 注册校验表
 * @author 萝卜丝
 * @since 2017-09-19
 */
public class RegisterValid {

    /**
     * 用户登录Id
     */
    private String userLoginId;
    /**
     * 顾客注册 Id
     */
    private String customerRegisterId;
    /**
     *
     */
    private String registerValidId;
    /**
     * 第一次登录时间
     */
    private long firstLoginTime;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 修改时间
     */
    private long opTime;
    /**
     * 最后修改时间
     */
    private long lastVer;
    /**
     * 是否有效<br/>
     * 1：有效
     * 2：无效
     */
    private int isValid;

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getCustomerRegisterId() {
        return customerRegisterId;
    }

    public void setCustomerRegisterId(String customerRegisterId) {
        this.customerRegisterId = customerRegisterId;
    }

    public long getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(long firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    public String getRegisterValidId() {
        return registerValidId;
    }

    public void setRegisterValidId(String registerValidId) {
        this.registerValidId = registerValidId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getOpTime() {
        return opTime;
    }

    public void setOpTime(long opTime) {
        this.opTime = opTime;
    }

    public long getLastVer() {
        return lastVer;
    }

    public void setLastVer(long lastVer) {
        this.lastVer = lastVer;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }
}