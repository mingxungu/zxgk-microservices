/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：VehiclePhoneDao.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.dao;

import cn.com.pingtech.mock.bigdata.smartanalyze.entity.VehiclePhone;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.Arr;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.DetailResponse;
import cn.com.pingtech.mock.bigdata.smartanalyze.vo.VehiclePhoneResponse;
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
public interface IVehiclePhoneDao {

    List<VehiclePhoneResponse> findList(VehiclePhone params);

    int count(@Param("page") Page<VehiclePhone> page);

    List<VehiclePhone> findPage(@Param("page") Page<VehiclePhone> page);

    int countDetail(@Param("page") Page<VehiclePhone> page);

    List<DetailResponse> findPageDetail(@Param("page") Page<VehiclePhone> page);

    List<Arr> detailfbt(DetailResponse params);
}
