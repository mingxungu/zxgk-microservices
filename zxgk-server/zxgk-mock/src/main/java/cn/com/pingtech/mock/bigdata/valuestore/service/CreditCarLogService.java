/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CreditCarLogService.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.service;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataResponseVo;
import cn.com.pingtech.mock.bigdata.valuestore.dao.ICreditCarLogDao;
import cn.com.pingtech.mock.bigdata.valuestore.entity.CreditCarLog;
import cn.com.pingtech.pager.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xucongfu
 * @create 2019-10-12-9:04
 */
@Component
public class CreditCarLogService {
    @Autowired
    private ICreditCarLogDao creditCarLogDao;

    public BigDataResponseVo search(CreditCarLog params){
        Page page = new Page<CreditCarLog>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        //匹配大数据的格式
        params.setCarNumber(params.get_id());
        page.setEntity(params);

        page.setTotal(creditCarLogDao.count(page));
        List<CreditCarLog> list = creditCarLogDao.findPage(page);


        BigDataResponseVo vo = new BigDataResponseVo<CreditCarLog>();
        vo.setData(list);
        vo.setTotal(page.getTotal());

        return vo;
    }
}
