package cn.com.pingtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author gumx
 * @className: EurekaApplication
 * @description: 启动类
 * @date 2019/8/27 16:53
 */
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class RibbonHystrixConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonHystrixConsumerApplication.class, args);
    }


}


