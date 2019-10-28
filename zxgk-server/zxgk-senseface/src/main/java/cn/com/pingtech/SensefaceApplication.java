package cn.com.pingtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SensefaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensefaceApplication.class, args);
    }

/*--------------------------swaggger配置----------------------------*/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger RESTful APIs")
                .description("静态人脸服务api 接口文档")
                .termsOfServiceUrl("http://localhost:8080/zxgk-senseface/swagger-ui.html")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket ermissionApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("seneseFace")

                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("cn.com.pingtech.senseFace.controller"))
                .paths(PathSelectors.regex("/*/.*")).build()
                .apiInfo(apiInfo());
    }
    /*--------------------------end----------------------------*/

}
