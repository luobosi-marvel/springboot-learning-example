/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.filter;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * MarvelFilter
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-12
 */
//@Activate
public class MarvelFilter implements Filter{

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("marvel");
        return null;
    }
}