package cn.com.pingtech.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ZXGK-PRODUCER")
public interface TestService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String testMethod(@RequestParam(value = "name") String name);

}
