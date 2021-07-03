package com.base.demo.design;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.model.AuthLink;
import com.base.demo.design.test.AuthService;
import com.base.demo.design.test.impl.Level1AuthLink;
import com.base.demo.design.test.impl.Level2AuthLink;
import com.base.demo.design.test.impl.Level3AuthLink;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description: 测试类二
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:09
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ApiTestTwo {

    /**
     * 这里包括最核心的责任链创建，实际的业务中会包装到控制层；
     * AuthLink authLink = new Level3AuthLink("1000013", "王工") .appendNext(new Level2AuthLink("1000012", "张经理")
     * .appendNext(new Level1AuthLink("1000011", "段总"))); 通过把不同的责任节点进行组装，构成一条完整业务的责任链。
     * <p>
     * 接下来不断的执行查看审核链路authLink.doAuth(...)，通过返回结果对数据进行3、2、1级负责人审核，直至最后审核全部完成。
     * <p>
     * 从结果可以看到我们的责任链已经生效，按照责任链的结构一层层审批，直至最后输出审批结束到一级完成的结果。
     * 这样责任链的设计方式可以方便的进行扩展和维护，也把if语句干掉了。
     *
     * @return void
     * @date 2021/7/3 10:15
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_AuthLink() throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                        .appendNext(new Level1AuthLink("1000011", "段总")));

        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        log.info("测试结果：{}", "模拟三级负责人审批，王工");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        log.info("测试结果：{}", "模拟二级负责人审批，张经理");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        log.info("测试结果：{}", "模拟一级负责人审批，段总");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));
    }

}
