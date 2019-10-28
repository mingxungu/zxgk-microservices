/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：RemoteHystrix.java
 * 修改记录：
 * 1.2019年10月24日，PingTech：创建
 */

package cn.com.pingtech.service;

import org.springframework.stereotype.Component;

/**
 * @author gumx
 * @className: RemoteHystrix
 * @description: 降级熔断
 * @date 2019/10/14 14:28
 */
@Component
public class RemoteHystrix implements TestService{


    public String testMethod(String name) {
        return "000000000000000000000";
    }
}
