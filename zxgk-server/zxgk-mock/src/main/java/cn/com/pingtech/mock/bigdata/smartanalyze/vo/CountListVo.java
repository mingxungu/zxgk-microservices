/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CountListVo.java
 * 修改记录：
 * 1.2019年10月16日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import lombok.Data;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/16
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.vo
 */
@Data
public class CountListVo {

    private String totalSimilarity;
    private String peopleId;
    private String similarity;
    private String peopleName;
    private String count;
    private String imei;
    private String startTime;
    private String imsi;
    private String endTime;
    private String _id;
    private String idNumber;


}
