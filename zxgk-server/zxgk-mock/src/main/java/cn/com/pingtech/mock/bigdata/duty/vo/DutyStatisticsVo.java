/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：DutyStatisticsVo.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.duty.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 勤务统计返回结果
 *
 * @author PingTech
 * @since 2019-10-10
 */
@Data
public class DutyStatisticsVo implements Serializable {

    private List<DutyStatisticsTagVo> tagData;
    private DutyStatisticsHjVo hjData;
}
