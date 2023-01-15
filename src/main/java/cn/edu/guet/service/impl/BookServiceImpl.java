package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Book;
import cn.edu.guet.dao.BookDao;
import cn.edu.guet.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author liwei
 * @Date 2023/1/9 17:14
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    /*
    属性注入
    构造注入
    setter注入
     */
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    @Transactional()
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }
}