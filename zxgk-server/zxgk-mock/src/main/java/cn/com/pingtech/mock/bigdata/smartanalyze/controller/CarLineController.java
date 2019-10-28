/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CarLineController.java
 * 修改记录：
 * 1.2019年10月18日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.controller;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResultVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.service.CarLineService;
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
 * @author: Wangts
 * @date: 2019/10/18
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.controller
 */
@RestController
@RequestMapping(value = "/api")
@Api(value = "车辆轨迹分析",tags = {"车辆轨迹分析"})
public class CarLineController {

    @Autowired
    CarLineService carLineService;

    /**
     * @description:/api/bigdata转发后的响应接口
     * @methodName: 车辆轨迹分析 详情 核查人员信息
     * @params: 
     * @return: 
     * @author: Wangts
     * @date: 2019/10/18
     */
    @PostMapping(value = "/people/search")
    @ApiOperation(value = "车辆轨迹分析核查人员信息", notes = "车辆轨迹分析核查人员信息")
    public BigDataResultVo peopleSearchDetail(@ApiParam(name = "params", value = "CarLineRequestVo") @RequestBody CarLineRequestVo params){
        return carLineService.searchPeople(params);
    }

    /**
     * @description:/api/bigdata转发后的响应接口
     * @methodName: 车辆轨迹分析 详情 车辆通行预警记录
     * @date: 2019/10/18
     */
    @PostMapping(value = "/car/search")
    @ApiOperation(value = "车辆轨迹分析详情车辆通行预警记录", notes = "车辆轨迹分析详情车辆通行预警记录")
    public BigDataResultVo carSearchDetail(@ApiParam(name = "params", value = "CarLineRequestVo") @RequestBody CarLineRequestVo params){
        return carLineService.searchCar(params);
    }

    /**
     * @description:/api/bigdata转发后的响应接口
     * @methodName: 车辆轨迹分析 详情 车辆通行轨迹图
     * @date: 2019/10/18
     */
    @PostMapping(value = "/passlog/statics/detail")
    @ApiOperation(value = "车辆轨迹分析详情车辆通行轨迹图", notes = "车辆轨迹分析详情车辆通行轨迹图")
    public BigDataResultVo carChartSearchDetail(@ApiParam(name = "params", value = "CarLineRequestVo") @RequestBody CarLineRequestVo params){
        return carLineService.searchCarChart(params);
    }

}
