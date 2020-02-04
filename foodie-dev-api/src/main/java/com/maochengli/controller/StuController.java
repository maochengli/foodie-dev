package com.maochengli.controller;

import com.maochengli.pojo.Stu;
import com.maochengli.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class StuController {

    @Autowired
    private StuService stuService;


    @RequestMapping("/getStu")
    public Stu getStuInfo(int id){
        return stuService.getStu(id);
    }



}
