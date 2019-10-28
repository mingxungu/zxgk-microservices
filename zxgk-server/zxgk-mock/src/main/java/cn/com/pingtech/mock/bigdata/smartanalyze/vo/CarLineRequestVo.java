/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CarLineRequestVo.java
 * 修改记录：
 * 1.2019年10月17日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataRequestVo;
import lombok.Data;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/17
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.vo
 */
@Data
public class CarLineRequestVo extends BigDataRequestVo {
    private String bodyColor;
    private String carNumber;
    private String carPassCount;
    private String carType;
    private String checkMsg;
    private String nightHourEnd;
    private String nightHourStart;
    private String nightPassCount;
    private String nightPassPerc;
    private String playRole;
    private String playRoleLabel;

    private String carColor;
    private boolean requestPasslogStaticsDetailFlag =true;




}
