package com.base.demo.desgin.factory;

import com.base.demo.desgin.factory.service.ICacheAdapter;
import com.base.demo.design.utils.factory.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: JDK调用处理程序
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.factory
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:37
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }

}
