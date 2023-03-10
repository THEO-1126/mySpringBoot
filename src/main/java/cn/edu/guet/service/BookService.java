package cn.edu.guet.service;


import cn.edu.guet.bean.Book;

import java.util.List;

/**
 * @Author liwei
 * @Date 2023/1/9 17:14
 * @Version 1.0
 */
public interface BookService {
    void saveBook(Book book);
    Object getBookById(Integer id);
    public List<Book> getAllBooks();
}