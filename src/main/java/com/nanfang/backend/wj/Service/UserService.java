package com.nanfang.backend.wj.Service;

import com.nanfang.backend.wj.bean.User;
import com.nanfang.backend.wj.dao.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;

/**
 * @author nanfang
 * @create 2020/02/20/15:32
 */
@Service("userService")
public class UserService {

    @Resource(name="userMapper")
    private UserMapper userMapper;

    public Boolean login(User user){
        // 对 html 标签进行转义，防止 XSS 攻击
        String uid = user.getUid();
        uid = HtmlUtils.htmlEscape(uid);
        User findUser=userMapper.findByUsernameAndPassword(uid,user.getPassword());
        System.out.println(findUser);
        if (findUser==null) {
            System.out.println("账号密码错误");
            return false;
        } else {
            System.out.println("登录成功");
            return true;
        }
    }
//  注册账号密码
//    public Boolean register(User user){
//        String uid=user.getUid();
//        String username=user.getUsername();
//        String password=user.getPassword();
//        int row=userMapper.insertIntoUser(uid,username,password);
//        return row!=0;
//    }

    //修改密码
    public Boolean changePassword(User user){
        return userMapper.changePassword(user.getPassword(),user.getUid());
    }
}
