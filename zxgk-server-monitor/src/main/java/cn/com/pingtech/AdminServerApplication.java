package cn.com.pingtech;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gumx
 * @className: AdminServerApplication
 * @description: 启动类
 * @date 2019/8/28 9:04
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminServerApplication {
    public static void main(String[] args) {

        SpringApplication.run(AdminServerApplication.class, args );
    }
}
