package com.nanfang.backend.wj.contorller;

/**
 * @author nanfang
 * @create 2020/01/27/16:00
 */

import com.nanfang.backend.wj.Service.UserService;
import com.nanfang.backend.wj.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

@Controller
public class UserController {
    //Mybatis操作数据库
    @Resource(name="userService")
    private UserService userService;

    //注解@CrossOrigin解决跨域问题
    //@CrossOrigin
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Boolean login(@RequestBody User requestUser) {
       return userService.login(requestUser);
    }

//    @PostMapping(value="api/register")
//    @ResponseBody
//    public Boolean register(@RequestBody User requestUser){
//        return userService.register(requestUser);
//    }

    //修改密码
    @PostMapping(value="apo/changePassword")
    @ResponseBody
    public Boolean ChangePassword(@RequestBody User requestUser){
        return userService.changePassword(requestUser);
    }

}


