/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CarInfoBean.java
 * 修改记录：
 * 1.2019年10月21日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

    @NoArgsConstructor
    @Data
    public  class CarInfoBean {
        /**
         * carNumber : 苏A00004
         * carColor : 蓝色
         * carType : 未知
         * bodyColor : null
         * carBrand : null
         * captureImage : group1/M00/00/00/CgoP2lvJcXOANuieAAOjwN_1QSA015.jpg
         * tag : 1101191002
         */

        private String carNumber;
        private String carColor;
        private String carType;
        private Object bodyColor;
        private Object carBrand;
        private String captureImage;
        private String tag;
    }