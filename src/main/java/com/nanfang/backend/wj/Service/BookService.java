package com.nanfang.backend.wj.Service;

import com.nanfang.backend.wj.bean.Book;
import com.nanfang.backend.wj.bean.Category;
import com.nanfang.backend.wj.dao.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nanfang
 * @create 2020/02/07/10:38
 */

@Service(value = "bookService")
public class BookService {
    @Resource(name = "bookMapper")
    private BookMapper bookMapper;
    @Resource(name = "categoryService")
    private CategoryService categoryService;

    /*******查询******/
    //返回所有的图书
    public List<Book> findAll() {
        return bookMapper.findAllBooks();
    }

    //根据用户账号返回所有的书
    public List<Book> findAllByUid(String uid) {
        return bookMapper.findAllBooksByUid(uid);
    }

    //根据书的种类返回所有的书
    public List<Book> findAllByCategory(String cid) {
        return bookMapper.findAllByCategory(cid);
    }
    //根据书的种类和用户账户返回所有的书
    public List<Book> findAllByCategoryAndUid(String cid,String uid){
        return bookMapper.findAllByCategoryAndUid(cid,uid);
    }

    //根据书名找到所有的数据
    public List<Book> finAllByTitle(String title) {
        return bookMapper.findAllByTitle(title);
    }

    //根据id删除图书
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    //添加一本书
    public int insertBook(Book book) {
        return bookMapper.insertBook(book.getCover(), book.getTitle(), book.getAuthor(), book.getDate(), book.getPrice(), book.getNewOld(), book.getContact()
                , book.getPhone(), book.getQq(), book.getWeChat(), book.getImg_1(), book.getImg_2(), book.getImg_3(), book.getImg_4(), book.getImg_5(), book.getAbs(), book.getCid(), book.getUid());
    }

    //根据用户账号和书的id删除书籍
    public int deleteBookByIdAndUid(Book book) {
        return bookMapper.deleteBookByIdAndUid(book.getId(), book.getUid());
    }
}
