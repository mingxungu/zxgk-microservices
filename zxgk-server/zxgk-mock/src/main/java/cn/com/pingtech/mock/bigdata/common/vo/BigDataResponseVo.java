/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：BigDataResponseVo.java
 * 修改记录：
 * 1.2019年10月18日，PingTech：创建
 */

package cn.com.pingtech.mock.bigdata.common.vo;

import java.io.Serializable;
import java.util.List;

public class BigDataResponseVo<T> implements Serializable {

	private static final long serialVersionUID = 4303235430331755204L;

	public int code; //数据状态

	public String msg;  //状态信息

	public int count; //数据总数
	
	private int total;//数据总数:大数据use

    private boolean hasNext;
    private boolean hasPrev;

	public List<T> data; //数据列表

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

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

    public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
   
	public BigDataResponseVo relogin() {
		this.setCode(500);
		this.setMsg("登录超时,请重新登录");
		return this;
	}
	
	
	public BigDataResponseVo success(int count, List<T> data) {
		this.setCode(0);
		this.setMsg("成功");
		this.setCount(count);
		this.setData(data);
		return this;
	}

	public BigDataResponseVo error() {
		this.setCode(0);
		this.setMsg("失败");
		return this;
	}
	//for审批管理模块
	public BigDataResponseVo error(String msg){
		this.setCode(2);
		this.setMsg("失败！"+msg);
		return this;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
