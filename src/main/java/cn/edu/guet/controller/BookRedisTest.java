package cn.edu.guet.controller;

import cn.edu.guet.bean.Book;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author 李冰冰
 * @Date 2023/01/20
 * @Version 17.0.5
 */

public class BookRedisTest {
    @Resource
    private RedisTemplate redisTemplate;

    // 数据存入redis
    @PostMapping("/redis/set/{key}/{value}")
    public void set(@PathVariable("key") String key,@PathVariable("value") String value){
        redisTemplate.opsForValue().set(key,value);
    }

    // 从redis 取数据
    @GetMapping("/redis/get/{key}")
    public Object get(@PathVariable("key") String key){
        return redisTemplate.opsForValue().get(key);
    }
}
