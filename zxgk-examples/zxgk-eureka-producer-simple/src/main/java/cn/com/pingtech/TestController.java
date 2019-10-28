package cn.com.pingtech;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gumx
 * @className: ClientController
 * @description: ceshi
 * @date 2019/8/27 17:26
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello this is zxgk-eureka-producer-simple";
    }
}
