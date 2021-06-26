package com.base.demo.design.Award;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 奖品返回数据
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.Award
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:43
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AwardRes {

    /**
     * 编码信息
     */
    private String code;

    /**
     * 描述信息
     */
    private String info;

}
