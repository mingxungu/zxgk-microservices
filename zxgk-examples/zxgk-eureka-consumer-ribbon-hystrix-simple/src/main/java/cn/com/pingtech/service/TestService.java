package cn.com.pingtech.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author gumx
 * @className: TestService
 * @description: 测试服务
 * @date 2019/8/28 15:49
 */
@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String test(){
        return restTemplate.getForObject("http://ZXGK-PRODUCER/hello", String.class);
    }

    public String hiError(){
        return "服务调用错误Hystrix启用。。。。。调用错误方法";
    }
}
