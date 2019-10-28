package cn.com.pingtech;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gumx
 * @className: ConfigClientApplication
 * @description: 启动类
 * @date 2019/9/3 13:47
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${profile}")
    private String profile;

    @GetMapping("/pro")
    public String home() {
        return profile;
    }

}
