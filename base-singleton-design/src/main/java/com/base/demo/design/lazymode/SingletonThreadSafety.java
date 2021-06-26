package com.base.demo.design.lazymode;

/**
 * @Description: 懒汉模式--线程安全
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.lazymode
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 17:21
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class SingletonThreadSafety {// 该方法在多线程环境下不能保证单例的唯一性。

    /**
     * 实例化变量
     */
    private byte[] data = new byte[1024];

    private static SingletonThreadSafety instance = null;

    /**
     * 私有构造函数，不允许外部new
     */
    private SingletonThreadSafety() {

    }

    /**
     * 等到需要使用时进行创建，此种模式虽然是安全的，但由于把锁加到方法上后，
     * 所有的访问都因需要锁占用导致资源的浪费。如果不是特殊情况下，不建议此种方式实现单例模式。
     *
     * @return com.base.demo.design.lazymode.SingletonThreadNoSafety
     * @date 2021/6/26 17:31
     * @author ChenYongJia
     * @version 1.0
     */
    public static synchronized SingletonThreadSafety getInstance() {
        if (instance == null) {
            instance = new SingletonThreadSafety();
        }
        return instance;
    }


}
