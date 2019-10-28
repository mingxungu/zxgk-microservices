package cn.com.pingtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author gumx
 * @className: EurekaApplication
 * @description: 启动类
 * @date 2019/8/27 16:53
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelFeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelFeignConsumerApplication.class, args);
    }

}


