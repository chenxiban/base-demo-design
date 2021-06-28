package com.base.demo.design.lazymode;

/**
 * @Description: 懒汉模式--线程不安全
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.lazymode
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 17:21
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public final class SingletonThreadNoSafety {

    /**
     * 该方法在多线程环境下不能保证单例的唯一性。
     */
    private byte[] data = new byte[1024];

    private static SingletonThreadNoSafety instance = null;

    /**
     * 私有构造函数，不允许外部new
     */
    private SingletonThreadNoSafety() {

    }

    /**
     * 目前此种方式的单例确实满足了懒加载，但是如果有多个访问者同时去获取对象实例你可以想象成一堆人在抢厕所，
     * 就会造成多个同样的实例并存，从而没有达到单例的要求。
     *
     * @return com.base.demo.design.lazymode.SingletonThreadSafety
     * @date 2021/6/26 17:33
     * @author ChenYongJia
     * @version 1.0
     */
    public static SingletonThreadNoSafety getInstance() {
        if (instance == null) {
            instance = new SingletonThreadNoSafety();
        }
        return instance;
    }

}
