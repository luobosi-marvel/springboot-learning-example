/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.smp.dao.mapper;

import com.spring.springboot.smp.domain.AccountDO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AccountMapper
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@Component
public interface AccountMapper {

    /**
     * 插入一个用户
     *
     * @param accountDO 用户实体
     * @return  影响的记录数
     */
    int insert(AccountDO accountDO);

    /**
     * 更新一个用户
     *
     * @param accountDO 用户实体
     * @return  影响的记录数
     */
    int update(AccountDO accountDO);

    /**
     * 删除一个用户
     *
     * @param accountId 用户id
     * @return  影响的纪录数
     */
    int delete(String accountId);

    /**
     * 用户分页查询
     *
     * @param start    起始
     * @param end      结束
     * @return         范围内的数据
     */
    List<AccountDO> listRange(int start, int end);
}