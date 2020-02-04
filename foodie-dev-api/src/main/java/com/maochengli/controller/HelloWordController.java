package com.maochengli.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore      //Swagger2 忽略该Controller
public class HelloWordController {

    @RequestMapping("hello")
    public String hello(){
        return "hello word";
    }
}
