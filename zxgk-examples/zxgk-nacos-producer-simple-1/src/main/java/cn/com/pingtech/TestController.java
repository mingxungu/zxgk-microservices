package cn.com.pingtech;

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

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "11 Hello Nacos Discovery " + string;
    }


    @RequestMapping(value = "/test/{string}", method = RequestMethod.GET)
    public String test(@PathVariable String string) throws Exception{
        Thread.sleep(2000);
        return "11 Hello Nacos Discovery " + string;
    }


}
