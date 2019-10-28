/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：VehiclePhoneController.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.controller;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResponseVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.entity.VehiclePhone;
import cn.com.pingtech.mock.bigdata.smartanalyze.service.VehiclePhoneService;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.DetailResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/14
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.controller
 */
@RestController
@RequestMapping(value = "/api/car-code")
@Api(value = "车码模型",tags = {"车码模型分析"})
public class VehiclePhoneController {

    @Autowired
    private VehiclePhoneService vehiclePhoneService;

    @PostMapping("/analyse")
    @ApiOperation(value = "车码模型分析", notes = "车码模型分析")
    public BigDataResponseVo analyze(@ApiParam(name = "params", value = "VehiclePhone") @RequestBody VehiclePhone params){
        return vehiclePhoneService.analyze(params);
    }

    @PostMapping("/relevance")
    @ApiOperation(value = "车码关联查询", notes = "车码关联查询")
    public BigDataResponseVo relevance(@ApiParam(name = "params", value = "VehiclePhone") @RequestBody VehiclePhone params){
        return vehiclePhoneService.relevance(params);
    }

    @PostMapping("/records")
    @ApiOperation(value = "车码关联查询详情", notes = "车码关联查询详情")
    public BigDataResponseVo detail(@ApiParam(name = "params", value = "VehiclePhone") @RequestBody VehiclePhone params){
        return vehiclePhoneService.detail(params);
    }

    @PostMapping("/gjt")
    @ApiOperation(value = "车码关联查询详情方波图", notes = "车码关联查询详情方波图")
    public BigDataResponseVo detailfbt(@ApiParam(name = "params", value = "DetailResponse") @RequestBody DetailResponse params){
        return vehiclePhoneService.detailfbt(params);
    }
}
