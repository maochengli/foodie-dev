package com.maochengli.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户对象BO",description = "用户注册数据封装BO")
public class UserBO {

    @ApiModelProperty(value = "用户名",name = "username" ,notes = "用户名",dataType = "String",example = "zhangsan",required = true)
    private String username;

    @ApiModelProperty(value = "密码",name = "password" ,notes = "密码",dataType = "String",example = "p@ssw0rd",required = true)
    private String password;


    @ApiModelProperty(value = "确认密码",name = "confirmPassword" ,notes = "确认密码",dataType = "String",example = "p@ssw0rd",required = false)
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
