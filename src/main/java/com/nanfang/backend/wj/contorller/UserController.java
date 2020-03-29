package com.nanfang.backend.wj.contorller;

/**
 * @author nanfang
 * @create 2020/01/27/16:00
 */

import com.nanfang.backend.result.Result;
import com.nanfang.backend.wj.Service.UserService;
import com.nanfang.backend.wj.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.Map;

@Controller
public class UserController {
    //Mybatis操作数据库
    @Resource(name = "userService")
    private UserService userService;

    //登录账号
    //注解@CrossOrigin解决跨域问题
    //@CrossOrigin
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public String login(@RequestBody User requestUser) {
        return userService.login(requestUser);
    }

    //注册账号
//    @PostMapping(value="api/register")
//    @ResponseBody
//    public Boolean register(@RequestBody User requestUser){
//        return userService.register(requestUser);
//    }

    //修改密码
    @PostMapping(value = "api/changePassword")
    @ResponseBody
    public Result ChangePassword(@RequestParam Map<String, Object> requestMap) {
        return userService.changePassword(requestMap);
    }

    //查找账户是否存在
    @PostMapping(value = "api/selectUser")
    @ResponseBody
    public Boolean selectUser(@RequestParam Map<String, Object> requestMap) {
        return userService.selectUser(requestMap);
    }
}

