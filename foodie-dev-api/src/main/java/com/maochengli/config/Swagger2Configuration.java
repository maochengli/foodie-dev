package com.maochengli.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author maochengli
 * @desc Swagger2 配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {


    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)          //指定API类型为swagger2
                    .apiInfo(apiInfo())                          //创建API信息
                    .select()                                   //选择器及扫描包
                    .apis(RequestHandlerSelectors.basePackage("com.maochengli.controller"))
                    .paths(PathSelectors.any()).build();

    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("接口文档")            //文档标题
                .description("该项目为开发人员提供的接口文档")     //详情
                .contact(new Contact("maochengli","","maochengli1995@163.com")) //作者信息
                .version("1.0")                 //版本
                .termsOfServiceUrl("https://me.csdn.net/weixin_39153210")
                .build();

    }


}
