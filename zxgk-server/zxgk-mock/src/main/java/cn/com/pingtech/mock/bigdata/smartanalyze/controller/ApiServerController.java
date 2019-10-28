/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：ApiForwardController.java
 * 修改记录：
 * 1.2019年10月15日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.controller;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResultVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.service.CarLineService;
import cn.com.pingtech.mock.bigdata.smartanalyze.service.PeoplePhoneService;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CarLineRequestVo;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/15
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.controller
 */
@Api(value = "平台请求转发后的接收接口",tags = {"平台请求转发后的接收接口"})
@RestController
@RequestMapping(value = "/api")
public class ApiServerController {
    /**
     * @description:人码关联分析：人码模型分析
     */
    @Autowired
    private PeoplePhoneService peoplePhoneService;

    @RequestMapping(value = "/people-code/count",method = RequestMethod.GET)
    @ApiOperation(value = "获取圆环信息", notes = "人码模型分析")
    public String apiCountModel(String time){
        BigDataResultVo vo = new BigDataResultVo(0,0,null,null);
        vo.setData(peoplePhoneService.staticCount(time));
        return JSON.toJSONString(vo);
    }

    @RequestMapping(value = "/people-code/agg/chart",method = RequestMethod.GET)
    @ApiOperation(value = "获取纵向折线信息", notes = "人码模型分析")
    public String apiLineModel(String time){
        BigDataResultVo vo = new BigDataResultVo(0,0,null,null);
        vo.setData(peoplePhoneService.chart(time));
        return JSON.toJSONString(vo);
    }

    @RequestMapping(value = "/people-code/agg/chart/top",method = RequestMethod.GET)
    @ApiOperation(value = "获取横向柱状图数据信息", notes = "人码模型分析")
    public String apiTopChartModel(String time){
        BigDataResultVo vo = new BigDataResultVo(0,0,null,null);
        vo.setData(peoplePhoneService.topChart(time));
        return JSON.toJSONString(vo);
    }

    @RequestMapping(value = "/people-code/list",method = RequestMethod.GET)
    @ApiOperation(value = "获取两个表格数据信息", notes = "人码模型分析")
    public String apiTableModel(String time){
        BigDataResultVo vo = new BigDataResultVo(0,0,null,null);
        vo.setData(peoplePhoneService.listTable(time));
        return JSON.toJSONString(vo);
    }

    /**
     * @description:车辆轨迹分析搜索结果接口
     */
    @Autowired
    CarLineService carLineService;
    @RequestMapping(value = "/passlog/statics/search",method = RequestMethod.POST)
    @ApiOperation(value = "车辆轨迹分析", notes = "车辆轨迹分析")
    public BigDataResultVo apicarLineSearch(@ApiParam(name = "params", value = "CarLineRequestVo")@RequestBody CarLineRequestVo params){
        return carLineService.search(params);
    }


}
