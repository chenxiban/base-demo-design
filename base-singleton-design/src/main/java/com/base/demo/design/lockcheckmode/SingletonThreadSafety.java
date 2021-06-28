package com.base.demo.design.lockcheckmode;

/**
 * @Description: 双重校验锁--线程安全
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.lockcheckmode
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 17:24
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public final class SingletonThreadSafety {

    /**
     * volatile 关键字会强制的保证线程的可见性，而不加这个关键字，JVM也会尽力去保证可见性，但如果CPU一直处于繁忙状态就不确定了
     * volatile 只能保证可见性，不能保证线程安全。
     * <p>
     * √ 加上volatile禁止了指令的重排许操作。满足多线程下的单例，懒加载，获取实例的高效性。
     */
    private static volatile SingletonThreadSafety instance;

    /**
     * 私有构造函数，不允许外部new
     */
    private SingletonThreadSafety() {

    }

    /**
     * 该单例线程安全！
     * <p>
     * 双重锁的方式是方法级锁的优化，减少了部分获取实例的耗时。
     * 加上volatile禁止了指令的重排许操作。满足多线程下的单例，懒加载，获取实例的高效性。
     * <p>
     * 同时这种方式也满足了懒加载。
     *
     * @return com.base.demo.design.lockcheckmode.SingletonThreadSafety
     * @date 2021/6/26 17:44
     * @author ChenYongJia
     * @version 1.0
     */
    public static SingletonThreadSafety getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadSafety.class) {
                if (instance == null) instance = new SingletonThreadSafety();
            }
        }
        return instance;
    }

}
