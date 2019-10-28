/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CarLineDao.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.dao;

import cn.com.pingtech.mock.bigdata.smartanalyze.entity.CarLineVo;
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
public interface ICarLineDao {

    int count(@Param("page") Page<CarLineRequestVo> page);

    List<CarLineVo> findPage(@Param("page") Page<CarLineRequestVo> page);

    int countPeople(@Param("page") Page<CarLineRequestVo> page);

    List<WarnPeopleExportVo> findPagePeople(@Param("page") Page<CarLineRequestVo> page);

    int countCar(@Param("page") Page<CarLineRequestVo> page);

    List<WarnCarExportVo> findPageCar(@Param("page") Page<CarLineRequestVo>  page);

    List<CarInfoBean> findCarInfoBean(CarLineRequestVo params);

    List<CoordinateInfoBean> findCoordinateInfoBean(CarLineRequestVo params);
}
