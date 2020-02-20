package com.nanfang.backend.wj.contorller;

/**
 * @author nanfang
 * @create 2020/01/27/16:00
 */

import com.nanfang.backend.result.Result;
import com.nanfang.backend.wj.bean.User;
import com.nanfang.backend.wj.dao.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


import javax.annotation.Resource;

@Controller
public class LoginController {
    //Mybatis操作数据库
    @Resource(name="userMapper")
    private UserMapper userMapper;

    //注解@CrossOrigin解决跨域问题
    //@CrossOrigin
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public User login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String uid = requestUser.getUid();
        uid = HtmlUtils.htmlEscape(uid);
        User user=userMapper.findByUsernameAndPassword(uid,requestUser.getPassword());
        System.out.println(user);
        if (user==null) {
            System.out.println("账号密码错误");
            return user;
        } else {
            System.out.println("登录成功");
            return user;
        }
    }
}


