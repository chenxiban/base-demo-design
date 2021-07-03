package com.base.demo.design.test;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.MQAdapter;
import com.base.demo.design.mq.CreateAccount;
import com.base.demo.design.mq.OrderMq;
import com.base.demo.design.service.OrderAdapterService;
import com.base.demo.design.RebateInfo;
import com.base.demo.design.service.impl.InsideOrderService;
import com.base.demo.design.service.impl.POPOrderAdapterServiceImpl;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @Description: 测试类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:12
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class ApiTest {

    /**
     * 从结果中可以看到，同样的字段值在做了适配前后分别有统一的字段属性，进行处理。这样业务开发中也就非常简单了。
     * <p>
     * 另外有一个非常重要的地方，在实际业务开发中，除了反射的使用外，还可以加入代理类把映射的配置交给它。这样就可以不需要每一个mq都手动创建类了。
     *
     * @return void
     * @date 2021/7/3 11:19
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_MQAdapter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2020-06-01 23:20:16");


        CreateAccount create_account = new CreateAccount();
        create_account.setNumber("100001");
        create_account.setAddress("河南省.郑州市.河南工业大学");
        create_account.setAccountDate(parse);
        create_account.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<String, String>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(create_account.toString(), link01);
        System.out.println("mq.create_account(适配前)" + create_account.toString());
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo01));

        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(parse);

        HashMap<String, String> link02 = new HashMap<String, String>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);
        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));
    }

    /**
     * 测试适配类
     * <p>
     * 从测试结果上来看，此时已经的接口已经做了统一的包装，外部使用时候就不需要关心内部的具体逻辑了。
     * 而且在调用的时候只需要传入统一的参数即可，这样就满足了适配的作用。
     *
     * @return void
     * @date 2021/7/3 11:20
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_itfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderService();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }

}
