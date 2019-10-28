package cn.com.pingtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gumx
 * @className: ApiApplication
 * @description: 启动类
 * @date 2019/9/2 9:50
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class ApiTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);
    }
}
