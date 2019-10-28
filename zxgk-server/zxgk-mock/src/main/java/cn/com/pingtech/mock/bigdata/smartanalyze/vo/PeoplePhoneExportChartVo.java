/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：PeoplePhoneExportChartVo.java
 * 修改记录：
 * 1.2019年10月21日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public  class PeoplePhoneExportChartVo {
    /**
     * color : 绿色
     * x : 2019-05-26 08:00:00
     * y : 11011501
     * _id : xkrJ3moBPRYASBz7u9Bn
     * type : 0
     */

    private String color;
    private String x;
    private String y;
    private String _id;
    private String type;
}