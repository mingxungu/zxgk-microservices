/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：WarnPeopleExportVo.java
 * 修改记录：
 * 1.2019年10月18日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author zhuj
 * @desc
 * @create 2019-08-07 17:00
 **/
@Data
public class WarnPeopleExportVo {
    private static final long serialVersionUID = 1L;

    private String carId = ""; // 车辆通行记录ID，人车绑定
    private String carNumber = ""; //车牌号码
    private String carColor = "";  //车辆颜色

    private String _id = "";		//大数据平台id
    private String name = "";		//姓名
    private String sex = ""; //性别
    private String nation = ""; //民族
    private String idnumber = "";   //身份证

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday; //生日

    private String address = ""; //地址

    private String issuingAuthority = ""; //身份证签发机关

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validStartTime; //身份证有效期开始时间

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validEndTime; //身份证有效期结束时间

    private String captureImage = ""; //现场照片ID

    private String certificateImage = ""; //证件照片

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date passtime;   //通行时间
    private String checkRegion = ""; //核查区域
    private String checkstatus = ""; //核查状态
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date passTimeStart; //通行开始时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date passTimeEnd; //通行结束时间

    private String comparisonresult = "";	 //人证合一结果
    private String comparisonsimilarity = "";   //人证合一相似度
    private String checkMsg = "";       //核查信息
    private String checkMsgMax;	// 最高级别预警信息
    private String age = "";      //年龄
    private String jsInfo;	// 警示信息

    private String dealStatus = "";
    private String dealResult = "";
    private String dealRemark = "";

    public String origin = ""; //记录来源

    private Integer fromWarn = 0;  //数据来源于预警

    private Integer fromPasslog = 0; //数据来源于通行记录

    private String checkColor = ""; // 预警颜色

    private String blackSource = "";//黑名单布控来源（0为布控 1本地布控  2第三方布控）

    private String checkColorMax = "";//该人员预警的最高级别

    private String warnerPhone = "";

    private String policeName = "";    //警员姓名
    private Integer cardType;    //证件类型（10身份证，默认；14普通护照）
    private String countryCode;    //国籍（CHN中国，默认；USA美国；等）
    private Integer dataSource;    //信息来源（1-身份证阅读器，默认；2-OCR；3-无证；）


    private String tag = "";             //标签，标示每个检查站
    private String tagName = "";             //检查站名称
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date receiveMQDataTime; //接收MQ数据的时间（插入数据库的真正时间）

    /**关联人员信息*/
    private String peopleId;
    /**处置民警ID*/
    private String policeId;
    /**处置辅警NAME*/
    private String assistantPoliceName;
    /**处置方式：1排除 2留置3存疑*/
    private Integer disposeType;
    private String disposeTypeName;
    /**人员类别*/
    private String peopleType;
    /**接收单位*/
    private String receivingUnit;
    /**接收单位编码*/
    private String receivingUnitNo;
    /**接收人*/
    private String receiverName;
    /**接收人联系方式*/
    private String receiverPhoneNo;
    /**处置结果*/
    private String result;

    /**处置情况：0暂存，1完成*/
    private String status;

    /** 处置类型：1.人员，2.车辆 auth：kongls*/
    private String dealType;

    /**采集预警信息的设备ip*/
    private String ip;
    /**民警身份证号*/
    private String policeIdcard;
    /**警号*/
    private String policeNo;
    /**工作建议*/
    private String workSuggest;
    /**工作建议类别*/
    private String suggestType;
    /**存疑原因*/
    private String impeachCause;
    /**留置状态 1移交 2自处理*/
    private String retentionStatus;
    /**留置措施*/
    private String retentionMeasure;
    /**接收时间*/
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date receiverTime;

    private String idNumber;
    /**核查简单描述*/
    private String checkPhrase;
    /**对应的人车记录的通行时间，辅助战果统计*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date passTime;

    private String orgName = "";
    private String orgTag;
    private  int isSwan=1;
    private boolean hidden=true;
}
