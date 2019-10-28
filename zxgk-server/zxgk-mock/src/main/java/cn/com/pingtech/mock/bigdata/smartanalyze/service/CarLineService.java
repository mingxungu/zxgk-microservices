/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CarLineService.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.service;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResultVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.dao.ICarLineDao;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CarChartExportVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CarInfoBean;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CarLineRequestVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CoordinateInfoBean;
import cn.com.pingtech.pager.Page;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class CarLineService  {
    @Autowired
    ICarLineDao carLineDao;

    public BigDataResultVo search(CarLineRequestVo params) {
        BigDataResultVo resultVo =new BigDataResultVo(1,0,null,null);
        Page page =new Page<CarLineRequestVo>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);
        resultVo.setTotal(carLineDao.count(page));
        resultVo.setData(carLineDao.findPage(page));
        return resultVo;
    }

    public BigDataResultVo searchPeople(CarLineRequestVo params) {
        params.setPassTimeStart(params.getPassTimeStart()+" 00:00:00");
        params.setPassTimeEnd(params.getPassTimeEnd()+" 23:59:59");
        BigDataResultVo resultVo =new BigDataResultVo(1,0,null,null);
        Page page =new Page<CarLineRequestVo>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);
        resultVo.setTotal(carLineDao.countPeople(page));
        resultVo.setData(carLineDao.findPagePeople(page));
        return resultVo;

    }

    public BigDataResultVo searchCar(CarLineRequestVo params) {
        params.setPassTimeStart(params.getPassTimeStart()+" 00:00:00");
        params.setPassTimeEnd(params.getPassTimeEnd()+" 23:59:59");
        BigDataResultVo resultVo =new BigDataResultVo(1,0,null,null);
        Page page =new Page<CarLineRequestVo>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);
        resultVo.setTotal(carLineDao.countCar(page));
        resultVo.setData(carLineDao.findPageCar(page));
        return resultVo;
    }

    public BigDataResultVo searchCarChart(CarLineRequestVo params) {
        CarInfoBean carChart = new CarInfoBean();
        params.setPassTimeStart(params.getPassTimeStart()+" 00:00:00");
        params.setPassTimeEnd(params.getPassTimeEnd()+" 23:59:59");
        BigDataResultVo resultVo = new BigDataResultVo(1, 0, null, null);
        List<CarInfoBean> carChartList = carLineDao.findCarInfoBean(params);
        if(carChartList !=null){
             carChart =carChartList.get(0);
        }
        List<CoordinateInfoBean> coordinateInfo = carLineDao.findCoordinateInfoBean(params);
        CarChartExportVo result = new CarChartExportVo(carChart,coordinateInfo);
        resultVo.setData(result);
        return resultVo;
    }
}
