package cn.com.pingtech.controller;

import cn.com.pingtech.service.TestService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gumx
 * @className: TestController
 * @description: 测试
 * @date 2019/8/28 13:39
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @SentinelResource("resource")
    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return testService.testMethod(str);
    }

    @RequestMapping(value = "/test/{str}", method = RequestMethod.GET)
    public String testHystrix(@PathVariable String str) {
        return testService.testHystrix(str);
    }

    @RequestMapping(value = "/test1/{str}", method = RequestMethod.GET)
    public String test1Hystrix(@PathVariable String str) {
        return testService.test1Hystrix(str);
    }
}
