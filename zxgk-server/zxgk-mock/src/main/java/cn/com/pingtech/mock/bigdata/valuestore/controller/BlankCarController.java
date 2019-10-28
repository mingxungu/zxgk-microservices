/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：BlankCarController.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.controller;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResponseVo;
import cn.com.pingtech.mock.bigdata.valuestore.entity.BlankCar;
import cn.com.pingtech.mock.bigdata.valuestore.service.BlankCarService;
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
 * @create 2019-10-12-10:14
 */
@RestController
@RequestMapping("/api/black-car")
@Api(value = "黑车运营", tags = {"黑车运营"})
public class BlankCarController {

    @Autowired
    private BlankCarService blankCarService;

    @PostMapping("/search")
    @ApiOperation(value = "黑车运营查询", notes = "黑车运营查询")
    public BigDataResponseVo search(@ApiParam(name = "params", value = "BlankCar") @RequestBody BlankCar params) {
        return blankCarService.search(params);
    }
}
