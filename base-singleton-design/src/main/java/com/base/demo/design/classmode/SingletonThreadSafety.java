package com.base.demo.design.classmode;

/**
 * @Description: 使用类的内部类--线程安全
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.classmode
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 17:23
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public final class SingletonThreadSafety {

    /**
     * 调用类的静态内部类实现的单例模式
     */
    private static class SingletonHolder {
        private static SingletonThreadSafety instance = new SingletonThreadSafety();
    }

    /**
     * 私有构造函数，不允许外部new
     */
    private SingletonThreadSafety() {

    }

    /**
     * 该单例线程安全！
     * 使用类的静态内部类实现的单例模式，既保证了线程安全又保证了懒加载，同时不会因为加锁的方式耗费性能。
     * <p>
     * 这主要是因为JVM虚拟机可以保证多线程并发访问的正确性，也就是一个类的构造方法在多线程环境下可以被正确的加载。
     * <p>
     * 此种方式也是非常推荐使用的一种单例模式
     * <p>
     * Holder类中定义了Singleton的静态变量，并且直接进行了实例化，当Holder被主动引用的时候会创建Singleton实例。
     * Holder方式的单例模式是最好的设计之一，也是目前用的比较广泛的设计之一。
     *
     * @return com.base.demo.design.classmode.SingletonThreadSafety
     * @date 2021/6/26 17:41
     * @author ChenYongJia
     * @version 1.0
     */
    public static SingletonThreadSafety getInstance() {
        return SingletonHolder.instance;
    }

}
