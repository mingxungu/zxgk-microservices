/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：IPeopleValueDao.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.dao;

import cn.com.pingtech.mock.bigdata.valuestore.entity.PeopleValue;
import cn.com.pingtech.pager.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xucongfu
 * @create 2019-10-12-10:59
 */
@Component
public interface IPeopleValueDao {
    List<PeopleValue> findPage(@Param("page") Page<PeopleValue> page);

    int count(@Param("page") Page<PeopleValue> page);

    List<PeopleValue> findList(PeopleValue params);

    PeopleValue detail(PeopleValue params);
}
