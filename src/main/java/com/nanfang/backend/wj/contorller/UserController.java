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
import java.util.List;
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

    //管理员账号
    @CrossOrigin
    @PostMapping(value = "api/adminLogin")
    @ResponseBody
    public String adminLogin(@RequestParam Map<String,Object>requestMap) {
        return userService.adminLogin(requestMap);
    }

    //注册账号
    @PostMapping(value="api/insertUser")
    @ResponseBody
    public boolean insertUser(@RequestParam Map<String,Object>requestMap){
        return userService.insertUser(requestMap);
    }

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
    //查找管理员账户是否存在
    @PostMapping(value = "api/selectAdmin")
    @ResponseBody
    public Boolean selectAdmin(@RequestParam Map<String, Object> requestMap) {
        return userService.selectAdmin(requestMap);
    }

    //查询所以的账户信息
    @PostMapping(value = "api/selectAllUser")
    @ResponseBody
    public List<User> selectAllUser(@RequestParam Map<String,Object>requestMap){
        System.out.println(requestMap);
        return userService.selectAllUser(requestMap);
    }

    //根据种类查询图书
    @PostMapping("api/selectUserByUid")
    @ResponseBody
    public List<User> listByCategory(@RequestParam Map<String,Object>requestMap)  {
        return userService.selectUserByUid(requestMap);
    }

    //根据uid删除账户
    @PostMapping("api/deleteUserByUid")
    @ResponseBody
    public boolean deleteUserByUid(@RequestParam Map<String,Object>requestMap){
        return userService.deleteUserByUid(requestMap);
    }
}

