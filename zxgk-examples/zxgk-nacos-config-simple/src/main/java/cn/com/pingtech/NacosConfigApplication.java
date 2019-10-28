package cn.com.pingtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gumx
 * @className: NacosProviderApplication
 * @description: nacos服务发现注册
 * @date 2019/10/14 10:57
 */
@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);
    }

}
