package com.base.demo.design.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 责任链中返回对象定义
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.model
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:00
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthInfo {

    /**
     * code 编码
     */
    private String code;

    /**
     * 详细信息
     */
    private String info = "";

    public AuthInfo(String code, String... infos) {
        this.code = code;
        for (String str : infos) {
            this.info = this.info.concat(str);
        }
    }

}
