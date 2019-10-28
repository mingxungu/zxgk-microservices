/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：PeoplePhone.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author sunjl
 * @date 2019-04-23
 */
@Data
public class PeoplePhone {


    private String id;
    private String peopleId;
    private String peopleName;
    private String idNumber;
	private String phoneCodeCount;//手机帧码数

//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String startTime;//关联开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String endTime;//关联结束时间
    private String minSimilarity;//关联度
    private String count;//关联次数
    private String imei;  //imei
    private String imsi;  //imsi
    private String similarity;  //关联度for detail

    //id
    private String _id;

    private int page;
    private int size;
}
