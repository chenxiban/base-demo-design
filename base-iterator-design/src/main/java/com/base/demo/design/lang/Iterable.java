package com.base.demo.design.lang;

/**
 * @Description: 可迭代接口定义
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.lang
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:48
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface Iterable<E> {

    /**
     * 这个接口中提供了上面迭代器的实现Iterator的获取，也就是后续在自己的数据结构中需要实现迭代器的功能并交给Iterable，由此让外部调用方进行获取使用。
     *
     * @return com.base.demo.design.lang.Iterator<E>
     * @date 2021/7/3 11:50
     * @author ChenYongJia
     * @version 1.0
     */
    Iterator<E> iterator();

}
