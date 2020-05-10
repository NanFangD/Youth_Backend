package com.nanfang.backend.wj.dao;

import com.nanfang.backend.wj.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nanfang
 * @create 2020/02/05/14:45
 */

@Mapper
@Repository(value = "userMapper")
public interface UserMapper {
    //登录功能根据账号密码查询
    @Select("Select * from user where uid=#{param1} and password=#{param2}")
    User findByUsernameAndPassword(String uid, String password);
    //管理员登录功能根据账号密码查询
    @Select("Select * from admin where uid=#{param1} and password=#{param2}")
    User findByAdminnameAndPassword(String uid, String password);

    //插入一个user
    @Insert("Insert into user(uid,password) values('${param1}', '${param2}')")
    int insertUser(String uid,String password);

    //修改密码
    @Update("update user set password=#{param1} where uid=#{param2} and password=#{param3}")
    Boolean changePassword(String newPass, String uid, String password);

    //查询单个uid
    @Select("Select * from user where uid=#{param1}")
    User findByUserName(String id);
    //查询管理员单个uid
    @Select("Select * from admin where uid=#{param1}")
    User findByAdminName(String id);
    //查询所有user
    @Select("Select * from user")
    List<User> findAllUser();

    //根据uid查询所有账户
    @Select("Select * from user where uid like '%${_parameter}%' ")
    List<User> findUserByUid(String uid);

    //根据uid删除账户
    @Delete("Delete from user where uid = #{param1} ")
    boolean deleteUserByUid(String uid);




}
