/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：PeoplePhoneController.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.controller;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResponseVo;
import cn.com.pingtech.mock.bigdata.common.vo.BigDataResultVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.entity.PeoplePhone;
import cn.com.pingtech.mock.bigdata.smartanalyze.service.*;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CarAlongVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CarAlonggjtVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CarLineRequestVo;
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
 * @author:Sunj
 * @date: 2019/10/22
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.controller
 */
@RestController
@RequestMapping(value = "/api/car/go-with")
@Api(value = "伴随车辆",tags = {"伴随车辆"})
public class CarAlongController {

    @Autowired
    private CarAlongService carAlongService;

    @Autowired
    private CarLineService carLineService;

    @Autowired
    private CarAlonggjtService carAlonggjtService;

    @PostMapping("/agg")
    @ApiOperation(value = "伴随车辆查询", notes = "伴随车辆查询")
    public BigDataResponseVo agg(@ApiParam(name = "params", value = "CarAlongVo") @RequestBody CarAlongVo params){
       params.setStartTime(params.getStartTime()+ " 00:00:00");
       params.setEndTime(params.getEndTime()+" 23:59:59");
        return carAlongService.agg(params);
    }

    @PostMapping("/detail")
    @ApiOperation(value = "伴随车辆详情查询", notes = "伴随车辆详情查询")
    public BigDataResponseVo detail(@ApiParam(name = "params", value = "CarAlongVo") @RequestBody CarAlongVo params){
        params.setStartTime(params.getStartTime()+ " 00:00:00");
        params.setEndTime(params.getEndTime()+" 23:59:59");
        return carAlongService.detail(params);
    }

    @PostMapping("/gjt")
    @ApiOperation(value = "伴随车辆轨迹图查询", notes = "伴随车辆轨迹图查询")
    public BigDataResponseVo gjt(@ApiParam(name = "params", value = "CarAlongVo") @RequestBody CarAlongVo params){
        params.setStartTime(params.getStartTime()+ " 00:00:00");
        params.setEndTime(params.getEndTime()+" 23:59:59");
        return carAlonggjtService.gjt(params);
    }

    @PostMapping("/aCarQuery")
    @ApiOperation(value = "a伴随车辆查询", notes = "a伴随车辆查询")
    public BigDataResultVo aCarQuery(@ApiParam(name = "params", value = "CarLineRequestVo") @RequestBody CarLineRequestVo params){
        return carLineService.searchCar(params);
    }

    @PostMapping("/bCarQuery")
    @ApiOperation(value = "b伴随车辆查询", notes = "b伴随车辆查询")
    public BigDataResultVo bCarQuery(@ApiParam(name = "params", value = "CarLineRequestVo") @RequestBody CarLineRequestVo params){
        return carLineService.searchCar(params);
    }
}
