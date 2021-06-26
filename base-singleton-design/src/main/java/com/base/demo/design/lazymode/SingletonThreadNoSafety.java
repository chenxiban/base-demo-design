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
public class SingletonThreadNoSafety {

    /**
     * 如果主动使用Singleton类，instance实例将直接完成创建，包括其中的实例变量都会得到初始化，
     * 但是instance可能被加载很长一段时间后才被使用，instance实例开辟的堆内存会驻留更久的时间，
     * 如果说一个类的成员变量不多，且占用内存资源较少，可以使用饿汉式，总结它可以保证多个线程下唯一实例，
     * getInstance方法性能较高，但是无法进行懒加载。
     */
    private byte[] data = new byte[1024];

    private static SingletonThreadNoSafety instance = new SingletonThreadNoSafety();

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
        return instance;
    }

}
