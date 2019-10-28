package cn.com.pingtech.api;

import cn.com.pingtech.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gumx
 * @className: ClientController
 * @description: ceshi
 * @date 2019/8/27 17:26
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {

        return testService.testMethod(str) + testService.testHystrix(str);
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
