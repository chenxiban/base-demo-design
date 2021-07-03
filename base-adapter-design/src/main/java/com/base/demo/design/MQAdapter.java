package com.base.demo.design;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Description: MQ 消息适配器--MQ消息体适配类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:11
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class MQAdapter {

    /**
     * 过滤器
     * <p>
     * 这个类里的方法非常重要，主要用于把不同类型MQ种的各种属性，映射成我们需要的属性并返回。就像一个属性中有用户ID;uId，映射到我们需要的；userId，做统一处理。
     * <p>
     * 而在这个处理过程中需要把映射管理传递给Map<String, String> link，也就是准确的描述了，当前MQ中某个属性名称，映射为我们的某个属性名称。
     * <p>
     * 最终因为我们接收到的mq消息基本都是json格式，可以转换为MAP结构。最后使用反射调用的方式给我们的类型赋值。
     *
     * @param strJson
     * @param link
     * @return com.base.demo.design.service.RebateInfo
     * @date 2021/7/3 11:11
     * @author ChenYongJia
     * @version 1.0
     */
    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    /**
     * 过滤器
     *
     * @param obj
     * @param link
     * @return com.base.demo.design.service.RebateInfo
     * @date 2021/7/3 11:11
     * @author ChenYongJia
     * @version 1.0
     */
    public static RebateInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }

}
