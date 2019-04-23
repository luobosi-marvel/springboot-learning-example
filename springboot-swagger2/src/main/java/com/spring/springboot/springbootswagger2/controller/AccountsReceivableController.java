/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.controller;

import com.spring.springboot.springbootswagger2.dto.StoreFrom;
import com.spring.springboot.springbootswagger2.from.AccountReceivableFrom;
import com.spring.springboot.springbootswagger2.util.JsonResult;
import com.spring.springboot.springbootswagger2.vo.AccountReceivableVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * AccountsReceivableController
 * 收款账户
 *
 * @author marvel
 * @since 2019-04-07
 */
@Api(value = "收款账户服务",description = "收款账户相关接口")
@RestController
@RequestMapping("/api/receipt")
@SuppressWarnings("unchecked")
public class AccountsReceivableController {


    /**
     * todo：根据什么维度来添加的
     * 创建收款账户
     *
     * @param storeDTO 门店 dto
     * @return boolean
     */
    @ApiOperation(value = "创建收款账户", notes = "根据 accountReceivableFrom 创建收款账户")
    @PostMapping(value = "/create")
    public JsonResult<Boolean> create(@RequestBody @Validated AccountReceivableFrom accountReceivableFrom) {
        return JsonResult.builder().data(true).build();
    }

    /**
     * todo
     * 删除一条收款账户信息
     *
     * @param accountReceivableId 收款账户主键id
     * @return boolean
     */
    @ApiOperation(value = "删除一条收款账户信息", notes = "根据 id 删除一条收款账户信息")
    @ApiImplicitParam(name = "account_receivable_id", value = "收款账户id", required = true, dataType = "Integer")
    @GetMapping(value = "/delete")
    public JsonResult<Boolean> delete(@RequestParam("account_receivable_id") @Validated Integer accountReceivableId) {
        return JsonResult.builder().data(true).build();
    }


    /**
     * todo 查询收款账户，根据什么维度来查询？
     * 查询收款账户列表
     *
     * @param distributorId 分销员 id
     * @return boolean
     */
    @ApiOperation(value = "查询收款账户列表", notes = "查询收款账户列表")
    @ApiImplicitParam(name = "store_id", value = "门店 id", required = true, dataType = "Integer")
    @GetMapping(value = "/list")
    public JsonResult<List<AccountReceivableVO>> list(@RequestParam("store_id") @Validated Integer storeId) {
        return JsonResult.<List<AccountReceivableVO>>builder().data(Arrays.asList(new AccountReceivableVO())).build();
    }

}
