package com.base.demo.design.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 审核信息
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

    private String code;

    private String info = "";

    public AuthInfo(String code, String ...infos) {
        this.code = code;
        for (String str:infos){
            this.info = this.info.concat(str);
        }
    }

}
