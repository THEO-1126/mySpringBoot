package cn.edu.guet.controller;


import cn.edu.guet.bean.Book;
import cn.edu.guet.bean.Result;
import cn.edu.guet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liwei
 * @Date 2023/1/13 10:07
 * @Version 1.0
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @RequestMapping("/saveBook.html")
    public Result saveBook(Book book){//表单传参
        System.out.println("后台接收的book对象："+book);
        bookService.saveBook(book);
        return new Result(1000,"图书保存成功",book);
    }
}