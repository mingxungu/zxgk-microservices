package cn.com.pingtech;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@EnableSwagger2
@MapperScan("cn.com.pingtech.mock.bigdata.*")
public class ZxgkMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZxgkMockApplication.class, args);
    }


}
