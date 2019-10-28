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

    @Override
    public String testMethod(String str) {
        return "调用service-provider服务的echo====降级熔断处理";
    }

    @Override
    public String testHystrix(String str) {
        return "调用service-provider服务的testHystrix====降级熔断处理";
    }

    @Override
    public String test1Hystrix(String str) {
        return "调用service-provider服务的没有提供的功能==降级熔断处理";
    }
}
