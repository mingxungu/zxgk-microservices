/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：DutyStatisticsController.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.duty.controller;

import cn.com.pingtech.api.entity.ResponseVo;
import cn.com.pingtech.mock.bigdata.duty.service.DutyStatisticsService;
import cn.com.pingtech.mock.bigdata.duty.vo.DutyStatisticsParamsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 勤务统计
 *
 * @author pingtch
 * @since 2019-10-10
 */
@RestController
@RequestMapping("/api/dutyStatistics")
@Api(value = "勤务统计API", tags = {"勤务统计API"})
public class DutyStatisticsController {

    @Autowired
    private DutyStatisticsService dutyStatisticsService;

    @PostMapping("/search")
    @ApiOperation(value = "勤务统计查询", notes = "按通行时间段进行勤务统计")
    public ResponseVo search(@ApiParam(name = "params", value = "DutyStatisticsParamsVo") @RequestBody DutyStatisticsParamsVo params) {
        return ResponseVo.success(
                dutyStatisticsService.search(params.getTag(), params.getPassTimeStart(), params.getPassTimeEnd()));
    }
}
