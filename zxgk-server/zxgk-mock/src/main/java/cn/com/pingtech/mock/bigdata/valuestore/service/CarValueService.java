/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CarValueService.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.service;

import cn.com.pingtech.api.entity.ResponseVo;
import cn.com.pingtech.mock.bigdata.common.vo.BigDataResponseVo;
import cn.com.pingtech.mock.bigdata.valuestore.dao.ICarValueDao;
import cn.com.pingtech.mock.bigdata.valuestore.entity.CarValue;
import cn.com.pingtech.pager.Page;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xucongfu
 * @create 2019-10-12-11:01
 */
@Component
public class CarValueService {

    @Autowired
    private ICarValueDao carValueDao;

    public BigDataResponseVo search(CarValue params){
        Page page = new Page<CarValue>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);

        page.setTotal(carValueDao.count(page));
        List<CarValue> list = carValueDao.findPage(page);


        BigDataResponseVo vo = new BigDataResponseVo<CarValue>();
        vo.setData(list);
        vo.setTotal(page.getTotal());

        return vo;
    }

    public ResponseVo detail(CarValue params){

        CarValue carValue = carValueDao.detail(params);

        ResponseVo vo = new ResponseVo();
        JSONObject jsonObject = JSONObject.parseObject(carValue.getDetail().replaceAll("\n","").replaceAll("\t",""));
        vo.setData(jsonObject);
        return vo;
    }


}
