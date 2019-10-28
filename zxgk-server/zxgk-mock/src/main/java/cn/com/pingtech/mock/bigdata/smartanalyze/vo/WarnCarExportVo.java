/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：WarnCarExportVo.java
 * 修改记录：
 * 1.2019年10月21日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @prjectName: zxgk-microservices
 * @author: Wangts
 * @date: 2019/10/21
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.vo
 */
@NoArgsConstructor
@Data
public class WarnCarExportVo {
        /**
         * blackSource : D4
         * fromWarn : 1
         * updateDate : 2019-10-18 14:01:00
         * checkMsg : 涉毒人员关联车辆
         * carTypeExtend : 99
         * origin : 11011910020201
         * passTime : 2019-10-18 14:10:55
         * captureImage : group1/M00/00/00/CgoP2lvJcXOANuieAAOjwN_1QSA015.jpg
         * jsInfo : [{"jscolor":"1","jsname":"涉毒人员关联车辆"}]
         * carColor : 蓝色
         * checkStatus : 1
         * carType : 未知
         * driverIdNumber : 653125198102125027
         * province : 苏
         * verifyStatus : 1
         * limit : 0
         * id : 391951676560375808
         * tag : 1101191002
         * credit : 0
         * checkRegion : 2011
         * createDate : 2019-10-18 13:56:02
         * passAdvise : 4
         * checkType : 0
         * passHour : 14
         * confidenceDetail : 96,64,98,97,98,96,97,0,0,0,0,0,0,0,0,0
         * orgName : 黄裕口卡口
         * plateType : 标准民用车与军车车牌
         * confidence : 98
         * passText : 请下车H
         * dbType : mysql
         * dealStatus : 2
         * fromPasslog : 1
         * carNumber : 苏A00004
         * isSwan : 1
         * checkMsgMax : 涉毒
         * checkColor : 红色
         * orgTag : 1101191002
         * isNewId : false
         * driverName : 测试4
         * carNumberColor : 苏A00004,蓝色
         * _id : MTEwMTE5MTBfMzkxOTUxNjc2NTYwMzc1ODA4
         * status : 0
         * libIfRecord : 0
         * joinPass : 0
         * vehicleBottomImage : group1/M00/00/00/CgoP2lvJcXOANuieAAOjwN_1QSA024.jpg
         * directionType : 1
         * yearRuleGo : 0
         */
        private String blackSource;
        private String fromWarn;
        private String updateDate;
        private String checkMsg;
        private String carTypeExtend;
        private String origin;
        private String passTime;
        private String captureImage;
        private String jsInfo;
        private String carColor;
        private String checkStatus;
        private String carType;
        private String driverIdNumber;
        private String province;
        private int verifyStatus;
        private int limit;
        private String id;
        private String tag;
        private int credit;
        private String checkRegion;
        private String createDate;
        private String passAdvise;
        private String checkType;
        private int passHour;
        private String confidenceDetail;
        private String orgName;
        private String plateType;
        private int confidence;
        private String passText;
        private String dbType;
        private String dealStatus;
        private String fromPasslog;
        private String carNumber;
        private int isSwan;
        private String checkMsgMax;
        private String checkColor;
        private String orgTag;
        private boolean isNewId;
        private String driverName;
        private String carNumberColor;
        private String status;
        private String libIfRecord;
        private String joinPass;
        private String vehicleBottomImage;
        private String directionType;
        private int yearRuleGo;
}
