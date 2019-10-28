/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CarChart.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.entity;

/**
 * @author sunjl
 * @date 2019-04-23
 */
public class CarChart {

    private int minSimilarity; //关联度
	private long chartcarCount;//车辆数

    public int getMinSimilarity() {
        return minSimilarity;
    }

    public void setMinSimilarity(int minSimilarity) {
        this.minSimilarity = minSimilarity;
    }

    public long getChartcarCount() {
        return chartcarCount;
    }

    public void setChartcarCount(long chartcarCount) {
        this.chartcarCount = chartcarCount;
    }
}
