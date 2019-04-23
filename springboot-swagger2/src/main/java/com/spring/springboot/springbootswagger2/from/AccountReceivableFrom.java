/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.from;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * AccountReceivableFrom
 *
 * @author marvel
 * @since 2019-04-14
 */
@Data
@ApiModel(value = "accountReceivableFrom", description="收款账户信息")
public class AccountReceivableFrom implements Serializable {

    @ApiModelProperty(name = "门店id", value = "12345", required = true)
    private Integer storeId;
    @ApiModelProperty(name = "收款账户名称", value = "工商银行", required = true)
    private String accountName;
    @ApiModelProperty(name = "收款账户", value = "4552222222", required = true)
    private String receiptNumber;

}
