package cn.edu.guet.dao;
import cn.edu.guet.bean.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author liwei
 * @Date 2023/1/9 17:45
 * @Version 1.0
 */

@Mapper
public interface BookDao {
    void saveBook(Book book);
    List<Book> getAllBooks();
}
