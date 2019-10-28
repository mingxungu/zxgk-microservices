/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：BidDataResultVo.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.common.vo;

/**
 * rest大数据接口返回数据对象
 */
public class BigDataResultVo {
	/**
	 * 结果0-失败，1-成功
	 */
	private int ret;
	/**
	 * 结果代码
	 */
	private int code;
	/**
	 * 结果消息
	 */
	private String msg;
	/**
	 * 结果数据
	 */
	private Object data;

	private boolean hasNext;
	private  boolean hasPrev;
	private int total;

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean isHasPrev() {
		return hasPrev;
	}

	public void setHasPrev(boolean hasPrev) {
		this.hasPrev = hasPrev;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	
	public BigDataResultVo(int ret, int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.ret = ret;
		this.data = data;
	}
	
	public BigDataResultVo() {
		super();
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getRet() {
		return ret;
	}
	public void setRet(int ret) {
		this.ret = ret;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
