/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：DetailResponse.java
 * 修改记录：
 * 1.2019年10月18日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author sunjl
 * @date 2019-04-23
 */
@Data
public class DetailResponse {

    private String carNumber;//车牌号码
    private String carType;//车辆类型
    private String carColor;//车牌颜色

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;//关联开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;//关联结束时间

    private String similarity;//关联度
    private String imei;
    private String imsi;
}
