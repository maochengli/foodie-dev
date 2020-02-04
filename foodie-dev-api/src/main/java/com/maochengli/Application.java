package com.maochengli;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描Mapper
@MapperScan(basePackages = "com.maochengli.mapper")
//扫描相关组件
@ComponentScan(basePackages = {"com.maochengli","org.n3r.idworker"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
