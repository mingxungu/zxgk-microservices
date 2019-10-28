package cn.com.pingtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hello(){
        return restTemplate.getForObject("http://ZXGK-PRODUCER/hello", String.class);
    }

}
