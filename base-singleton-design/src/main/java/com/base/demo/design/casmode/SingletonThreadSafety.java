package com.base.demo.design.casmode;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description: CAS「AtomicReference」自旋锁--(线程安全)
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.casmode
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 17:25
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public final class SingletonThreadSafety {

    /**
     * 用 CAS 自旋锁修饰当前类
     * java并发库提供了很多原子类来支持并发访问的数据安全性；AtomicInteger、AtomicBoolean、AtomicLong、AtomicReference。
     * <p>
     * AtomicReference 可以封装引用一个V实例，支持并发访问如上的单例方式就是使用了这样的一个特点。
     * <p>
     * 使用CAS的好处就是不需要使用传统的加锁方式保证线程安全，而是依赖于CAS的忙等算法，依赖于底层硬件的实现，来保证线程安全。相对于其他锁的实现没有线程的切换和阻塞也就没有了额外的开销，并且可以支持较大的并发性。
     * <p>
     * 当然CAS也有一个缺点就是忙等，如果一直没有获取到将会处于死循环中。
     */
    private static final AtomicReference<SingletonThreadSafety> INSTANCE = new AtomicReference<SingletonThreadSafety>();

    private static SingletonThreadSafety instance;

    /**
     * 私有构造函数，不允许外部new
     */
    private SingletonThreadSafety() {

    }

    /**
     * 保证线程安全
     *
     * @return com.base.demo.design.casmode.SingletonThreadSafety
     * @date 2021/6/26 17:49
     * @author ChenYongJia
     * @version 1.0
     */
    public static final SingletonThreadSafety getInstance() {
        for (; ; ) {
            SingletonThreadSafety instance = INSTANCE.get();
            if (null != instance) {
                return instance;
            }
            INSTANCE.compareAndSet(null, new SingletonThreadSafety());
            return INSTANCE.get();
        }
    }

    public static void main(String[] args) {
        // org.itstack.demo.design.Singleton_06@2b193f2d
        System.out.println(SingletonThreadSafety.getInstance());
        // org.itstack.demo.design.Singleton_06@2b193f2d
        System.out.println(SingletonThreadSafety.getInstance());
    }

}
