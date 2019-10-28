/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CreditCarController.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.controller;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResponseVo;
import cn.com.pingtech.mock.bigdata.valuestore.entity.CreditCar;
import cn.com.pingtech.mock.bigdata.valuestore.entity.CreditCarLog;
import cn.com.pingtech.mock.bigdata.valuestore.service.CreditCarLogService;
import cn.com.pingtech.mock.bigdata.valuestore.service.CreditCarService;
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
 * @create 2019-10-11-11:06
 */
@RestController
@RequestMapping("/api/carpoint")
@Api(value = "车辆积分", tags = {"车辆积分"})
public class CreditCarController {

    @Autowired
    private CreditCarService creditCarService;

    @Autowired
    private CreditCarLogService creditCarLogService;


    @PostMapping("/search")
    @ApiOperation(value = "车辆积分查询", notes = "车辆积分查询")
    public BigDataResponseVo search(@ApiParam(name = "params", value = "CreditCar") @RequestBody CreditCar params) {
        return creditCarService.search(params);
    }


    @PostMapping("/detail")
    @ApiOperation(value = "车辆积分详情查询", notes = "车辆积分详情查询")
    public BigDataResponseVo detail(@ApiParam(name = "params", value = "CreditCarLog") @RequestBody CreditCarLog params) {
        return creditCarLogService.search(params);
    }
}
