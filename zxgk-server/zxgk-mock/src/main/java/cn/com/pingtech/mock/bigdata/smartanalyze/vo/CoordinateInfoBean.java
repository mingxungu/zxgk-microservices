/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CoordinateInfoBean.java
 * 修改记录：
 * 1.2019年10月21日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@Data
public  class CoordinateInfoBean {
    /**
     * warmLever : 1
     * checkColor : 红色
     * x : 2019-10-18 14:10:55
     * y : 1101191002
     * _id : MTEwMTE5MTBfMzkxOTUxNjc2NTYwMzc1ODA4
     */

    private int warmLever;
    private String checkColor;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String x;

    private String y;
    private String id;
}