/**
 * Copyright (C), 2019-2020 FileName: BusinessStatus Author:   danyits Date:     2020/12/5 15:42 Description: 业务状态临时表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hastemd.demo.aop.status.domian;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 〈业务状态临时表〉
 *
 * @author danyits
 * @date 2020/12/5
 * @since 1.0.0
 */
@Data
public class BusinessStatus {

    /**
     * 数据Id
     */
    private Object dataId;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 数据入库数据
     */
    private LocalDateTime createTime;

    public BusinessStatus() {
    }

    public BusinessStatus(Object dataId, String dataType) {
        this.dataId = dataId;
        this.dataType = dataType;
    }
}
