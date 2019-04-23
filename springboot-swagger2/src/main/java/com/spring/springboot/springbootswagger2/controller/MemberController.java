/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.controller;

import com.spring.springboot.springbootswagger2.from.BackUserFrom;
import com.spring.springboot.springbootswagger2.from.CustomerGroupFrom;
import com.spring.springboot.springbootswagger2.util.JsonResult;
import com.spring.springboot.springbootswagger2.vo.BackUserDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * MemberController
 * 门店员工控制器
 *
 * @author marvel
 * @since 2019-04-06
 */
@RestController
@RequestMapping("/api/back_user")
@Api(value = "员工设置服务",description = "员工相关信息设置接口")
@SuppressWarnings("unchecked")
public class MemberController {



    /**
     * todo
     * 新建员工信息
     *
     * @return boolean
     */
    @ApiOperation(value = "新建员工信息", notes = "新建员工信息")
    @PostMapping(value = "/create_employee")
    public JsonResult<Boolean> create(@RequestBody @Validated BackUserFrom backUserFrom) {
        return JsonResult.builder().data(true).build();
    }


    /**
     * todo
     * 更新员工信息
     *
     * @return boolean
     */
    @ApiOperation(value = "更新员工信息", notes = "更新员工信息")
    @PostMapping(value = "/update_employee")
    public JsonResult<Boolean> update(@RequestBody @Validated BackUserFrom backUserFrom) {

        return JsonResult.builder().data(true).build();
    }

    /**
     * todo
     * 获取员工详细信息
     *
     * @return boolean
     */
    @ApiOperation(value = "获取员工详细信息", notes = "获取员工详细信息")
    @ApiImplicitParam(name = "id", value = "员工 id", required = true, dataType = "Integer")

    @PostMapping(value = "/get_employee_detail")
    public JsonResult<BackUserDetailVO> memberDetail(@RequestParam("id") @Validated Integer id) {
        return JsonResult.builder().data(new BackUserDetailVO()).build();
    }


    /**
     * todo
     * 删除一个员工信息
     *
     * @return boolean
     */
    @ApiOperation(value = "删除一个员工信息", notes = "根据员工id 删除一个员工信息")
    @ApiImplicitParam(name = "id", value = "员工 id", required = true, dataType = "Integer")
    @PostMapping(value = "/delete_employee")
    public JsonResult<Boolean> delete(@RequestParam("id") Integer id) {

        return JsonResult.builder().data(true).build();
    }


    /**
     * todo
     * 根据门店id 查找所有的用户列表
     *
     * @param storeId 门店id
     * @return 用户列表
     */
    @ApiOperation(value = "根据门店id 查找所有的用户列表", notes = "根据门店id 查找所有的用户列表")
    @ApiImplicitParam(name = "store_id", value = "门店 id", required = true, dataType = "Integer")
    @PostMapping(value = "/get_employee_list")
    public JsonResult<List<BackUserDetailVO>> list(@RequestParam("store_id") Integer storeId) {

        return JsonResult.<List<BackUserDetailVO>>builder().data(Arrays.asList(new BackUserDetailVO(), new BackUserDetailVO())).build();
    }
}
