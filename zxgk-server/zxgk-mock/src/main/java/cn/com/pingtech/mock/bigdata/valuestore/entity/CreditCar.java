/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CreditCar.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CreditCar{

	private String _id;
	private String carNumber;
    private String carType; 				// 车辆类型：10小车 20 客车 30货车
    private String carNumberColor; 			// 车牌颜色：黄色，蓝色，白色；（默认：蓝色）
    private String checkType; 				// 检查类型： 0重点车辆   1普通车辆  2白名单车辆  3免检车辆
    private Double credit; 					// 当前积分，默认0分
    private Double score; 					// 当前积分，默认0分
    private Integer normalPassCount = 0; 	// 正常通行次数，用于积分计算，发现预警人员次数会重置为0；
    private Integer uncheckPassCount = 0; 	// 未检查并通行次数
    private Integer checkPassCount = 0; 	// 检查并通行次数
    
    private Integer startCredit;			//查询条件
    private Integer endCredit;				//查询条件

    private boolean comeFlag = false; 		// vo字段，标记是否经过检查站
    private Double lastCredit; 				// vo字段，保存改变前的积分，供日志使用

    private String status = "1"; 			// 数据有效性（1有效，0无效）
    private String id;

    private String remarks; // 备注
    private String createBy; // 创建者
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate; // 创建日期
    private String updateBy; // 更新者
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate; // 更新日期

    @JSONField(serialize=false)
    private String dbType;// 数据类型
    @JSONField(serialize=false)
    private String orderBy;// 排序字段


    private int page;
    private int size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
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

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public Integer getNormalPassCount() {
		return normalPassCount;
	}

	public void setNormalPassCount(Integer normalPassCount) {
		this.normalPassCount = normalPassCount;
	}

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
	public Integer getStartCredit() {
		return startCredit;
	}
	public void setStartCredit(Integer startCredit) {
		this.startCredit = startCredit;
	}
	public Integer getEndCredit() {
		return endCredit;
	}
	public void setEndCredit(Integer endCredit) {
		this.endCredit = endCredit;
	}

    public boolean isComeFlag() {
        return comeFlag;
    }

    public void setComeFlag(boolean comeFlag) {
        this.comeFlag = comeFlag;
    }

    public String getCarNumberColor() {
        return carNumberColor;
    }

    public void setCarNumberColor(String carNumberColor) {
        this.carNumberColor = carNumberColor;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getCredit() {
        return credit;
    }

    public Double getLastCredit() {
        return lastCredit;
    }

    public void setLastCredit(Double lastCredit) {
        this.lastCredit = lastCredit;
    }

    public Integer getUncheckPassCount() {
        return uncheckPassCount;
    }

    public void setUncheckPassCount(Integer uncheckPassCount) {
        this.uncheckPassCount = uncheckPassCount;
    }

    public Integer getCheckPassCount() {
        return checkPassCount;
    }

    public void setCheckPassCount(Integer checkPassCount) {
        this.checkPassCount = checkPassCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public void preInsert() {
		
	}

	public void preUpdate() {
		
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

    public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}
