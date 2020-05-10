package com.nanfang.backend.wj.Service;

import com.nanfang.backend.result.Result;
import com.nanfang.backend.wj.bean.User;
import com.nanfang.backend.wj.dao.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author nanfang
 * @create 2020/02/20/15:32
 */
@Service("userService")
public class UserService {

    //根据账号和密码查找用户
    @Resource(name = "userMapper")
    private UserMapper userMapper;
    public String login(User user) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String uid = user.getUid();
        uid = HtmlUtils.htmlEscape(uid);
        User findUser = userMapper.findByUsernameAndPassword(uid, user.getPassword());
        if (findUser == null) {
            return "";
        } else {
            return findUser.getUid();
        }
    }
    //根据账号和密码查找管理员
    public String adminLogin(@RequestParam Map<String,Object>requestMap) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String uid = requestMap.get("uid").toString();
        uid = HtmlUtils.htmlEscape(uid);
        User findUser = userMapper.findByAdminnameAndPassword(uid, requestMap.get("password").toString());
        if (findUser == null) {
            return "";
        } else {
            return findUser.getUid();
        }
    }

    //  注册账号密码
    public Boolean insertUser(Map<String,Object>requestMap){
        System.out.println(requestMap);
        try{
            int row=userMapper.insertUser(requestMap.get("uid").toString(),requestMap.get("password").toString());
            return row!=0;
        }catch(Exception e){
            return false;
        }

    }

    //修改密码
    public Result changePassword(Map<String, Object> requestMap) {
        String uid = requestMap.get("uid").toString();
        String oldPass = requestMap.get("oldPass").toString();
        String newPass = requestMap.get("newPass").toString();
        if (userMapper.changePassword(newPass, uid, oldPass)) {
            return new Result(200);
        } else {
            return new Result(400);
        }
    }

    //查找账户是否存在
    public boolean selectUser(Map<String, Object> requestMap) {
        String id = requestMap.get("uid").toString();
        return userMapper.findByUserName(id) != null;
    }
    //查找管理员账户是否存在
    public boolean selectAdmin(Map<String, Object> requestMap) {
        String id = requestMap.get("uid").toString();
        return userMapper.findByAdminName(id) != null;
    }


    //查找所有的账号
    public List<User> selectAllUser(Map<String,Object>requestMap){
        String id=requestMap.get("uid").toString();
        //判断是不是nanfang管理员查找的，防止恶意人士
        if(!id.equals("nanfang")){
            return null;
        }else{
            //返回所有账户信息
            return userMapper.findAllUser();
        }
    }

    //根据部分uid模糊查询所以账户
    public List<User> selectUserByUid(Map<String,Object>requestMap){
        String uid=requestMap.get("uid").toString();
        //判断是不是nanfang管理员查找的，防止恶意人士
        if(uid.equals("")){
            return null;
        }else{
            //返回所有账户信息
            return userMapper.findUserByUid(uid);
        }
    }
    //根据uid删除该账户
    public boolean deleteUserByUid(Map<String,Object>requestMap){
        String uid=requestMap.get("uid").toString();
        if(uid.equals("")){
            return false;
        }else{
            //返回删除后信息
            return userMapper.deleteUserByUid(uid);
        }
    }
}
