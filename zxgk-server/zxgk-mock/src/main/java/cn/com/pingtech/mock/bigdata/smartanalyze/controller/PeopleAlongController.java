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
import cn.com.pingtech.mock.bigdata.smartanalyze.service.CarAlongService;
import cn.com.pingtech.mock.bigdata.smartanalyze.service.CarLineService;
import cn.com.pingtech.mock.bigdata.smartanalyze.service.PeopleAlongService;
import cn.com.pingtech.mock.bigdata.smartanalyze.service.PeopleAlonggjtService;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CarAlongVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CarLineRequestVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.PeopleAlongVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.PeopleAlonggjtVo;
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
@RequestMapping(value = "/api/people-along")
@Api(value = "伴随人员",tags = {"伴随人员"})
public class PeopleAlongController {

    @Autowired
    private PeopleAlongService peoppleAlongService;

    @Autowired
    private PeopleAlonggjtService peopleAlonggjtService;

    @Autowired
    private CarLineService carLineService;

    @PostMapping("/relevance")
    @ApiOperation(value = "伴随人员查询", notes = "伴随人员查询")
    public BigDataResponseVo relevance(@ApiParam(name = "params", value = "PeopleAlongVo") @RequestBody PeopleAlongVo params){
       params.setStartTime(params.getStartTime()+ " 00:00:00");
       params.setEndTime(params.getEndTime()+" 23:59:59");
        return peoppleAlongService.relevance(params);
    }

    @PostMapping("/records")
    @ApiOperation(value = "伴随人员详情", notes = "伴随人员详情")
    public BigDataResponseVo records(@ApiParam(name = "params", value = "PeopleAlongVo") @RequestBody PeopleAlongVo params){
        params.setStartTime(params.getStartTime()+ " 00:00:00");
        params.setEndTime(params.getEndTime()+" 23:59:59");
        return peoppleAlongService.records(params);
    }

    @PostMapping("/gjt")
    @ApiOperation(value = "伴随人员轨迹图", notes = "伴随人员轨迹图")
    public BigDataResponseVo gjt(@ApiParam(name = "params", value = "PeopleAlonggjtVo") @RequestBody PeopleAlonggjtVo params){
        params.setStartTime(params.getStartTime()+ " 00:00:00");
        params.setEndTime(params.getEndTime()+" 23:59:59");
        return peopleAlonggjtService.gjt(params);
    }

    @PostMapping("/aPeopleQuery")
    @ApiOperation(value = "a伴随人员查询", notes = "a伴随人员查询")
    public BigDataResultVo aPeopleQuery(@ApiParam(name = "params", value = "CarLineRequestVo") @RequestBody CarLineRequestVo params){
        return carLineService.searchPeople(params);
    }

    @PostMapping("/bPeopleQuery")
    @ApiOperation(value = "b伴随人员查询", notes = "b伴随人员查询")
    public BigDataResultVo bPeopleQuery(@ApiParam(name = "params", value = "CarLineRequestVo") @RequestBody CarLineRequestVo params){
        return carLineService.searchPeople(params);
    }
}
