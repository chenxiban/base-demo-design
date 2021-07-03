package com.base.demo.design.lang;

/**
 * @Description: 集合功能接口定义
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.lang
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:48
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface Collection<E, L> extends Iterable<E> {

    /**
     * 这里我们定义集合操作接口；Collection，同时继承了另外一个接口Iterable的方法iterator()。
     * <p>
     * 这样后续谁来实现这个接口，就需要实现上述定义的一些基本功能；添加元素、删除元素、遍历。
     * <p>
     * 同时你可能注意到这里定义了两个泛型<E, L>，因为我们的数据结构一个是用于添加元素，另外一个是用于添加树节点的链路关系。
     *
     * @param e
     * @return boolean
     * @date 2021/7/3 11:50
     * @author ChenYongJia
     * @version 1.0
     */
    boolean add(E e);

    /**
     * 移除
     *
     * @param e
     * @return boolean
     * @date 2021/7/3 11:51
     * @author ChenYongJia
     * @version 1.0
     */
    boolean remove(E e);

    /**
     * 添加链路
     *
     * @param key
     * @param l
     * @return boolean
     * @date 2021/7/3 11:51
     * @author ChenYongJia
     * @version 1.0
     */
    boolean addLink(String key, L l);

    /**
     * 移除链路
     *
     * @param key
     * @return boolean
     * @date 2021/7/3 11:51
     * @author ChenYongJia
     * @version 1.0
     */
    boolean removeLink(String key);

    /**
     * 迭代器
     *
     * @return com.base.demo.design.lang.Iterator<E>
     * @date 2021/7/3 11:51
     * @author ChenYongJia
     * @version 1.0
     */
    Iterator<E> iterator();

}
