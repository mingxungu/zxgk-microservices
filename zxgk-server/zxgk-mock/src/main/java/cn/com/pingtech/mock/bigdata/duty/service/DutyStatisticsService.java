/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：DutyStatisticsService.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.duty.service;

import cn.com.pingtech.mock.bigdata.duty.dao.IDutyStatisticsDao;
import cn.com.pingtech.mock.bigdata.duty.vo.DutyStatisticsHjVo;
import cn.com.pingtech.mock.bigdata.duty.vo.DutyStatisticsTagVo;
import cn.com.pingtech.mock.bigdata.duty.vo.DutyStatisticsVo;
import cn.com.pingtech.poi.ExcelReader;
import cn.com.pingtech.utils.CheckEmptyUtil;
import cn.com.pingtech.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 勤务统计
 *
 * @author PingTech
 * @since 2019-10-10
 */
@Service
public class DutyStatisticsService {
    @Resource
    private IDutyStatisticsDao dutyStatisticsDao;

    /**
     * 勤务统计查询
     *
     * @param tag           组织Code
     * @param passTimeStart 开始时间
     * @param passTimeEnd   结束时间
     * @return 统计结果
     */
    public DutyStatisticsVo search(String tag, String passTimeStart, String passTimeEnd) {
        DutyStatisticsVo dutyStatisticsVo = new DutyStatisticsVo();
        dutyStatisticsVo.setTagData(dutyStatisticsDao.queryDutyStatisticsTagList(tag, passTimeStart, passTimeEnd));
        dutyStatisticsVo.setHjData(dutyStatisticsDao.queryDutyStatisticsHj(tag, passTimeStart, passTimeEnd));

        return dutyStatisticsVo;
    }

    /**
     * 勤务统计查询
     *
     * @param tag           组织Code
     * @param passTimeStart 开始时间
     * @param passTimeEnd   结束时间
     * @return 统计结果
     */
    public DutyStatisticsVo searchFromExcel(String tag, String passTimeStart, String passTimeEnd) {
        String fileName = "/data/bigdata/dutyStatistics-search.xlsx";
        ExcelReader reader = null;

        DutyStatisticsVo dutyStatisticsVo = new DutyStatisticsVo();
        try (InputStream inputStream = this.getClass().getResourceAsStream(fileName)) {
            reader = new ExcelReader(inputStream, ExcelReader.ExcelType.Excel_2007);


            List<String> errorMessageList = new ArrayList<String>();
            List<DutyStatisticsTagVo> flowMajorCarList
                    = (List<DutyStatisticsTagVo>) reader.readList(DutyStatisticsTagVo.class, errorMessageList);

            // 条件过滤
            Date passTimeStartDate = CheckEmptyUtil.isNotEmpty(passTimeStart)
                    ? DateUtils.parseDate(passTimeStart, "yyyy-MM-dd") : null;
            Date passTimeEndDate = CheckEmptyUtil.isNotEmpty(passTimeEnd)
                    ? DateUtils.parseDate(passTimeEnd, "yyyy-MM-dd") : null;
            flowMajorCarList = flowMajorCarList.parallelStream()
                    .filter(item -> Arrays.asList(tag.split(",")).contains(item.getTag())
                            && (passTimeStartDate == null || !passTimeStartDate.after(item.getPassTime()))
                            && (passTimeEndDate == null || !passTimeEndDate.before(item.getPassTime())))
                    .collect(Collectors.toList());

            // 分组汇总
            Map<String, DutyStatisticsTagVo> groupByTagSumMap = new HashMap<>();
            DutyStatisticsHjVo dutyStatisticsHjVo = new DutyStatisticsHjVo();
            flowMajorCarList.forEach(item -> {
                if (!groupByTagSumMap.containsKey(item.getTag())) {
                    groupByTagSumMap.put(item.getTag(), new DutyStatisticsTagVo());
                    groupByTagSumMap.get(item.getTag()).setTag(item.getTag());
                }
                groupByTagSumMap.get(item.getTag()).setPassTotal(
                        groupByTagSumMap.get(item.getTag()).getPassTotal() + item.getPassTotal());
                groupByTagSumMap.get(item.getTag()).setHcTotal(
                        groupByTagSumMap.get(item.getTag()).getHcTotal() + item.getHcTotal());
                groupByTagSumMap.get(item.getTag()).setQxcTotal(
                        groupByTagSumMap.get(item.getTag()).getQxcTotal() + item.getQxcTotal());
                groupByTagSumMap.get(item.getTag()).setQxcHcTotal(
                        groupByTagSumMap.get(item.getTag()).getQxcHcTotal() + item.getQxcHcTotal());
                groupByTagSumMap.get(item.getTag()).setQxchcRate(
                        (groupByTagSumMap.get(item.getTag()).getQxcHcTotal() * 10000) / groupByTagSumMap.get(item.getTag()).getQxcTotal() * 1.0 / 100);
                groupByTagSumMap.get(item.getTag()).setQtcTotal(
                        groupByTagSumMap.get(item.getTag()).getQtcTotal() + item.getQtcTotal());
                groupByTagSumMap.get(item.getTag()).setQtcHcTotal(
                        groupByTagSumMap.get(item.getTag()).getQtcHcTotal() + item.getQtcHcTotal());
                groupByTagSumMap.get(item.getTag()).setQtchcRate(
                        (groupByTagSumMap.get(item.getTag()).getQtcHcTotal() * 10000) / groupByTagSumMap.get(item.getTag()).getQtcTotal() * 1.0 / 100);


                dutyStatisticsHjVo.setPassTotalHj(dutyStatisticsHjVo.getPassTotalHj() + item.getPassTotal());
                dutyStatisticsHjVo.setHcTotalHj(dutyStatisticsHjVo.getHcTotalHj() + item.getHcTotal());
                dutyStatisticsHjVo.setQxcTotalHj(dutyStatisticsHjVo.getQxcTotalHj() + item.getQxcTotal());
                dutyStatisticsHjVo.setQxcHcTotalHj(dutyStatisticsHjVo.getQxcHcTotalHj() + item.getQxcHcTotal());
                dutyStatisticsHjVo.setQxchcRateHj((dutyStatisticsHjVo.getQxcHcTotalHj() * 10000) / dutyStatisticsHjVo.getQxcTotalHj() * 1.0 / 100);
                dutyStatisticsHjVo.setQtcTotalHj(dutyStatisticsHjVo.getQtcTotalHj() + item.getQtcTotal());
                dutyStatisticsHjVo.setQtcHcTotalHj(dutyStatisticsHjVo.getQtcHcTotalHj() + item.getQtcHcTotal());
                dutyStatisticsHjVo.setQtchcRateHj((dutyStatisticsHjVo.getQtcHcTotalHj() * 10000) / dutyStatisticsHjVo.getQtcTotalHj() * 1.0 / 100);

            });

            // 排序
            flowMajorCarList = groupByTagSumMap.values().parallelStream()
                    .collect(Collectors.toList());
            flowMajorCarList.sort(Comparator.comparing(DutyStatisticsTagVo::getTag));

            dutyStatisticsVo.setTagData(flowMajorCarList);
            dutyStatisticsVo.setHjData(dutyStatisticsHjVo);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return dutyStatisticsVo;
    }
}
