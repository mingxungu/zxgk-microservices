/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：CreditCarLog.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.valuestore.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * Created by xuxb on 2017-11-7.
 */
public class CreditCarLog {


    protected String id;
    protected String _id;

    protected String remarks; // 备注
    protected String createBy; // 创建者
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date createDate; // 创建日期
    protected String updateBy; // 更新者
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date updateDate; // 更新日期
    protected String status; // 状态
    @JSONField(serialize=false)
    protected String dbType;// 数据类型
    @JSONField(serialize=false)
    protected String orderBy;// 排序字段

	private String creditId;
    private String carNumber;
    private String carType;
    private Double lastScore;
    private Double scoreDelta;
    private Double score;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startLastPassDate;//查询条件
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endLastPassDate;//查询条件

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startPassTimeDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endPassTimeDate;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date passTime;

    private int page;
    private int size;

    public String getId() {
        return id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public CreditCarLog() {
    }

    public CreditCarLog(CreditCar credit, Double expectScore, Double score, String remarks) {
        this.creditId = credit.getId();
        this.carNumber = credit.getCarNumber();
        this.carType = credit.getCarType();
        this.lastScore = credit.getLastCredit();
        this.score = expectScore;
        this.score = score;
        this.remarks = remarks;
        this.createDate = new Date();
        this.updateDate = this.createDate;
    }
    
    public Date getPassTime() {
		return passTime;
	}

	public void setPassTime(Date passTime) {
		this.passTime = passTime;
	}

	public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
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

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getStartLastPassDate() {
		return startLastPassDate;
	}

	public void setStartLastPassDate(Date startLastPassDate) {
		this.startLastPassDate = startLastPassDate;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getEndLastPassDate() {
		return endLastPassDate;
	}

	public void setEndLastPassDate(Date endLastPassDate) {
		this.endLastPassDate = endLastPassDate;
	}

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

	public Double getLastScore() {
		return lastScore;
	}

	public void setLastScore(Double lastScore) {
		this.lastScore = lastScore;
	}

	public Double getScoreDelta() {
		return scoreDelta;
	}

	public void setScoreDelta(Double scoreDelta) {
		this.scoreDelta = scoreDelta;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getStartPassTimeDate() {
		return startPassTimeDate;
	}

	public void setStartPassTimeDate(Date startPassTimeDate) {
		this.startPassTimeDate = startPassTimeDate;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getEndPassTimeDate() {
		return endPassTimeDate;
	}

	public void setEndPassTimeDate(Date endPassTimeDate) {
		this.endPassTimeDate = endPassTimeDate;
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
