package com.nanfang.backend.wj.dao;

import com.nanfang.backend.wj.bean.Book;
import com.nanfang.backend.wj.bean.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nanfang
 * @create 2020/02/06/23:21
 */
@Mapper
@Repository(value = "bookMapper")
public interface BookMapper {

    //根据书的种类找到这一类型的所有书
    @Select("select * from book\n" +
            "where book.cid=#{_parameter}")
    List<Book> findAllByCategory(String cid);

    ////根据书的种类和用户账户找到这一类型的所有书
    @Select("Select * from book where book.cid=#{param1} and book.uid=#{param2}")
    List<Book>findAllByCategoryAndUid(String cid,String uid);


    //根据书名模糊找到书
    @Select("select * from book\n" +
            "where book.title like '%${_parameter}%'")
    List<Book> findAllByTitle(String title);


    //找到所有的书
    @Select("select * from book")
    List<Book> findAllBooks();

    //根据用户账号返回所有的书
    @Select("Select * from book where uid=#{_parameter}")
    List<Book> findAllBooksByUid(String uid);

    //根据id删除书籍
    @Delete("delete  from book where id=#{id}")
    int deleteBookById(int id);

    //添加图书
    @Insert("insert into nanfang.book(cover,title,author,date,price,newOld,contact,phone,qq,weChat,img_1,img_2,img_3,img_4,img_5,abs,cid,uid)\n" +
            "values(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6},#{param7},#{param8},#{param9},#{param10},#{param11},#{param12},#{param13},#{param14}, #{param15},#{param16},#{param17},#{param18})")
    int insertBook(String cover,String title,String author,String date,String price,String newOld,String contact,String phone,
                   String qq,String weChat,String img_1,String img_2,String img_3,String img_4,String img_5,String abs,
                   String cid,String uid);

    //根据用户账号和书的id删除书籍
    @Delete("delete  from book where id=#{param1} and uid=#{param2}")
    int deleteBookByIdAndUid(int id,String uid);

}
