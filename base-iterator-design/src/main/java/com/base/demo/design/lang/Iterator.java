package com.base.demo.design.lang;

/**
 * @Description: 迭代器定义
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.lang
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:48
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface Iterator<E> {

    /**
     * 判断是否有下一个元素
     * 这里的这个类和java的jdk中提供的是一样的，这样也方面后续读者可以对照list的Iterator进行源码学习。
     * <p>
     * 方法描述；hasNext，判断是否有下一个元素、next，获取下一个元素。这个在list的遍历中是经常用到的。
     *
     * @return boolean
     * @date 2021/7/3 11:50
     * @author ChenYongJia
     * @version 1.0
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     *
     * @return E
     * @date 2021/7/3 11:50
     * @author ChenYongJia
     * @version 1.0
     */
    E next();

}
