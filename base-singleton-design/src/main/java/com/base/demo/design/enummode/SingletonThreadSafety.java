package com.base.demo.design.enummode;

/**
 * @Description: Effective Java作者推荐的枚举单例(线程安全)
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.enummode
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 17:25
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public enum SingletonThreadSafety {

    /**
     * 参数
     *
     * 枚举类型不允许被继承，同样是线程安全的且只能被实例化一次，但是枚举类型不能够懒加载，对Singleton主动使用，比如调用其中的静态方法则INSTANCE会立即得到实例化。
     */
    INSTANCE;

    private byte[] data=new byte[1024];

    SingletonThreadSafety(){
        System.out.println("INSTANCE will be initialized immediately");
    }

    public void test() {
        System.out.println("Hey, society, you little Fu~");
    }

    public static void method(){
        //调用该方法会主动使用Singleton,INSTANCE实例将会被实例化
    }

    public static SingletonThreadSafety getInstance(){
        return INSTANCE;
    }

    /*@Test
    public void test() { // 调用方式
        Singleton_07.INSTANCE.test();
    }*/

}
