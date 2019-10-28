/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：VehiclePhoneService.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.service;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResponseVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.dao.IVehiclePhoneDao;
import cn.com.pingtech.mock.bigdata.smartanalyze.entity.CarChart;
import cn.com.pingtech.mock.bigdata.smartanalyze.entity.PhoneCodeChart;
import cn.com.pingtech.mock.bigdata.smartanalyze.entity.VehiclePhone;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.Arr;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.DetailResponse;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.VehiclePhoneResponse;
import cn.com.pingtech.pager.Page;
import cn.com.pingtech.utils.CheckEmptyUtil;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/14
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.service
 */
@Service
public class VehiclePhoneService {

    @Autowired
    private IVehiclePhoneDao vehiclePhoneDao;

    public BigDataResponseVo analyze(VehiclePhone params){
        List<VehiclePhoneResponse> list = vehiclePhoneDao.findList(params);
        VehiclePhoneResponse response = new VehiclePhoneResponse();
        if (CheckEmptyUtil.isNotEmpty(list)){
            response = list.get(0);
        }
        ArrayList<CarChart> carCharts = new ArrayList<>(JSONArray.parseArray(response.getCarChartList(), CarChart.class));
        response.setCarChart(carCharts);
        response.setCarChartList(null);
        ArrayList<PhoneCodeChart> phoneCodeCharts = new ArrayList<>(JSONArray.parseArray(response.getPhoneCodeChartList(), PhoneCodeChart.class));
        response.setPhoneCodeChart(phoneCodeCharts);
        response.setPhoneCodeChartList(null);
        list.add(response);
        BigDataResponseVo vo = new BigDataResponseVo<VehiclePhoneResponse>();
        vo.setData(list);
        return vo;
    }



    public BigDataResponseVo relevance(VehiclePhone params){
        Page page = new Page<VehiclePhone>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);
        int count=vehiclePhoneDao.count(page);
        List<VehiclePhone> list = vehiclePhoneDao.findPage(page);
        BigDataResponseVo vo = new BigDataResponseVo<VehiclePhone>();
        vo.setData(list);
        if (count >0){
            double perc = count/(page.getPageNo()*10/1.0);
            if( perc > 1){
                vo.setHasNext(true);
            }
        }

        if (page.getPageNo() >1){
            vo.setHasPrev(true);
        }

        return vo;
    }

    public BigDataResponseVo detail(VehiclePhone params) {
        Page page = new Page<VehiclePhone>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);
        page.setTotal(vehiclePhoneDao.countDetail(page));
        List<DetailResponse> list = vehiclePhoneDao.findPageDetail(page);
        BigDataResponseVo vo = new BigDataResponseVo<DetailResponse>();
        vo.setData(list);
        vo.setTotal(page.getTotal());

        return vo;

    }

    public BigDataResponseVo<Arr> detailfbt(DetailResponse params) {
        List<Arr> resultList=vehiclePhoneDao.detailfbt(params);
        BigDataResponseVo vo = new BigDataResponseVo<DetailResponse>();
        vo.setData(resultList);
        return vo;
    }
}
