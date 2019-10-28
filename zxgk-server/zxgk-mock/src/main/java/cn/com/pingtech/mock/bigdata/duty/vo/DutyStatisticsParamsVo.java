/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：DutyStatisticsParamsVo.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.duty.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 勤务统计参数
 *
 * @author PingTech
 * @since 2019-10-10
 */
@Data
@ApiModel(value = "勤务统计参数")
public class DutyStatisticsParamsVo {
    /**
     * 检查站列表，逗号分隔
     */
    @ApiModelProperty(name = "tag", value = "检查站列表，逗号分隔")
    String tag;
    /**
     * 开始时间
     */
    @ApiModelProperty(name = "passTimeStart", value = "开始时间")
    String passTimeStart;
    /**
     * 结束时间
     */
    @ApiModelProperty(name = "passTimeEnd", value = "结束时间")
    String passTimeEnd;
}
