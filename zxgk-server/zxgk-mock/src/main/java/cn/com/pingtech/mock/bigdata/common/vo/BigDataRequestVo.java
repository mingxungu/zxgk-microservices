/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：BigDataRequestVo.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.common.vo;

import lombok.Data;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/17
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.common
 */
@Data
public class BigDataRequestVo {
    private int page;
    private int size;

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String passTimeStart;

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String passTimeEnd;


}
