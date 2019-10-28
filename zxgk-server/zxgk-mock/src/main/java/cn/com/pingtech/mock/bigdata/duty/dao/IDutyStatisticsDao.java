/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：IDutyStatisticsDao.java
 * 修改记录：
 * 1.2019年10月21日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.duty.dao;

import cn.com.pingtech.mock.bigdata.duty.vo.DutyStatisticsHjVo;
import cn.com.pingtech.mock.bigdata.duty.vo.DutyStatisticsTagVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 勤务统计
 *
 * @author PingTech
 * @since 2019-10-21
 */
@Repository
public interface IDutyStatisticsDao {
    List<DutyStatisticsTagVo> queryDutyStatisticsTagList(@Param("tag") String tag
            , @Param("passTimeStart") String passTimeStart, @Param("passTimeEnd") String passTimeEnd);

    DutyStatisticsHjVo queryDutyStatisticsHj(@Param("tag") String tag
            , @Param("passTimeStart") String passTimeStart, @Param("passTimeEnd") String passTimeEnd);
}
