package com.base.demo.design.lockcheckmode;

/**
 * @Description: 双重校验锁--不加volatile关键字
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.lockcheckmode
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-28 15:43
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public final class SingletonThreadSafety2 {

    private static SingletonThreadSafety2 instance;

    /**
     * 私有构造函数，不允许外部new
     */
    private SingletonThreadSafety2() {

    }

    /**
     * 1.给 instance 分配内存
     * <p>
     * 　　2.调用 Singleton 的构造函数来初始化成员变量
     * <p>
     * 　　3.将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
     * <p>
     * 　　但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，
     * 最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，
     * 这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
     *
     * @return com.base.demo.design.lockcheckmode.SingletonThreadSafety2
     * @date 2021/6/28 15:45
     * @author ChenYongJia
     * @version 1.0
     */
    public static SingletonThreadSafety2 getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadSafety2.class) {
                if (instance == null) instance = new SingletonThreadSafety2();
            }
        }
        return instance;
    }

}
