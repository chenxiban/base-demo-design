package com.base.demo.design.test;

import com.base.demo.design.group.Employee;
import com.base.demo.design.group.GroupStructure;
import com.base.demo.design.group.Link;
import com.base.demo.design.lang.Iterator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 测试类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:56
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ApiTest {

    /**
     * 从遍历的结果可以看到，我们是顺着树形结构的深度开始遍历，一直到右侧的节点3；雇员 Id：2、雇员 Id：4...雇员 Id：3
     *
     * @return void
     * @date 2021/7/3 11:57
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_iterator() {
        GroupStructure groupStructure = new GroupStructure("1", "小傅哥");
        groupStructure.add(new Employee("2", "花花", "二级部门"));
        groupStructure.add(new Employee("3", "豆包", "二级部门"));
        groupStructure.add(new Employee("4", "蹦蹦", "三级部门"));
        groupStructure.add(new Employee("5", "大烧", "三级部门"));
        groupStructure.add(new Employee("6", "虎哥", "四级部门"));
        groupStructure.add(new Employee("7", "玲姐", "四级部门"));
        groupStructure.add(new Employee("8", "秋雅", "四级部门"));

        groupStructure.addLink("1", new Link("1", "2"));
        groupStructure.addLink("1", new Link("1", "3"));

        groupStructure.addLink("2", new Link("2", "4"));
        groupStructure.addLink("2", new Link("2", "5"));

        groupStructure.addLink("5", new Link("5", "6"));
        groupStructure.addLink("5", new Link("5", "7"));
        groupStructure.addLink("5", new Link("5", "8"));

        Iterator<Employee> iterator = groupStructure.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            log.info("{}，雇员 Id：{} Name：{}", employee.getDesc(), employee.getUId(), employee.getName());
        }

    }

}
