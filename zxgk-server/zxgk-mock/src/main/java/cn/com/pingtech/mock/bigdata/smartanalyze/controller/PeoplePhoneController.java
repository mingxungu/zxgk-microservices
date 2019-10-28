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
import cn.com.pingtech.mock.bigdata.smartanalyze.entity.PeoplePhone;
import cn.com.pingtech.mock.bigdata.smartanalyze.service.PeoplePhoneService;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.PeopleRequestVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.PhoneRequestVo;
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
@RequestMapping(value = "/api/people-code")
@Api(value = "人码关联",tags = {"人码关联"})
public class PeoplePhoneController {

    @Autowired
    private PeoplePhoneService peoplePhoneService;


    @PostMapping("/relevance")
    @ApiOperation(value = "人码关联查询", notes = "人码关联查询")
    public BigDataResponseVo relevance(@ApiParam(name = "params", value = "PeoplePhone") @RequestBody PeoplePhone params){
       params.setStartTime(params.getStartTime()+ " 00:00:00");
       params.setEndTime(params.getEndTime()+" 23:59:59");
        return peoplePhoneService.relevance(params);
    }


    @PostMapping("/records")
    @ApiOperation(value = "人码关联查询详情页", notes = "人码关联查询详情页")
    public BigDataResponseVo recordsDetail(@ApiParam(name = "params", value = "PeoplePhone") @RequestBody PeoplePhone params){
        params.setStartTime(params.getStartTime()+ " 00:00:00");
        params.setEndTime(params.getEndTime()+" 23:59:59");
        return peoplePhoneService.recordsDetail(params);
    }

    @PostMapping("/gjt")
    @ApiOperation(value = "人码关联查询详情页的详情图", notes = "人码关联查询详情页的详情图")
    public BigDataResponseVo recordsDetailChart(@ApiParam(name = "params", value = "PeoplePhone") @RequestBody PeoplePhone params){
        params.setStartTime(params.getStartTime()+ " 00:00:00");
        params.setEndTime(params.getEndTime()+" 23:59:59");
        return peoplePhoneService.recordsDetailChart(params);
    }

    @PostMapping("/peopleDetail")
    @ApiOperation(value = "人码关联查询详情页的人员核查记录", notes = "人码关联查询详情页的人员核查记录")
    public BigDataResponseVo recordsDetailPeople(@ApiParam(name = "params", value = "PeopleRequestVo") @RequestBody PeopleRequestVo params){
        return peoplePhoneService.recordsDetailPeople(params);
    }

    @PostMapping("/csvDetail")
    @ApiOperation(value = "人码关联查询详情页的侦码记录", notes = "人码关联查询详情页的侦码记录")
    public BigDataResponseVo recordsDetailPhone(@ApiParam(name = "params", value = "PhoneRequestVo") @RequestBody PhoneRequestVo params){
        return peoplePhoneService.recordsDetailPhone(params);
    }


}
