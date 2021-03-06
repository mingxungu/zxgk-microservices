/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CreditCarService.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.service;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResponseVo;
import cn.com.pingtech.mock.bigdata.valuestore.dao.ICreditCarDao;
import cn.com.pingtech.mock.bigdata.valuestore.entity.CreditCar;
import cn.com.pingtech.pager.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xucongfu
 * @create 2019-10-11-11:08
 */
@Component
public class CreditCarService {

    @Autowired
    private ICreditCarDao creditCarDao;

    public BigDataResponseVo search(CreditCar params){
        Page page = new Page<CreditCar>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);

        page.setTotal(creditCarDao.count(page));
        List<CreditCar> list = creditCarDao.findPage(page);


        BigDataResponseVo vo = new BigDataResponseVo<CreditCar>();
        vo.setData(list);
        vo.setTotal(page.getTotal());

        return vo;
    }
}
