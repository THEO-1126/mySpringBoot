package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Book;
import cn.edu.guet.dao.BookDao;
import cn.edu.guet.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 李冰冰
 * @Date 2023/01/28
 * @Version 17.0.5
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private RedisTemplate redisTemplate;
    /*
    属性注入
    构造注入
    setter注入
     */
    @Autowired
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

    @Override
    public Object getBookById(Integer id) {
        return null;
    }
    public List<Book> getAllBooks(){
        // 从缓存里面查询
        // 写法一
        List<Book> books =(List<Book>) redisTemplate.boundValueOps("books").get();
        // 写法二
        // List<Student> stus1 = (List<Student>)redisTemplate.opsForValue().get("stus");
        // Object stus1 = redisTemplate.opsForValue().get("stus");
        if(books==null){
            books=bookDao.getAllBooks();
            System.out.println("从数据库中查找....");
            // 没有把数据同时存储到缓存里面
            // 写法一
            redisTemplate.boundValueOps("books").set(books);
            // 写法二
            // redisTemplate.opsForValue().set("stus",stus);
        }else {
            System.out.println("从redis中查找.....");
        }
        return books;
    }
}