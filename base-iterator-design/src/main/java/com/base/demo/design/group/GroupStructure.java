package com.base.demo.design.group;

import com.base.demo.design.lang.Iterator;
import com.base.demo.design.lang.Collection;
import com.base.demo.design.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 迭代器功能实现--核心部分
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.group
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:44
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GroupStructure {

    /**
     * 组织ID，也是一个组织链的头部ID
     */
    private String groupId;

    /**
     * 组织名称
     */
    private String groupName;

    /**
     * 雇员列表
     */
    private Map<String, Employee> employeeMap = new ConcurrentHashMap<>(Constant.INITIAL_CAPACITY);

    /**
     * 组织架构关系；id->list
     */
    private Map<String, List<Link>> linkMap = new ConcurrentHashMap<>(Constant.INITIAL_CAPACITY);

    /**
     * 反向关系链
     */
    private Map<String, String> invertedMap = new ConcurrentHashMap<>(Constant.INITIAL_CAPACITY);

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    /**
     * 添加元素
     * <p>
     * 以上的这部分代码稍微有点长，主要包括了对元素的添加和删除。另外最重要的是对遍历的实现 new Iterator<Employee>。
     * <p>
     * 添加和删除元素相对来说比较简单，使用了两个map数组结构进行定义；雇员列表、组织架构关系；id->list。
     * <p>
     * 当元素添加元素的时候，会分别在不同的方法中向map结构中进行填充指向关系(A->B)，也就构建出了我们的树形组织关系。
     *
     * @param employee
     * @return boolean
     * @date 2021/7/3 11:54
     * @author ChenYongJia
     * @version 1.0
     */
    public boolean add(Employee employee) {
        return null != employeeMap.put(employee.getUId(), employee);
    }

    /**
     * 移除元素
     *
     * @param o
     * @return boolean
     * @date 2021/7/3 11:55
     * @author ChenYongJia
     * @version 1.0
     */
    public boolean remove(Employee o) {
        return null != employeeMap.remove(o.getUId());
    }

    /**
     * 添加链路树
     *
     * @param key
     * @param link
     * @return boolean
     * @date 2021/7/3 11:55
     * @author ChenYongJia
     * @version 1.0
     */
    public boolean addLink(String key, Link link) {
        invertedMap.put(link.getToId(), link.getFromId());
        if (linkMap.containsKey(key)) {
            return linkMap.get(key).add(link);
        } else {
            List<Link> links = new LinkedList<Link>();
            links.add(link);
            linkMap.put(key, links);
            return true;
        }
    }

    /**
     * 移除链路树
     *
     * @param key
     * @param link
     * @return boolean
     * @date 2021/7/3 11:55
     * @author ChenYongJia
     * @version 1.0
     */
    public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    /**
     * 迭代器对遍历的实现
     *
     * @return com.base.demo.design.lang.Iterator<com.base.demo.design.group.Employee>
     * @date 2021/7/3 11:55
     * @author ChenYongJia
     * @version 1.0
     */
    public Iterator<Employee> iterator() {

        return new Iterator<Employee>() {

            HashMap<String, Integer> keyMap = new HashMap<>(Constant.INITIAL_CAPACITY);

            int totalIdx = 0;
            private String fromId = groupId;  // 雇员ID，From
            private String toId = groupId;   // 雇员ID，To

            @Override
            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            @Override
            public Employee next() {
                List<Link> links = linkMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                // 同级节点扫描
                if (null == links) {
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                // 上级节点扫描
                while (cursorIdx > links.size() - 1) {
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                // 获取节点
                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx++;

                // 返回结果
                return employeeMap.get(link.getToId());
            }

            public int getCursorIdx(String key) {
                int idx = 0;
                if (keyMap.containsKey(key)) {
                    idx = keyMap.get(key);
                    keyMap.put(key, ++idx);
                } else {
                    keyMap.put(key, idx);
                }
                return idx;
            }
        };
    }

}
