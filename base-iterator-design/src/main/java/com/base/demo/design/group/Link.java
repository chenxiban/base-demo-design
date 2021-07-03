package com.base.demo.design.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 树节点链路
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.group
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:45
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Link {

    /**
     * 雇员ID
     * <p>
     * 这个类用于描述结构树中的各个节点之间的关系链，也就是A to B、B to C、B to D，以此描述出一套完整的树组织结构。
     */
    private String fromId;

    /**
     * 雇员ID
     */
    private String toId;

}
