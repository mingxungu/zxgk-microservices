/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：PeopleVo.java
 * 修改记录：
 * 1.2019年10月16日，PingTecg：创建
 */

package cn.com.pingtech.mock.bigdata.smartanalyze.vo;

import lombok.Data;

/**
 * @prjectName: zxgk-microservices
 * @author: Sunj
 * @date: 2019/10/16
 * @description:
 * @packageName: cn.com.pingtech.mock.bigdata.smartanalyze.vo
 */
@Data
public class PeopleAlonggjtVo {
    private String _id;
    private String color;
    private String idNumber;
    private String type;
    private String x;
    private String y;
    private String alongIdNumber;
    private String startTime;
    private String endTime;

    private int id;
    private int page;
    private int size;



    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getAlongIdNumber() {
        return alongIdNumber;
    }

    public void setAlongIdNumber(String alongIdNumber) {
        this.alongIdNumber = alongIdNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
