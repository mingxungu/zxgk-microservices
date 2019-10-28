/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：IPeoplePhoneDao.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.dao;

import cn.com.pingtech.mock.bigdata.smartanalyze.entity.DetectPhone;
import cn.com.pingtech.mock.bigdata.smartanalyze.entity.PeoplePhone;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.*;
import cn.com.pingtech.pager.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/14
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.dao
 */
@Repository
public interface IPeoplePhoneDao {

    List<PeoplePhone> findPage(@Param("page") Page<PeoplePhone> page);

    int count(@Param("page") Page<PeoplePhone> page);

    List<PeoplePhone> findList(PeoplePhone params);

    /*List<PeoplePhone> findPageNew(@Param("page") Page<PeoplePhone> page);
    int countNew(@Param("page") Page<PeoplePhone> page);*/

    PeoplePhoneCountVo staticCount(String time);

    List<PeoplePhoneChartVo> chart(String time);

    PeoplePhoneTopChartVo topChart(String time);

    PeoplePhoneTableVo listTable(String time);

    List<PeoplePhoneExportChartVo> recordsDetailChart(PeoplePhone params);

    List<WarnPeopleExportVo> recordsDetailPeople(@Param("page") Page<PeopleRequestVo> page);

    int countPeople(@Param("page") Page<PeopleRequestVo> page);

    List<DetectPhone> recordsDetailPhone(@Param("page") Page<PhoneRequestVo> page);

    int countPhone(@Param("page") Page<PhoneRequestVo> page);
}
