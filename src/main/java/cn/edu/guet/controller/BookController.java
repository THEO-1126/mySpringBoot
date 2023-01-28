package cn.edu.guet.controller;


import cn.edu.guet.bean.Book;
import cn.edu.guet.bean.Result;
import cn.edu.guet.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 李冰冰
 * @Date 2023/01/28
 * @Version 17.0.5
 */

@RestController
public class BookController {

    public static final String BOOK_KEY="book:";
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BookService bookService;

    @RequestMapping("/getAllBook.do")
    public Result getAllBook(){//表单传参
        System.out.println("从数据库存数据进redis");
        List<Book> books=bookService.getAllBooks();
        System.out.println(books);
        return new Result(1000,"图书查询成功",books);
    }


    @RequestMapping("/saveBook.do")
    public Result saveBook(Book book){//表单传参
        System.out.println("后台接收的book对象："+book);
        // 存入数据库中
        bookService.saveBook(book);
        // 存入redis
        String key= BOOK_KEY+book.getId();
        redisTemplate.opsForValue().set(key,book);
        return new Result(1000,"图书保存成功",book);
    }

}