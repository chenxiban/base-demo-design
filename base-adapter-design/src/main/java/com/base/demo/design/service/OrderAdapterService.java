package com.base.demo.design.service;

/**
 * @Description: 订单适配器服务类--统一适配接口，后面的实现类都需要完成此接口，并把具体的逻辑包装到指定的类中，满足单一职责。
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:01
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface OrderAdapterService {

    /**
     * 用户是否首单
     *
     * @param uId
     * @return boolean
     * @date 2021/7/3 11:02
     * @author ChenYongJia
     * @version 1.0
     */
    boolean isFirst(String uId);

}
