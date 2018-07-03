package com.marvel.proxy.sp.factory;

import com.marvel.proxy.sp.proxy.MyProxy;
import com.marvel.proxy.sp.service.TestService;
import com.marvel.proxy.sp.service.impl.TestServiceImpl;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;


public class MyProxyFactory<T> implements FactoryBean<T> {

    private Class<T> interfaceClass;
    public Class<T> getInterfaceClass() {
        return interfaceClass;
    }
    public void setInterfaceClass(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(TestService.class.getClassLoader(),
                new Class<?>[]{TestService.class},
                new MyProxy(new TestServiceImpl()));

    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

    @Override
    public boolean isSingleton() {
        // 单例模式
        return true;
    }

}