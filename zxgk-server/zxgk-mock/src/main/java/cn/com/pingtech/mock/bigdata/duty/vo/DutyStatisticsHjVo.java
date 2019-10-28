/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：DutyStatisticsHjVo.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.duty.vo;

import lombok.Data;

/**
 * 勤务统计合计
 *
 * @author PingTech
 * @since 2019-10-10
 */
@Data
public class DutyStatisticsHjVo {
    /**
     * 通行总数
     */
    private int passTotalHj;
    /**
     * 核查总数
     */
    private int hcTotalHj;
    /**
     * 请下车数
     */
    private int qxcTotalHj;
    /**
     * 请下车核查数
     */
    private int qxcHcTotalHj;
    /**
     * 请下车核查率
     */
    private double qxchcRateHj;
    /**
     * 请停车数
     */
    private int qtcTotalHj;
    /**
     * 请停车核查数
     */
    private int qtcHcTotalHj;
    /**
     * 请停车核查率
     */
    private double qtchcRateHj;
}
