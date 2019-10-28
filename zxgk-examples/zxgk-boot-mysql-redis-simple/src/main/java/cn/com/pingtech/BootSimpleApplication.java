package cn.com.pingtech;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gumx
 * @className: BootSimpleApplication
 * @description: nacos服务发现注册
 * @date 2019/10/14 10:57
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@EnableDiscoveryClient
@MapperScan("cn.com.pingtech.dao")
public class BootSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootSimpleApplication.class, args);
    }

}
