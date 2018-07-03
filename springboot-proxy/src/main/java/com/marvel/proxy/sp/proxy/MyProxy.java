package com.marvel.proxy.sp.proxy;

import com.marvel.proxy.sp.service.TestService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * MyProxy
 *
 * @author luobosi@2dfire.com
 * @since 2018-06-30
 */
public class MyProxy implements InvocationHandler {

    private TestService testService;

    public MyProxy(TestService testService) {
        this.testService = testService;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(testService, args);
        after();
        return null;
    }

    /**
     * 该方法是在目标方法调用前触发
     */
    private void before () {
        System.out.println("我是代理方法，在被代理方法之前调用----before");
    }

    /**
     * 该方法是在目标方法之后调用
     */
    private void after () {
        System.out.println("我是代理方法，在被代理方法之后调用----after");
    }
}