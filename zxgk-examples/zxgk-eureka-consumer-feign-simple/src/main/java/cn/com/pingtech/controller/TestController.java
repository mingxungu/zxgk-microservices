package cn.com.pingtech.controller;

import cn.com.pingtech.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return testService.testMethod(name);
    }
}
