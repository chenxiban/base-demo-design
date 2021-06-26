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
     */
    INSTANCE;

    public void test() {
        System.out.println("hi~");
    }

}
