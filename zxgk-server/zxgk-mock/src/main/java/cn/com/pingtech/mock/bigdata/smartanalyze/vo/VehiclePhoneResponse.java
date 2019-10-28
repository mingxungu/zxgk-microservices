/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：VehiclePhoneResponse.java
 * 修改记录：
 * 1.2019年10月14日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import cn.com.pingtech.mock.bigdata.smartanalyze.entity.CarChart;
import cn.com.pingtech.mock.bigdata.smartanalyze.entity.PhoneCodeChart;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

/**
 * @author sunjl
 * @date 2019-04-23
 */
@Data
public class VehiclePhoneResponse {

    private long carCount=1003123;//车辆数
    private long phoneCodeCount; //手机侦码数
    private long carPassCount=1926018;//车次
    private long phoneCodeRecordCount=207379130;//侦码记录数

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String modelRunTime="2019-07-01";//模型运行时间

    private List<CarChart> carChart;
    private String carChartList="[{\"minSimilarity\":0,\"chartcarCount\":0},{\"minSimilarity\":10,\"chartcarCount\":0},{\"minSimilarity\":20,\"chartcarCount\":0},{\"minSimilarity\":30,\"chartcarCount\":0},{\"minSimilarity\":40,\"chartcarCount\":0},{\"minSimilarity\":50,\"chartcarCount\":0},{\"minSimilarity\":60,\"chartcarCount\":0},{\"minSimilarity\":70,\"chartcarCount\":0},{\"minSimilarity\":80,\"chartcarCount\":0},{\"minSimilarity\":90,\"chartcarCount\":0},{\"minSimilarity\":100,\"chartcarCount\":0}]";
    private  List<PhoneCodeChart> phoneCodeChart;
    private String phoneCodeChartList ="[{\"minSimilarity\":0,\"codeCount\":0},{\"minSimilarity\":10,\"codeCount\":0},{\"minSimilarity\":20,\"codeCount\":0},{\"minSimilarity\":30,\"codeCount\":0},{\"minSimilarity\":40,\"codeCount\":0},{\"minSimilarity\":50,\"codeCount\":0},{\"minSimilarity\":60,\"codeCount\":0},{\"minSimilarity\":70,\"codeCount\":0},{\"minSimilarity\":80,\"codeCount\":0},{\"minSimilarity\":90,\"codeCount\":0},{\"minSimilarity\":100,\"codeCount\":0}]";

}
