package com.base.demo.design.test;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 模拟审核服务 这里的代码结构比较简单，只有一个模拟审核和查询审核结果的服务类。
 * 相当于你可以调用这个类去审核工程和获取审核结构，这部分结果信息是模拟的写到缓存实现。
 * 1. auth          审核流程
 * 2. queryAuthInfo 查询审核信息(时间)
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 16:56
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class AuthService {

    /**
     * 权限Map集合
     * <p>
     * 这里面提供了两个接口一个是查询审核结果(queryAuthInfo)、另外一个是处理审核(auth)。
     * <p>
     * 这部分是把由谁审核的和审核的单子ID作为唯一key值记录到内存Map结构中。
     */
    private static Map<String, Date> authMap = new ConcurrentHashMap<>();

    /**
     * 查询审核结果
     *
     * @param uId     用户id
     * @param orderId 订单id
     * @return java.util.Date
     * @date 2021/7/1 16:58
     * @author ChenYongJia
     * @version 1.0
     */
    public static Date queryAuthInfo(String uId, String orderId) {
        return authMap.get(uId.concat(orderId));
    }

    /**
     * 审核流程
     *
     * @param uId     用户id
     * @param orderId 订单id
     * @return void
     * @date 2021/7/1 16:58
     * @author ChenYongJia
     * @version 1.0
     */
    public static void auth(String uId, String orderId) {
        authMap.put(uId.concat(orderId), new Date());
    }

}
