/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：DetectPhone.java
 * 修改记录：
 * 1.2019年10月21日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.entity;


public class DetectPhone  {
	
	private static final long serialVersionUID = 1L;
	
	private String tag;  //检查站代码
	private String company; //设备的公司代码
	private String operationDepartment; //运营商(大数据)
	private String seq; //每一个基站对所采集的数据独立编编号
	private String deviceNo; //设备编号
	private String equipNum; //设备编号(大数据平台)
	private String stationNo; //基站编号
	private String gatherTime; //采集时间
	private String imsi;  //采集数据的卡号
	private String imei;  //采集数据的设备号
	private String tmsi;  //采集数据的临时用户标识
	private String lac;   //终端被采集前公网LAC
	private String msisdn; //IMSI对应的手机号码
	private String mme;   //前4位为MME分组号，后4位为MEID
	private String checkStatus; //核查状态
	private String checkColor; //核查颜色
	private String checkMsg; //预警信息
	private String blackSource; //布控来源（1本地 2市局 3第三方）

	private String tagName;  //检查站名称(表中没有该字段)
	
	private String checkRegion;
	
	/** add by wangts Date:2019/8/2
	 * begin
	 */
	private String name; //机主姓名
	private String idNumber;//机主身份证号
	private String certificateImage;//机主身份证照片
	private String phone;//手机号
	private String relatedPlate;//关联车牌（车牌号，多个值逗号分隔）
	private String ownerRelatedPlate;//机主关联车辆（车牌号_颜色）
	private String detectRelatedPlate;//车码分析关联车辆（车牌号_颜色，多个值逗号分隔）
	/**
	 * add over
	 */
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOperationDepartment() {
        return operationDepartment;
    }

    public void setOperationDepartment(String operationDepartment) {
        this.operationDepartment = operationDepartment;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getEquipNum() {
        return equipNum;
    }

    public void setEquipNum(String equipNum) {
        this.equipNum = equipNum;
    }

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo;
    }

    public String getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(String gatherTime) {
        this.gatherTime = gatherTime;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getTmsi() {
        return tmsi;
    }

    public void setTmsi(String tmsi) {
        this.tmsi = tmsi;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMme() {
        return mme;
    }

    public void setMme(String mme) {
        this.mme = mme;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckColor() {
        return checkColor;
    }

    public void setCheckColor(String checkColor) {
        this.checkColor = checkColor;
    }

    public String getCheckMsg() {
        return checkMsg;
    }

    public void setCheckMsg(String checkMsg) {
        this.checkMsg = checkMsg;
    }

    public String getBlackSource() {
        return blackSource;
    }

    public void setBlackSource(String blackSource) {
        this.blackSource = blackSource;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getCheckRegion() {
        return checkRegion;
    }

    public void setCheckRegion(String checkRegion) {
        this.checkRegion = checkRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCertificateImage() {
        return certificateImage;
    }

    public void setCertificateImage(String certificateImage) {
        this.certificateImage = certificateImage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRelatedPlate() {
        return relatedPlate;
    }

    public void setRelatedPlate(String relatedPlate) {
        this.relatedPlate = relatedPlate;
    }

    public String getOwnerRelatedPlate() {
        return ownerRelatedPlate;
    }

    public void setOwnerRelatedPlate(String ownerRelatedPlate) {
        this.ownerRelatedPlate = ownerRelatedPlate;
    }

    public String getDetectRelatedPlate() {
        return detectRelatedPlate;
    }

    public void setDetectRelatedPlate(String detectRelatedPlate) {
        this.detectRelatedPlate = detectRelatedPlate;
    }
  
}
