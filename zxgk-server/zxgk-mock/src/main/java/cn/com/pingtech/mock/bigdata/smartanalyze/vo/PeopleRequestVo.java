/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：PeopleRequestVo.java
 * 修改记录：
 * 1.2019年10月21日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import cn.com.pingtech.mock.bigdata.common.vo.BigDataRequestVo;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/21
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.vo
 */
@Data
public class PeopleRequestVo extends BigDataRequestVo {

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private String passTimeStart; //通行开始时间

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private String passTimeEnd; //通行结束时间

    private String idnumber;
    private String name;


}
