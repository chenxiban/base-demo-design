package com.base.demo.design.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description: 测试类--最基础的常规实现
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-02 08:54
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class ApiTest {

    /**
     * 原型模式主要解决的问题就是创建大量重复的类，而我们模拟的场景就需要给不同的用户都创建相同的试卷，但这些试卷的题目不便于每次都从库中获取，
     * 甚至有时候需要从远程的RPC中获取。这样都是非常耗时的，而且随着创建对象的增多将严重影响效率。
     * <p>
     * 在原型模式中所需要的非常重要的手段就是克隆，在需要用到克隆的类中都需要实现 implements Cloneable 接口。
     *
     * @return void
     * @date 2021/7/3 8:51
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_clone() throws CloneNotSupportedException {
        ArrayList<String> l01 = new ArrayList<String>();
        l01.add("xxx");
        l01.add("yyy");

        ArrayList<String> l02 = (ArrayList<String>) l01.clone();
        l02.add("zzz");

        System.out.println(JSON.toJSONString(l01));
        System.out.println(JSON.toJSONString(l02));

        l01.remove("xxx");

        System.out.println(JSON.toJSONString(l01));
        System.out.println(JSON.toJSONString(l02));
    }

}
