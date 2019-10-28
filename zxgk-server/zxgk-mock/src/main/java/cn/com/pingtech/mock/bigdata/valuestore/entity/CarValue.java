/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CarValue.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.entity;

public class CarValue {

    private String id;
    private String _id;
    private String carNumber;
    private String carColor;
    private String carType;
    private String passCount;  //通行次数
    private String fromWarnCount; //预警次数
    private String peopleCount; //关联人员数
    private String imsiCount;   //关联帧码数
    private String alongCarCount; //伴随车辆数
    private String detail;

    private int page;
    private int size;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getPassCount() {
        return passCount;
    }
    public void setPassCount(String passCount) {
        this.passCount = passCount;
    }
    public String getFromWarnCount() {
        return fromWarnCount;
    }
    public void setFromWarnCount(String fromWarnCount) {
        this.fromWarnCount = fromWarnCount;
    }
    public String getPeopleCount() {
        return peopleCount;
    }
    public void setPeopleCount(String peopleCount) {
        this.peopleCount = peopleCount;
    }
    public String getImsiCount() {
        return imsiCount;
    }
    public void setImsiCount(String imsiCount) {
        this.imsiCount = imsiCount;
    }
    public String getAlongCarCount() {
        return alongCarCount;
    }
    public void setAlongCarCount(String alongCarCount) {
        this.alongCarCount = alongCarCount;
    }
    public String getCarColor() {
        return carColor;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getPage() {
        return page;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
