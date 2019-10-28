package cn.com.pingtech;

import cn.com.pingtech.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/hi")
    public String hello(){
        return testService.test();
    }

}
