/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：DutyStatisticsTagVo.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.duty.vo;

import cn.com.pingtech.poi.FieldMeta;
import cn.com.pingtech.poi.TableMeta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 勤务统计检查站
 *
 * @author PingTech
 * @since 2019-10-10
 */
@Data
@TableMeta(name = "勤务统计", maxCount = 60000)
public class DutyStatisticsTagVo {
    /**
     * 检查站编码
     */
    @FieldMeta(name = "检查站编码", nullable = false)
    private String tag;
    /**
     * 通行时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @FieldMeta(name = "通行时间", nullable = false, format = "yyyy-MM-dd")
    private Date passTime;
    /**
     * 通行总数
     */
    @FieldMeta(name = "通行总数", nullable = false)
    private int passTotal;
    /**
     * 核查总数
     */
    @FieldMeta(name = "核查总数", nullable = false)
    private int hcTotal;
    /**
     * 请下车数
     */
    @FieldMeta(name = "请下车数", nullable = false)
    private int qxcTotal;
    /**
     * 请下车核查数
     */
    @FieldMeta(name = "请下车核查数", nullable = false)
    private int qxcHcTotal;
    /**
     * 请下车核查率
     */
    @FieldMeta(name = "请下车核查率", nullable = true)
    private double qxchcRate;
    /**
     * 请停车数
     */
    @FieldMeta(name = "请停车数", nullable = false)
    private int qtcTotal;
    /**
     * 请停车核查数
     */
    @FieldMeta(name = "请停车核查数", nullable = false)
    private int qtcHcTotal;
    /**
     * 请停车核查率
     */
    @FieldMeta(name = "请停车核查率", nullable = true)
    private double qtchcRate;

}
