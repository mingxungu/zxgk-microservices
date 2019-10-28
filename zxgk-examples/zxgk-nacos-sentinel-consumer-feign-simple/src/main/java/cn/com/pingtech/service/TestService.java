package cn.com.pingtech.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@FeignClient(value = "service-provider",fallback = RemoteHystrix.class)
public interface TestService {

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    String testMethod(@PathVariable String str);


    @RequestMapping(value = "/test/{str}", method = RequestMethod.GET)
    String testHystrix(@PathVariable String str);

    @RequestMapping(value = "/test1/{str}", method = RequestMethod.GET)
    String test1Hystrix(@PathVariable String str);

}
