package com.maochengli.controller;

import cn.hutool.json.JSONUtil;
import com.maochengli.bo.UserBO;
import com.maochengli.pojo.Users;
import com.maochengli.service.UserService;
import com.maochengli.utils.CookieUtils;
import com.maochengli.utils.MD5Utils;
import com.maochengli.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "登录注册",tags = "用户登录注册接口")
@RestController
@RequestMapping("passport")
public class PassPortController {

    @Autowired
    private UserService userService;

    final static Logger logger = LoggerFactory.getLogger(PassPortController.class);


    @GetMapping("usernameIsExist")
    @ApiOperation(value = "判断用户名是否存在",notes = "判断用户名是否存在的接口，如果已经存在返回状态为500", httpMethod ="GET")
    public Result usernameIsExist(String username){
        //判断用户名是否为空
        if (StringUtils.isBlank(username)){
            return Result.errorMsg("用户名为空");
        }
        //判断用户名是否存在
        boolean exits = userService.queryUsernameExits(username);
        if(exits){
            return Result.errorMsg("用户名重复");
        }
        //不重复
        return Result.ok();
    }


    /**
     * 注册用户
     * @param userBO
     * @return
     */
    @PostMapping("regist")
    @ApiOperation(value = "用户注册",notes = "用户注册接口", httpMethod ="POST")
    public Result regist(@RequestBody UserBO userBO){
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        if(StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)){
            return Result.errorMsg("用户名或密码不能为空");
        }
        boolean isExits = userService.queryUsernameExits(username);
        if (isExits){
            return Result.errorMsg("用户名已存在");
        }

        if(!password.equals(confirmPassword)){
            return Result.errorMsg("两次密码不一致");
        }

        if(password.length() < 6){
             return Result.errorMsg("密码不能小于6位");
        }

        userService.createUser(userBO);
        return Result.ok();
    }

    @PostMapping("login")
    @ApiOperation(value = "用户登录接口", notes = "登录接口", httpMethod = "POST")
    public Result login(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        logger.info(username);
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return Result.errorMsg("用户名或密码不能为空");
        }
        Users user = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        if(user == null){
            return Result.errorMsg("用户名或密码不正确");
        }
        user = setNull(user);

        CookieUtils.setCookie(request,response,"user", JSONUtil.toJsonStr(user),true);

        return Result.ok();
    }



    @PostMapping("logout")
    @ApiOperation(value = "用户退出接口", notes = "用户退出", httpMethod = "POST")
    public Result logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CookieUtils.deleteCookie(request,response,"user");
        return Result.ok();
    }






    private Users setNull(Users user){
        user.setEmail(null);
        user.setRealname(null);
        user.setPassword(null);
        user.setBirthday(null);
        user.setCreatedTime(null);
        return user;
    }

}
