/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：PeopleValue.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.entity;


/**
 * @author sunjl
 * @date 2019-7-17
 */
public class PeopleValue {

    private String idnumber; //身份证
    private String name; //姓名
    private int passCount; //通行次数
    private int fromWarnCount; //预警次数
    private int carCount; //关联车辆数
    private int imsiCount; //关联侦码数
    private int alongPeopleCount; //伴随人员数
    private String detail;

    private int page;
    private int size;

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassCount() {
        return passCount;
    }

    public void setPassCount(int passCount) {
        this.passCount = passCount;
    }

    public int getFromWarnCount() {
        return fromWarnCount;
    }

    public void setFromWarnCount(int fromWarnCount) {
        this.fromWarnCount = fromWarnCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public int getImsiCount() {
        return imsiCount;
    }

    public void setImsiCount(int imsiCount) {
        this.imsiCount = imsiCount;
    }

    public int getAlongPeopleCount() {
        return alongPeopleCount;
    }

    public void setAlongPeopleCount(int alongPeopleCount) {
        this.alongPeopleCount = alongPeopleCount;
    }

    public int getPage() {
        return page;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
