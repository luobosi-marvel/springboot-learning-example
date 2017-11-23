/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.mapper;

import com.spring.springboot.domain.AccountDO;
import org.apache.ibatis.annotations.Param;
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
     * 获取总纪录数
     *
     * @return 总纪录数
     */
    long getPageCounts();

    /**
     * 查找用户信息
     *
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return           用户集合类
     */
    List<AccountDO> findAccounts(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);
}