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
import cn.com.pingtech.mock.bigdata.smartanalyze.dao.ICarAlongDao;
import cn.com.pingtech.mock.bigdata.smartanalyze.dao.IPeopleAlongDao;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.CarAlongVo;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.PeopleAlongVo;
import cn.com.pingtech.pager.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/14
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.service
 */
@Component
public class PeopleAlongService {

    @Autowired
    private IPeopleAlongDao peopleAlongDao;

    public BigDataResponseVo relevance(PeopleAlongVo params){
        Page page = new Page<PeopleAlongVo>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);

        page.setTotal(peopleAlongDao.count(page));
        List<PeopleAlongVo> list = peopleAlongDao.findPage(page);


        BigDataResponseVo vo = new BigDataResponseVo<PeopleAlongVo>();
        vo.setData(list);
        vo.setTotal(page.getTotal());

        return vo;
    }

    public BigDataResponseVo records(PeopleAlongVo params){
        Page page = new Page<PeopleAlongVo>();
        page.setPageNo(params.getPage());
        page.setPageSize(params.getSize());
        page.setEntity(params);

        page.setTotal(peopleAlongDao.countDetail(page));
        List<PeopleAlongVo> list = peopleAlongDao.findPageDetail(page);


        BigDataResponseVo vo = new BigDataResponseVo<PeopleAlongVo>();
        vo.setData(list);
        vo.setTotal(page.getTotal());

        return vo;
    }
}
