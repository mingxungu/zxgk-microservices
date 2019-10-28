/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：ValueController.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.controller;

import cn.com.pingtech.api.entity.ResponseVo;
import cn.com.pingtech.mock.bigdata.common.vo.BigDataResponseVo;
import cn.com.pingtech.mock.bigdata.valuestore.entity.CarValue;
import cn.com.pingtech.mock.bigdata.valuestore.entity.PeopleValue;
import cn.com.pingtech.mock.bigdata.valuestore.service.CarValueService;
import cn.com.pingtech.mock.bigdata.valuestore.service.PeopleValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xucongfu
 * @create 2019-10-12-10:56
 */
@RestController
@RequestMapping("/api/value-base")
@Api(value = "价值库", tags = {"价值库"})
public class ValueController {

    @Autowired
    private PeopleValueService peopleValueService;

    @Autowired
    private CarValueService carValueService;

    @PostMapping("/people/search")
    @ApiOperation(value = "人员价值库查询", notes = "人员价值库查询")
    public BigDataResponseVo peopleSearch(@ApiParam(name = "params", value = "BlankCar") @RequestBody PeopleValue params) {
        return peopleValueService.search(params);
    }


    @PostMapping("/car/search")
    @ApiOperation(value = "车辆价值库查询", notes = "车辆价值库查询")
    public BigDataResponseVo carSearch(@ApiParam(name = "params", value = "BlankCar") @RequestBody CarValue params) {
        return carValueService.search(params);
    }

    @PostMapping("/car/detail")
    @ApiOperation(value = "车辆价值库详情查询", notes = "车辆价值库详情查询")
    public ResponseVo carDetail(@ApiParam(name = "params", value = "CarValue") @RequestBody CarValue params) {
        return carValueService.detail(params);
    }

    @PostMapping("/people/detail")
    @ApiOperation(value = "人员价值库详情查询", notes = "人员价值库详情查询")
    public ResponseVo peopleDetail(@ApiParam(name = "params", value = "PeopleValue") @RequestBody PeopleValue params) {
        return peopleValueService.detail(params);
    }
}
