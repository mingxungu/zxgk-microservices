/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CarLineVo.java
 * 修改记录：
 * 1.2019年10月17日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.entity;

import lombok.Data;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/17
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.vo
 */
@Data
public class CarLineVo {
    private String checkPeopleCount;
    private String carBrand;
    private String bodyColor;
    private String captureImage;
    private String checkPeopleTimes;
    private Double sum_doc_night;
    private String carNumber;
    private String carColor;
    private String carType;
    private int peopleWarnCount;
    private Double passRegionCount;
    private int carWarnCount;
    private int carPassCount;
    private String tag;
    private String checkMsg;
    private String nightHourEnd;
    private String nightHourStart;
    private String nightPassCount;
    private String nightPassPerc;
    private String playRole;
    private String playRoleLabel;


}
