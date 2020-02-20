package com.nanfang.backend.wj.dao;

import com.nanfang.backend.wj.bean.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author nanfang
 * @create 2020/02/07/09:44
 */
@Mapper
@Repository(value="categoryMapper")
public interface CategoryMapper {

    //查询所有的种类
    @Select("Select * from category")
    public List<Category> findAll();


    //根据id查询对应的种类
    public Category findById(int id);
}
