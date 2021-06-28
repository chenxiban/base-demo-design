package com.base.demo.design.hungrymode;

/**
 * @Description: 饿汉模式--线程安全
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.hungrymode
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 17:22
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public final class SingletonThreadSafety {

    /**
     * 直接实例化对象
     *
     * 如果主动使用Singleton类，instance实例将直接完成创建，包括其中的实例变量都会得到初始化，
     * 但是instance可能被加载很长一段时间后才被使用，instance实例开辟的堆内存会驻留更久的时间，
     * 如果说一个类的成员变量不多，且占用内存资源较少，可以使用饿汉式，总结它可以保证多个线程下唯一实例，
     * getInstance方法性能较高，但是无法进行懒加载。
     *
     */
    private static SingletonThreadSafety instance = new SingletonThreadSafety();

    /**
     * 私有构造函数，不允许外部new
     */
    private SingletonThreadSafety() {

    }

    /**
     * 该单例线程安全！
     * 此种方式与我们开头的第一个实例化Map基本一致，在程序启动的时候直接运行加载，后续有外部需要使用的时候获取即可。
     * <p>
     * 但此种方式并不是懒加载，也就是说无论你程序中是否用到这样的类都会在程序启动之初进行创建。
     * <p>
     * 那么这种方式导致的问题就像你下载个游戏软件，可能你游戏地图还没有打开呢，但是程序已经将这些地图全部实例化。到你手机上最明显体验就一开游戏内存满了，手机卡了，需要换了。
     *
     * @return com.base.demo.design.hungrymode.SingletonThreadSafety
     * @date 2021/6/26 17:40
     * @author ChenYongJia
     * @version 1.0
     */
    public static SingletonThreadSafety getInstance() {
        return instance;
    }

}
