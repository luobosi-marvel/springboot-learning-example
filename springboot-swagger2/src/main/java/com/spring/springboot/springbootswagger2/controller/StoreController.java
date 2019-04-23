/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.controller;

import com.spring.springboot.springbootswagger2.dto.StoreFrom;
import com.spring.springboot.springbootswagger2.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * StoreController
 * 门店管理
 *
 * @author marvel
 * @since 2019-04-07
 */
@RestController
@RequestMapping("/api/store")
@Api(value = "门店管理服务",description = "门店管理相关接口")
@SuppressWarnings("unchecked")
public class StoreController {

    /**
     * todo
     * 创建新门店
     *
     * @param storeDTO 门店 dto
     * @return boolean
     */
    @PostMapping(value = "/create")
    @ApiOperation(value = "创建一个门店", notes = "创建一个门店信息")
    public JsonResult<Boolean> create(@RequestBody @Validated StoreFrom storeDTO) {
        return JsonResult.builder().data(true).build();

    }

    /**
     * todo
     * 更新一家门店
     *
     * @param storeDTO 门店 dto
     * @return boolean
     */
    @PostMapping(value = "/update")
    @ApiOperation(value = "更新一个门店", notes = "更新一个门店信息")
    public JsonResult<Boolean> update(@RequestBody @Validated StoreFrom storeDTO) {
        return JsonResult.builder().data(true).build();
    }

    /**
     * todo
     * 获取一家门店的详情
     *
     * @param storeId 门店 id
     * @return boolean
     */
    @ApiOperation(value = "获取一个门店详细信息", notes = "获取门店详情")
    @ApiImplicitParam(name = "store_id", value = "门店id", required = true, dataType = "Integer")
    @PostMapping(value = "/detail")
    public JsonResult<StoreFrom> detail(@RequestParam("store_id") @Validated Integer storeId) {
        return JsonResult.builder().data(new StoreFrom()).build();

    }

    /**
     * todo
     * 删除一家门店
     *
     * @param storeId 门店 id
     * @return boolean
     */
    @ApiOperation(value = "删除一家门店", notes = "删除一家门店")
    @ApiImplicitParam(name = "store_id", value = "门店id", required = true, dataType = "Integer")
    @PostMapping(value = "/delete")
    public JsonResult<Boolean> delete(@RequestParam("store_id") @Validated Integer storeId) {

        return JsonResult.builder().data(true).build();

    }


    /**
     * todo 查询分销员和门店关联关系表 distributor_business
     * 根据分销员查询门店列表
     *
     * @param distributorId 分销员 id
     * @return boolean
     */
    @ApiOperation(value = "根据分销员查询门店列表", notes = "根据分销员查询门店列表")
    @ApiImplicitParam(name = "distributor_id", value = "分销员 id", required = true, dataType = "Integer")
    @PostMapping(value = "/list")
    public JsonResult<List<StoreFrom>> list(@RequestParam("distributor_id") @Validated Integer distributorId) {

        return JsonResult.<List<StoreFrom>>builder().data(Arrays.asList(new StoreFrom(), new StoreFrom())).build();

    }

}
