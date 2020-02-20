package com.nanfang.backend.wj.Service;

import com.nanfang.backend.wj.bean.Category;
import com.nanfang.backend.wj.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nanfang
 * @create 2020/02/07/09:43
 */
@Service("categoryService")
public class CategoryService {

    @Resource(name = "categoryMapper")
    private CategoryMapper categoryMapper;

    //返回所有的种类
    public List<Category>finAll(){
        return categoryMapper.findAll();
    }
    //根据id得到对应的种类
    public Category findById(int id){
        return categoryMapper.findById(id);
    }



}
