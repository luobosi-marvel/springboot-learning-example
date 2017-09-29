/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.domain;

import java.io.Serializable;

/**
 * ScanCode（扫码表）
 *
 * @author 萝卜丝
 * @since 2017-09-19
 */
public class ScanCode implements Serializable{

    /**
     * 扫码ID（主键）
     */
    private String scanCodeId;
    /**
     * 顾客注册ID
     */
    private String customerRegisterId;
    /**
     * 销售码
     */
    private long saleCode;
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

    public String getScanCodeId() {
        return scanCodeId;
    }

    public void setScanCodeId(String scanCodeId) {
        this.scanCodeId = scanCodeId;
    }

    public String getCustomerRegisterId() {
        return customerRegisterId;
    }

    public void setCustomerRegisterId(String customerRegisterId) {
        this.customerRegisterId = customerRegisterId;
    }

    public long getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(long saleCode) {
        this.saleCode = saleCode;
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