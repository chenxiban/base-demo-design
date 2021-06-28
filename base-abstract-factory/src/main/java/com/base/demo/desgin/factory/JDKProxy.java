package com.base.demo.desgin.factory;

import com.base.demo.desgin.factory.service.ICacheAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description: JDK
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.factory
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:37
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }

}
