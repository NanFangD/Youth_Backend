package com.nanfang.backend.wj.dao;

import com.nanfang.backend.wj.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
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
    User findByUsernameAndPassword(String uid,String password);

    //申请账号功能插入一个账号密码
    @Insert("Insert into user(uid,username,password) values(#{param1},#{param2},#{param3})")
    int insertIntoUser(String username,String password);
}
