package cn.edu.guet.controller;

import cn.edu.guet.bean.Book;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @Author 李冰冰
 * @Date 2023/01/19
 * @Version 17.0.5
 */

@RestController
public class BookHandler {

    @Resource
    private RedisTemplate redisTemplate;

    // 数据存入redis
    @PostMapping("/set/book")
    public void set(@RequestBody Book book){
        redisTemplate.opsForValue().set("book",book);
    }

    // 从redis 取数据
    @GetMapping("/get/{key}")
    public Book get(@PathVariable("key") String key){
        return (Book) redisTemplate.opsForValue().get(key);
    }

    // 从redis删除数据 返回布尔值，false表示删除成功
    @DeleteMapping("/delete/{key}")
    public boolean delete(@PathVariable("key") String key){
        redisTemplate.delete(key);
        return redisTemplate.hasKey(key);
    }

    // redis 五种数据结构
    @GetMapping("/string")
    public String stringTest(){
        redisTemplate.opsForValue().set("str","Hello World");
        String str = (String) redisTemplate.opsForValue().get("str");
        return str;
    }

    @GetMapping("/list")
    public List<String> listTest(){
        ListOperations<String,String> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("list","Hello");
        listOperations.leftPush("list","Hello");
        listOperations.leftPush("list","World");
        listOperations.leftPush("list","World");
        listOperations.leftPush("list","Java");
        listOperations.leftPush("list","Java");
        List<String> list = listOperations.range("list",0,5);
        return list;
    }

    @GetMapping("/set")
    public Set<String> setTest(){
        SetOperations<String,String> setOperations = redisTemplate.opsForSet();
        setOperations.add("set","Hello");
        setOperations.add("set","Hello");
        setOperations.add("set","World");
        setOperations.add("set","World");
        setOperations.add("set","Java");
        setOperations.add("set","Java");
        Set<String> set = setOperations.members("set");
        return set;
    }

    @GetMapping("/zset")
    public Set<String> zsetTest(){
        ZSetOperations<String,String> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("zset","Hello",3);
        zSetOperations.add("zset","World",1);
        zSetOperations.add("zset","Java",2);
        Set<String> set = zSetOperations.range("zset",0,2);
        return set;
    }

    @GetMapping("/hash")
    public void hashTest(){
        HashOperations<String,String,String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("key","hashkey","hello");
        System.out.println(hashOperations.get("key","hashkey"));
    }

}
