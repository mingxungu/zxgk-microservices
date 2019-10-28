/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：TableMeta.java
 * 修改记录：
 * 1.2019年10月10日，PingTech：创建
 */

package cn.com.pingtech.poi;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableMeta {
	
	/**
	 * 数据页名称
	 * @return
	 */
	public String name() default "Sheet1";
	
	/**
	 * 是否校验数据也表头
	 * @return
	 */
	public boolean checkTitle() default true;
	
	/**
	 * 导入数据的最大数量
	 * @return
	 */
	public int maxCount() default 5000;
	
	/**
	 * 是否开启主键
	 * @return
	 */
	public boolean keyEnabled() default false;

}
