/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：PeoplePhoneService.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.service;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResponseVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.dao.IPeoplePhoneDao;
import cn.com.pingtech.mock.bigdata.smartanalyze.entity.DetectPhone;
import cn.com.pingtech.mock.bigdata.smartanalyze.entity.PeoplePhone;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.*;
import cn.com.pingtech.pager.Page;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/14
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.service
 */
@NoArgsConstructor
@Data
@Component
public class PeoplePhoneService {

    @Autowired
    private IPeoplePhoneDao peoplePhoneDao;

    public BigDataResponseVo relevance(PeoplePhone params){
        Page page = new Page<PeoplePhone>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);
        int count=peoplePhoneDao.count(page);

        List<PeoplePhone> list = peoplePhoneDao.findPage(page);

        BigDataResponseVo vo = new BigDataResponseVo<PeoplePhone>();
        if (count >0){
            double perc = count/(page.getPageNo()*10/1.0);
            if( perc > 1){
                vo.setHasNext(true);
            }
        }

        if (page.getPageNo() >1){
            vo.setHasPrev(true);
        }
        vo.setData(list);
        vo.setTotal(page.getTotal());

        return vo;
    }

    public PeoplePhoneCountVo staticCount(String time) {
        return peoplePhoneDao.staticCount(time);
    }

    public List<PeoplePhoneChartVo> chart(String time) {
        return peoplePhoneDao.chart(time);
    }

    public PeoplePhoneTopChartVo topChart(String time) {
        PeoplePhoneTopChartVo peoplePhoneTopChartVo = peoplePhoneDao.topChart(time);
        List<ImsiVo> list = new ArrayList<>(JSONArray.parseArray(peoplePhoneTopChartVo.getImsiList(), ImsiVo.class));
        List<PeopleVo> list2 = new ArrayList<>(JSONArray.parseArray(peoplePhoneTopChartVo.getPeopleList(), PeopleVo.class));
        peoplePhoneTopChartVo.setImsi(list);
        peoplePhoneTopChartVo.setPeople(list2);
        peoplePhoneTopChartVo.setImsiList(null);
        peoplePhoneTopChartVo.setPeopleList(null);
        return peoplePhoneTopChartVo;
    }

    public PeoplePhoneTableVo listTable(String time) {
        PeoplePhoneTableVo tableVo = peoplePhoneDao.listTable(time);
        ArrayList<CountListVo> countListVos = new ArrayList<>(JSONArray.parseArray(tableVo.getCountList(), CountListVo.class));
        ArrayList<SimilarityListVo> similarityListVos = new ArrayList<>(JSONArray.parseArray(tableVo.getSimilarityList(), SimilarityListVo.class));
        tableVo.setCount_list(countListVos);
        tableVo.setSimilarity_list(similarityListVos);
        tableVo.setCountList(null);
        tableVo.setSimilarityList(null);
        return tableVo;
    }

    public BigDataResponseVo recordsDetail(PeoplePhone params) {
        Page page = new Page<PeoplePhone>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);
        List<PeoplePhone> list = peoplePhoneDao.findPage(page);
        page.setTotal(peoplePhoneDao.count(page));

        BigDataResponseVo vo = new BigDataResponseVo<PeoplePhone>();
        vo.setData(list);
        vo.setTotal(page.getTotal());

        return vo;

    }

    public BigDataResponseVo recordsDetailChart(PeoplePhone params) {

        BigDataResponseVo vo = new BigDataResponseVo<PeoplePhoneExportChartVo>();
        List<PeoplePhoneExportChartVo> resultList = peoplePhoneDao.recordsDetailChart(params);
        vo.setData(resultList);
        return vo;
    }


    public BigDataResponseVo recordsDetailPeople(PeopleRequestVo params) {
        Page page = new Page<PeopleRequestVo>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);
        List<WarnPeopleExportVo> resultList = peoplePhoneDao.recordsDetailPeople(page);
        page.setTotal(peoplePhoneDao.countPeople(page));
        BigDataResponseVo vo = new BigDataResponseVo<WarnPeopleExportVo>();
        vo.setData(resultList);
        vo.setTotal(page.getTotal());
        return vo;
    }

    public BigDataResponseVo recordsDetailPhone(PhoneRequestVo params) {
        Page page = new Page<PhoneRequestVo>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);
        List<DetectPhone> resultList = peoplePhoneDao.recordsDetailPhone(page);
        page.setTotal(peoplePhoneDao.countPhone(page));
        BigDataResponseVo vo = new BigDataResponseVo<DetectPhone>();
        vo.setData(resultList);
        vo.setTotal(page.getTotal());
        return vo;

    }
}
