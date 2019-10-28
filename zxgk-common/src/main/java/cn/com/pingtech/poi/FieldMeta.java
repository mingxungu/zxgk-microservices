/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：FieldMeta.java
 * 修改记录：
 * 1.2019年10月10日，PingTech：创建
 */

package cn.com.pingtech.poi;

import java.lang.annotation.*;

/**
 * 支持注解字段的类型（String,int,long.float,double,date）
 * @author Administrator
 *
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldMeta {
	
	/**
	 * 字段名称
	 * @return
	 */
	public String name();
	/**
	 * 是否为身份证字段(为身份验证做准备，普通正则难以实现精确判断身份证是否合法)
	 * @return
	 */
	public boolean isIdCard() default false;
	/**
	 * 是否为电话号码字段
	 * @return
	 */
	public boolean isPhoneNo() default false;
	/**
	 * 是否允许为空
	 * @return
	 */
	public boolean nullable() default true;
	
	/**
	 * 是否唯一
	 * @return
	 */
	public boolean unique() default false;
	
	/**
	 * 主键
	 * @return
	 */
	public boolean key() default false;
	
	/**
	 * 字典标识 : 入库转成dictValue
	 * @return
	 */
	public String dictNo() default "";

	/**
	 * 字典标识2 : dictName直接入库
	 * @return
	 */
	public String dictNo2() default "";
	
	/**
	 * 日期格式
	 * @return
	 */
	public String format() default "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 值最大长度
	 * @return
	 */
	public int maxLength() default 0;
	
	/**
	 * 固定长度
	 * @return
	 */
	public int fixLength() default 0;
	
	/**
	 * 正则表达式
	 * @return
	 */
	public String regex() default "";
	
	/**
	 * 数据集合
	 * @return
	 */
	public String[] dataArray() default {};

}
