package com.cyj.base.demo.design;

import com.cyj.base.demo.design.model.Activity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 活动享元工厂
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.cyj.base.demo.design
 * @Author: ChenYongJia
 * @CreateTime: 2021-08-02 10:45
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class ActivityFactory {

    /**
     * 这里提供的是一个享元工厂🏭，通过map结构存放已经从库表或者接口中查询到的数据，存放到内存中，用于下次可以直接获取。
     * <p>
     * 这样的结构一般在我们的编程开发中还是比较常见的，当然也有些时候为了分布式的获取，会把数据存放到redis中，可以按需选择。
     */
    static Map<Long, Activity> activityMap = new HashMap<>(16);

    /**
     * 获得活动
     *
     * @param id
     * @return com.cyj.base.demo.design.model.Activity
     * @date 2021/8/2 10:45
     * @author ChenYongJia
     * @version 1.0
     */
    public static Activity getActivity(Long id) {
        Activity activity = activityMap.get(id);
        if (null == activity) {
            // 模拟从实际业务应用从接口中获取活动信息
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("图书嗨乐");
            activity.setDesc("图书优惠券分享激励分享活动第二期");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);
        }
        return activity;
    }

}
