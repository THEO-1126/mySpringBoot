

# 概念

**1、Spring**

Spring是一个开源[容器](https://cloud.tencent.com/product/tke?from=10680)框架，可以接管web层，业务层，dao层，持久层的组件，并且可以配置各种bean,和维护bean与bean之间的关系。其核心就是控制反转(IOC),和面向切面(AOP),简单的说就是一个分层的轻量级开源框架。

**2、SpringMVC**

SpringMVC属于SpringFrameWork的后续产品，已经融合在Spring Web Flow里面。SpringMVC是一种web层mvc框架，用于替代servlet（处理|响应请求，获取表单参数，表单校验等。SpringMVC是一个MVC的开源框架，SpringMVC=struts2+spring，springMVC就相当于是Struts2加上Spring的整合。

**3、SpringBoot**

Springboot是一个微服务框架，延续了spring框架的核心思想IOC和AOP，简化了应用的开发和部署。Spring Boot是为了简化Spring应用的创建、运行、调试、部署等而出现的，使用它可以做到专注于Spring应用的开发，而无需过多关注XML的配置。提供了一堆依赖打包，并已经按照使用习惯解决了依赖问题--->习惯大于约定。

## 原理和结构

**1、Spring的原理和组成**

Spring为简化我们的开发工作，封装了一系列的开箱即用的组件功能模块，包括：Spring JDBC 、Spring MVC 、Spring Security、 Spring AOP 、Spring ORM 、Spring Test等。如下图：

![image-20230110172856336](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110172856336.png)



**2、SpringMVC的原理和组成**

从上图中可以看出：SpringMVC是属于SpringWeb里面的一个功能模块（SpringWebMVC）。专门用来开发SpringWeb项目的一种MVC模式的技术框架实现。其原理如下：

MVC：Model（模型）、VIew（视图）、Controller（控制器）；

我们从开始接触并学习javaWeb开发就知道MVC这一种架构，如早起的Sturts1、Sturts2等。

![image-20230110172925064](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110172925064.png)

**3、SpringBoot的原理和特性**

Spring Boot基本上是Spring框架的扩展，它消除了设置Spring应用程序所需的XML配置，为更快，更高效的开发生态系统铺平了道路。

Spring Boot中的一些特点：

1. 创建独立的spring应用。

2. 嵌入Tomcat, Jetty Undertow 而且不需要部署他们。

3. 提供的“starters” poms来简化Maven配置

4. 尽可能自动配置spring应用。

5. 提供生产指标,健壮检查和外部化配置

6. 绝对没有代码生成和XML配置要求。

组成结构：

![image-20230110173047742](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110173047742.png)

SpringBoot是包含了Spring的核心（IOC）和（AOP）；

以及封装了一些扩展，如Stater：

![image-20230110173126430](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110173126430.png)

## 三者区别和理解

1. 简单理解为：

   Spring包含了SpringMVC，而SpringBoot又包含了Spring或者说是在Spring的基础上做得一个扩展。

2. `spring mvc < spring < springboot`

3. Spring Boot 对比Spring的一些优点包括：

   提供嵌入式容器支持
   使用命令java -jar独立运行jar
   在外部容器中部署时，可以选择排除依赖关系以避免潜在的jar冲突
   部署时灵活指定配置文件的选项
   用于集成测试的随机端口生成

# 分层

## ASP.NET 三层架构

**三层体系架构**

1. 表示层(USL)：

   主要表示WEB方式，也可以表示成WINFORM方式。如果逻辑层相当强大和完善，无论表现层如何定义和更改，逻辑层都能完善地提供服务。

2. 业务逻辑层(BLL)

   主要是针对具体的问题的操作，也可以理解成对数据层的操作，对数据业务逻辑处理。如果说数据层是积木，那逻辑层就是对这些积木的搭建。

3. 数据访问层(DAL)

   主要是对原始数据(数据库或者文本文件等存放数据的形式)的操作层，而不是指原始数据，也就是说，是对数据的操作，而不是数据库，具体为业务逻辑层或表示层 

## 三层架构

**bean存放数据**

1. 存放来自于数据库的数据。

2. 存放来自客户端的数据（表单提交），存数据的中介作用

**dao数据访问层**

1. 访问数据库

2. 将访问到的数据返回业务层

**service业务逻辑层**

1. 处理业务功能
2. 调用dao数据
3. 给视图层提供结果
4. 接收视图层的数据

**ui视图层**

1. 与用户进行交互
2. 收集用户的信息
3. 展示查询结果

**优点：**

1. 整个项目的组件之间耦合度低，某一层的改变，不会影响整个系统的运行。
2. 开发人员可以只去关注系统中的某一个层次
3. 利于协作开发
4. 后期的可维护性高



# 日志

log4j依赖 pom.xml

```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.17.1</version>
</dependency>
```

在 mybatis-config.xml  中开启 log 日志：

```xml
<configuration>
    <settings>
        <setting name="logImpl" value="LOG4J2"/>
    </settings>
</configuration>
```

log4j2.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <!-- 配置日志信息输出目的地 -->
    <Appenders>
        <!-- 输出到控制台 -->
        <Console name="Console" target="SYSTEM_OUT">
            <!--配置日志信息的格式 -->
            <PatternLayout
                    pattern="%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n"/>
            "/>
        </Console>

        <!-- 输出到文件，其中有一个append属性，默认为true，即不清空该文件原来的信息，采用添加的方式，若设为false，则会先清空原来的信息，再添加 -->
        <File name="MyFile" fileName="/Users/liwei/mybatis.log" append="false">
            <PatternLayout>
                <!--配置日志信息的格式 -->
                <pattern>%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n</pattern>
            </PatternLayout>
        </File>

    </Appenders>
    <!-- 定义logger,只有定义了logger并引入了appender,appender才会有效 -->
    <Loggers>
        <!-- 将业务mapper接口所在的包填写进去,并用在控制台和文件中输出 -->
        <logger name="cn.edu.guet.mapper" level="TRACE" additivity="false">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="MyFile"/>
        </logger>

        <Root level="INFO">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="MyFile"/>
        </Root>
    </Loggers>
</Configuration>
```



# Redis

## redis安装启动

📝 [(206条消息) Windows 下安装Redis、Redis Client, 设置Redis后台运行_BottleJia的博客-CSDN博客_windows redis client](https://blog.csdn.net/qq_39930290/article/details/117741591#:~:text=1.启动 redis 启动一个cmd窗口 进入 redis -server.exe与,redis. windows.conf的 安装 目录，如下图所示： 打开 redisClient 客户端，输入参数。)

📝 [(206条消息) RedisClient的安装及基本使用_fzxfpp1314的博客-CSDN博客_redisclient的使用](https://blog.csdn.net/fzxyxf1314/article/details/119378439)

**Redis-x64安装**

右键安装 `Redis-x64-5.0.10.msi` 

将下载的 start-redis.bat，redis-startup.vbs ，redis-cli.bat，clear.bat，redis.vbs 粘贴进安装目录（群里有）

在安装目录下运行redis

```she
redis-server.exe
```

运行命令：

```shell
redis-server --service-install redis.windows.conf --loglevel verbose
```

运行成功后可通过一下命令开启停止Redis:

```shell
redis-server --service-start    // 启动服务
redis-server --service-stop    // 停止服务
```

注：

- start-redis.bat 启动后会一直占用cmd窗口，窗口关闭则redis关闭
- redis-startup.vbs 启动不占用窗口，在后台运行
- redis-cli.bat 为redis的工作台，默认启动redis-cli，或者命令行输入redis-cli也可以启动
- 以上的 bat文件都需要编辑，把EVN_HOME改成自己的redis的安装路径，例如：

![image-20230110180844575](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110180844575.png)

**Redis client 安装**

双击 redisclient-win32.x86.2.0.exe 进行安装

![image-20230110174959942](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110174959942.png)

双击运行

![image-20230110175053032](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110175053032.png)

启动redis后，打开redisclient，server--add 新建服务

```shel
Name:redis-localhost
Host:127.0.0.1
Port:6379
```



![image-20230110180035995](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110180035995.png)

添加成功后：

![image-20230110180156754](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110180156754.png)



## Jedis 操作redis数据库

```shell
# 启动redis服务：
redis-server --service-start
# 启动redis-cli工具
redis-cli
# 将key为name，value为张三 存入redis数据库
set name zhangsan
# 获取key为name的value
get name
```

<img src="C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110182331458.png" alt="image-20230110182331458" style="zoom: 67%;" />

打开redis-client软件：

可以看到刚刚存入redis数据库的值（默认存入db0数据库）

<img src="C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110182554885.png" alt="image-20230110182554885" style="zoom: 67%;" />

fluashall清空redis数据

## Mybatis 缓存 🎈

📝 [MyBatis一级缓存与二级缓存原理与作用分析_java_脚本之家 (jb51.net)](https://www.jb51.net/article/271096.htm)

📝 [redis一级缓存和二级缓存_面试官让面试者先回去 - 腾讯云开发者社区-腾讯云 (tencent.com)](https://cloud.tencent.com/developer/article/2152600)

**缓存的作用**

在 Web 系统中，最重要的操作就是查询数据库中的数据。但是有些时候查询数据的频率非常高，这是很耗费数据库资源的，往往会导致数据库查询效率极低，影响客户的操作体验。于是可以将一些变动不大且访问频率高的数据，放置在一个缓存容器中，用户下一次查询时就从缓存容器中获取结果。

**Mybatis 缓存结构**

MyBatis 系统中默认定义了两级缓存：一级缓存和二级缓存：

MyBatis 一级缓存是一个 SqlSession 级别，Sqlsession 只能访问自己的一级缓存的数据。

二级缓存是跨 sqlSession，是 mapper 级别的缓存，对于 mapper 级别的缓存不同的 sqlsession 是可以共享的。

MyBatis 默认开启一级缓存，同时为了增强扩展性，MyBatis 定义了缓存接口 Cache，可以通过 Cache 自定义二级缓存。

### 一级缓存

在参数和SQL完全一样的情况下，我们使用同一个SqlSession对象调用一个Mapper方法，往往只执行一次SQL，因为使用SelSession第一次查询后，MyBatis会将其放在缓存中，以后再查询的时候，如果没有声明需要刷新，并且缓存没有超时的情况下，SqlSession都会取出当前缓存的数据，而不会再次发送SQL到数据库。

1. 一级缓存是默认开启的；
2. 底层其实是基于hashmap的本地内存缓存；
3. 作用域是session（其实就相当于一个方法）；
4. 当session关闭或者刷新的时候缓存清空；
5. 不通sqlsession之间缓存互不影响；

**规则**

- 映射语句文件中的所有 select 语句的结果将会被缓存。
- 映射语句文件中的所有 insert、update 和 delete 语句会刷新缓存。
- 缓存默认会使用最近最少使用算法（LRU, Least Recently Used）算法来清除不需要的缓存。
- 缓存不会定时进行刷新（也就是说，没有刷新间隔）。
- 缓存会保存列表或对象（无论查询方法返回哪种）的 1024 个引用。
- 缓存会被视为读/写缓存，这意味着获取到的对象并不是共享的，可以安全地被调用者修改，而不干扰其他调用者或线程所做的潜在修改。

**测试**

编写测试代码，在同样的查询条件下查询第二次：

```java
public void testSearch(){
    SqlSession sqlSession = sqlSessionFactory.openSession();//相当于JDBC的Connection
    bookMapper = sqlSession.getMapper(BookMapper.class); // 执行sql
    System.out.println("--- 第1次查询: ---");
    Book book1 = bookMapper.getBookById(4);
    System.out.println("第1次查询结果:"+book1);
    // sqlSession.clearCache();  //清除缓存，若选择清除缓存，第二次查询会走数据库
    System.out.println("\n--- 第2次查询: ---");
    Book book2 = bookMapper.getBookById(4);
    System.out.println("第2次查询结果:"+book2);
}
```

结果：（第一次查询走的是数据库，第二次就不需要再查数据库了。满足第一条规则映射语句文件中的所有 select 语句的结果将会被缓存。）

![image-20230111175148612](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230111175148612.png)

修改条件，在查询第二次之前先往表里插入一条数据：

```java
public void testSearch(){
    SqlSession sqlSession = sqlSessionFactory.openSession();//相当于JDBC的Connection
    bookMapper = sqlSession.getMapper(BookMapper.class); // 执行sql
    System.out.println("--- 第1次查询: ---");
    Book book1 = bookMapper.getBookById(4);
    System.out.println("第1次查询结果:"+book1);

    System.out.println("--- 更新 ---- ");
    Book updatebook = new Book();
    updatebook.setId(4);
    updatebook.setPrice(100f);
    updatebook.setBookName("JavaScript高级程序设计");
    updatebook.setAuthor("李松峰");
    updatebook.setPublisher("机械工业出版社");
    bookMapper.update(updatebook);

    System.out.println("\n--- 第2次查询: ---");
    Book book2 = bookMapper.getBookById(4);
    System.out.println("第2次查询结果:"+book2);
}
```

结果：（在第一次查询之后插入了一条数据，第二次同样条件查询时没有走缓存，再次查表，符合规则映射语句文件中的所有 insert、update 和 delete 语句会刷新缓存。）

![image-20230111175807394](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230111175807394.png)

**建议**

1. 单个sqlsession的生命周期不能过长；
2. 如果是对同一个语句更新尽量使用同一个sql，也就是同一个sqlsession；
3. 建议关闭一级缓存，

**一级缓存关闭**

在mybatis的全局配置文件中增加

```xml
<settiog name="localCacheScope" value="STATEMENT" />
```

### 二级缓存

二级缓存的作用域比一级缓存要更大，二级缓存是 mapper 级别的缓存，你也可以理解为他是一个 namespace 内的缓存。

**开启二级缓存**

1. MyBatis 中开启缓存需要首先在设置中开启 cacheEnabled，cacheEnabled 默认也是开启状态。

```xml
<settings>
    <setting name="cacheEnabled" value="true"/>
</settings>
```

2. 在 mapper.xml 中使用二级缓存

在 BookMapper.xml 文件的 mapper 节点下增加一行 , 这个 mapper 就开启了二级缓存。

```xml
<mapper namespace="cn.edu.guet.mapper.BookMapper">
    <cache></cache>
</mapper>
```

MyBatis 缓存要求对应的对象需要实现序列话，因此给 Book对象加上序列化

```java
public class Book implements Serializable {
    private int id;
    private String bookName;
    private String author;
    private Float price;
    private String publisher;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
```

**测试**

编写测试用例，下面这段代码在第一次查询结束后关闭了 SqlSession，接着重新生成一个 SqlSession 执行第二次查询，一级缓存就没有用了，这样的场景下就需要二级缓存。

```java
public void testSecondLevelCache() {
    SqlSession sqlSession = sqlSessionFactory.openSession();  // 获取SqlSession
    bookMapper = sqlSession.getMapper(BookMapper.class); // 执行sql
    System.out.println("--- 第1次查询: ---");
    Book book1 = bookMapper.getBookById(4);
    System.out.println("第1次查询结果:"+book1);
    // 第一次查询结束后关闭 SqlSession
    sqlSession.close();
    //同样的条件查询第二次
    sqlSession = sqlSessionFactory.openSession();
    bookMapper = sqlSession.getMapper(BookMapper.class);
    System.out.println("\n--- 第2次查询: ---");
    Book book2 = bookMapper.getBookById(4);
    System.out.println("第2次查询结果:"+book2);
}
```

结果

![image-20230111180903932](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230111180903932.png)

**单独取消二级缓存**

使用 useCache 对具体某一个查询设置不适用缓存：

```xml
<select id="getUserById" resultMap="UserMap" parameterType="int" useCache="false">
    select id,name from user where id=#{id};
</select>
```

**cache 标签**

```xml
<cache eviction="FIFO" flushInterval="60000" size="512" readOnly="false"/>
```

- 清除策略（eviction）：

  LRU – 最近最少使用：移除最长时间不被使用的对象。

  FIFO – 先进先出：按对象进入缓存的顺序来移除它们。

  SOFT – 软引用：基于垃圾回收器状态和软引用规则移除对象。

  WEAK – 弱引用：更积极地基于垃圾收集器状态和弱引用规则移除对象。

- flushInterval（刷新间隔）

  可以被设置为任意的正整数，设置的值应该是一个以毫秒为单位的合理时间量。 默认情况是不设置，也就是没有刷新间隔，缓存仅仅会在调用语句时刷新。

- size（引用数目）

  可以被设置为任意正整数，要注意欲缓存对象的大小和运行环境中可用的内存资源。默认值是 1024。

- readOnly（只读）

  可以被设置为 true 或 false，默认为 false。只读的缓存会给所有调用者返回缓存对象的相同实例, 因此这些对象不能被修改，这就提供了可观的性能提升。而可读写的缓存会（通过序列化）返回缓存对象的拷贝，速度上会慢一些，但是更安全。

### redis 作为二级缓存

 📝 [Mybatis的二级缓存、使用Redis做二级缓存 - 邓晓晖 - 博客园 (cnblogs.com)](https://www.cnblogs.com/isdxh/p/13963636.html)

 📝 [(210条消息) Java使用redis:将数据插入redis缓存的方式_eeeeasy的博客-CSDN博客](https://blog.csdn.net/eeeeasy/article/details/80873082)

**引入包**

mybatis提供了一个针对cache接口的redis实现类，在`mybatis-redis`包中

```xml
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.9</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.17.1</version>
</dependency>
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>2.9.0</version>
</dependency>

<dependency>
    <groupId>org.mybatis.caches</groupId>
    <artifactId>mybatis-redis</artifactId>
    <version>1.0.0-beta2</version>
</dependency>
```

**修改mapper.xml**

```xml
//**********XML方式***********：
<?xml version="1.0" encoding="UTF-8"?> <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 
<mapper namespace="com.lagou.mapper.IUserMapper"> 
    //表示针对于当前的namespace开启二级缓存
    <cache type="org.mybatis.caches.redis.RedisCache" /> 
    
    <select id="findAll" resultType="com.lagou.pojo.User" useCache="true"> 
    	select * from user 
    </select>
</mapper>

//*******注解方式**********
@CacheNamespace(implementation = RedisCache .class)
public interface UserMapper {
    //根据id查询用户 注解使用
    @Select("select * from user where id=#{id}")
    public User findById(Integer id);
}
```

**修改redis 配置文件 **redis.properties

```properties
redis.host=localhost
redis.port=6379
redis.connectionTimeout=5000
redis.password=
redis.database=0
```

**序列化类 SerializeUtil.java**

```java
public class SerializeUtil {
    /*
     * 序列化
     * */
    public static byte[] serizlize(Object object){
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(baos != null){
                    baos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
    /*
     * 反序列化
     * */
    public static Object deserialize(byte[] bytes){
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try{
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
 
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
```



## 常用命令

京东商品信息，缓存在redis，消息队列异步更新

前后端分离，没有session，token

早期Java操作redis，用的是Jedis

现在Java操作redis，用的是lettuce，例如SpringBoot用的就是lettuce

### String

字符串类型是Redis最基础的数据结构，其它的几种数据结构都是在字符串类型基础上构建的，字符串的值可以是：字符串、数字、二进制，但其值最大不能超过512M。

**使用场景：** 缓存、计数器、对象存储缓存（共享session）、限速

**常用命令：**

- **set key value：** 设置一个key的value值
- **setnx key value：** 仅当key不存在时进行set
- **setex key seconds value：** set 键值对并设置过期时间
- **mset key value [key value …]：** 设置多个key value
- **msetnx key1 value1 [key2 value2…]：** 批量设置键值对，仅当参数中所有的key都不存在时执行，原子性操作，一起成功，一起失败
- **get key：** 返回key的value
- **mget key [key …] ：** 批量获取多个key保存的值
- **exists key [key …]：** 查询一个key是否存在
- **decr/incr key：** 将指定key的value数值进行+1/-1(仅对于数字)
- **incrby/decrby key n：** 按指定的步长对数值进行加减
- **incrbyfloat key n：** 为数值加上浮点型数值
- **append key value：** 向指定的key的value后追加字符串
- **strlen key：** 返回key的string类型value的长度。
- **getset key value：** 设置一个key的value，并获取设置前的值，如果不存在则返回null
- **setrange key offset value：** 设置指定位置的字符
- **getrange key start end：** 获取存储在key上的值的一个子字符串

### List(列表)

Redis列表是简单的字符串列表，按照插入顺序排序。你可以添加一个元素到列表的头部（左边）或者尾部（右边），也可以获取指定范围指定下标的元素等。一个列表最多可以包含 232 - 1 个元素 (4294967295, 每个列表超过40亿个元素)。

**两个特点：**

1. 列表中的元素是有序的，可以通过索引下标获取某个元素霍某个某个范围内的元素列表
2. 列表中的元素可以是重复的

**使用场景：** 消息队列、栈、文章列表等。

**常用指令：**

- **添加操作**
- **lpush/rpush key value1[value2…]：** 从左边/右边向列表中PUSH值(一个或者多个)
- **lpushx/rpushx key value：** 向已存在的列名中push值（一个或者多个），list不存在 lpushx失败
- **linsert key before|after pivot value：** 在指定列表元素的前/后 插入value
- **查找操作**
- **lindex key index：** 通过索引获取列表元素
- **lrange key start end：** 获取list 起止元素 （索引从左往右 递增）
- **llen key：** 查看列表长度
- **删除操作**
- **lpop/rpop key：** 从最左边/最右边移除值 并返回
- **lrem key count value：** count >0：从头部开始搜索 然后删除指定的value 至多删除count个 count < 0：从尾部开始搜索… count = 0：删除列表中所有的指定value。
- **ltrim key start end：** 通过下标截取指定范围内的列表
  rpoplpush source destination： 将列表的尾部(右)最后一个值弹出，并返回，然后加到另一个列表的头部
- **修改操作**
- **lset key index value：** 通过索引为元素设值
- **阻塞操作**
- **blpop/brpop key1[key2] timout：** 移出并获取列表的第一个/最后一个元素，如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
- **brpoplpush source destination timeout：** 和rpoplpush功能相同，如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。

### Set(集合）

Redis的Set是string类型的无序集合，我们不能通过索引获取元素。集合成员是唯一的，这就意味着集合中不能出现重复的数据。Redis中集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是O(1)。集合中最大的成员数为 2的32次方 - 1 (4294967295, 每个集合可存储40多亿个成员)。

**应用场景：** 标签（tag）

**常用命令：**

- **集合内操作**
- **sadd key member1[member2…]：** 向集合中无序增加一个/多个成员
- **srem key member1[member2…]：** 移除集合中一个/多个成员
- **scard key：** 获取集合的成员数
- **smembers key：** 返回集合中所有的成员
- **sismember key member：** 查询member元素是否是集合的成员，若存在返回1，不存在返回0
- **srandmember key [count]：** 随机返回集合中count个成员，count缺省值为1
- **spop key [count]：** 随机移除并返回集合中count个成员，count缺省值为1
  集合间操作
- **sinter key1 [key2…]：** 返回所有集合的交集
- **sinterstore destination key1[key2…]：** 在SINTER的基础上，存储结果到集合中。覆盖
- **sunion key1 [key2…]：** 返回所有集合的并集
- **sunionstore destination key1 [key2…]：** 在SUNION的基础上，存储结果到及和张。覆盖
- **sdiff key1[key2…]：** 返回所有集合的差集 key1- key2 - …
- **sdiffstore destination key1[key2…]：** 在SDIFF的基础上，将结果保存到集合中。覆盖
- **smove source destination member：** 将source集合的成员member移动到destination集合
- **sscan key [MATCH pattern] [COUNT count]：** 在大量数据环境下，使用此命令遍历集合中元素，每次遍历部分

### Hash（哈希）

几乎所有的编程语言都提供了哈希（hash）结构，Redis中 hash 是一个string类型的field和value的映射表value={{field1,value1},{field2,value2}…}，可以将一个Hash表作为一个对象进行存储，表中存放对象的信息。

**应用场景：** 用户信息缓存

**常用命令：**

- **hset key field value：** 将哈希表 key 中的字段 field 的值设为 value。重复设置同一个field会覆盖,返回0
- **hmset key field1 value1 [field2 value2…]：** 同时将多个 field-value (域-值)对设置到哈希表 key 中。
- **hsetnx key field value：** 只有在字段 field不存在时，设置哈希表字段的值。
- **hget key field value：** 获取存储在哈希表中指定字段的值
- **hmget key field1 [field2…]：** 获取所有给定字段的值
- **hexists key field：** 查看哈希表 key 中，指定的字段是否存在。
- **hdel key field1 [field2…]：** 删除哈希表key中一个/多个field字段
- **hlen key：** 获取哈希表中字段的数量
- **hkeys key：** 获取所有字段field
- **hvals key：** 获取哈希表中所有值value
- **hgetall key：** 获取在哈希表key 的所有字段和值
- **hincrby key field n：** 为哈希表 key 中的指定字段的整数值加上增量n，并返回增量后结果 一样只适用于整数型字段
- **hincrbyfloat key field n：** 为哈希表 key 中的指定字段的浮点数值加上增量 n。
- **hscan key cursor [MATCH pattern] [COUNT count]：** 迭代哈希表中的键值对。

### Zset（有序集合）

在有序集合中保留了不能有重复成员的特性，但其中的成员是可以排序的，每一个元素都会关联一个double类型的分数（score）作为排序依据，score相同时按字典顺序排序。redis正是通过分数来为集合中的成员进行从小到大的排序。

**应用场景：** 排行榜系统，成绩单，工资表

**常用命令：**

**集合内**

- **zadd key score member1 [score2 member2]：** 向有序集合添加一个或多个成员，或者更新已存在成员的分数
- **zcard key：** 获取有序集合的成员数
- **zscore key member：** 返回有序集中，成员的分数值
- **zcount key min max：** 计算在有序集合中指定区间score的成员数
- **zlexcount key min max：** 在有序集合中计算指定字典区间内成员数量
- **zincrby key n member：** 有序集合中对指定成员的分数加上增量 n
- **zscan key cursor [MATCH pattern] [COUNT count]：** 迭代有序集合中的元素（包括元素成员和元素分值）
  范围查询
- **zrank key member：** 返回有序集合中指定成员的索引
- **zrevrank key member：** 返回有序集合中指定成员的索引，从大到小排序
- **zrange key start end：** 通过索引区间返回有序集合成指定区间内的成员
- **zrevrange key start end：** 通过索引区间返回有序集合成指定区间内的成员，分数从高到底
- **zrangebylex key min max：** 通过字典区间返回有序集合的成员
- **zrevrangebylex key max min：** 按字典顺序倒序返回有序集合的成员
- **zrangebyscore key min max：** 返回有序集中指定分数区间内的成员 -inf 和 +inf分别表示最小最大值，只支持开区间
- **zrevrangebyscore key max min：** 返回有序集中指定分数区间内的成员，分数从高到低排序
  删除操作
- **zrem key member1 [member2…]：** 移除有序集合中一个/多个成员
- **zremrangebylex key min max：** 移除有序集合中给定的字典区间的所有成员
- **zremrangebyrank key start stop：** 移除有序集合中给定的排名区间的所有成员
- **zremrangebyscore key min max：** 移除有序集合中给定的分数区间的所有成员
  集合间操作
- **zinterstore destination numkeyskey1 [key2 …]：** 计算给定的一个或多个有序集的交集并将结果集存储在新的有序集合 key 中
- **numkeys：**表示参与运算的集合数，将score相加作为结果的score
- **zunionstore destination numkeys key1 [key2…]：** 计算给定的一个或多个有序集的交集并将结果集存储在新的有序集合 key 中



# Spring-IoC 

## IoC 介绍

📝 [谈谈对Spring IOC的理解 - 孤傲苍狼 - 博客园 (cnblogs.com)](https://www.cnblogs.com/xdp-gacl/p/4249939.html)

IoC 是 Inversion of Control 的简写，译为“控制反转”，它不是一门技术，而是一种设计思想，是一个重要的面向对象编程法则，能够指导我们如何设计出松耦合、更优良的程序。

Spring 通过 IoC 容器来管理所有 Java 对象的实例化和初始化，控制对象与对象之间的依赖关系。我们将由 IoC 容器管理的 Java 对象称为 Spring Bean，它与使用关键字 new 创建的 Java 对象没有任何区别。

IoC 容器是 Spring 框架中最重要的核心组件之一，它贯穿了 Spring 从诞生到成长的整个过程。

在 Spring 应用中，Java 对象创建的控制权是掌握在 IoC 容器手里的，其**大致步骤**如下：

1. 开发人员通过 XML 配置文件、注解、Java 配置类等方式，对 Java 对象进行定义，例如在 XML 配置文件中使用 <bean> 标签、在 Java 类上使用 @Component 注解等。
2. Spring 启动时，IoC 容器会自动根据对象定义，将这些对象创建并管理起来。这些被 IoC 容器创建并管理的对象被称为 Spring Bean。
3. 当我们想要使用某个 Bean 时，可以直接从 IoC 容器中获取（例如通过 ApplicationContext 的 getBean() 方法），而不需要手动通过代码（例如 new Obejct() 的方式）创建。

**好处**

IoC 不是一种技术，只是一种思想，一个重要的面向对象编程的法则，它能指导我们如何设计出松耦合、更优良的程序。传统应用程序都是由我们在类内部主动创建依赖对象，从而导致类与类之间高耦合，难于测试；有了IoC容器后，把创建和查找依赖对象的控制权交给了容器，由容器进行注入组合对象，所以对象与对象之间是 松散耦合，这样也方便测试，利于功能复用，更重要的是使得程序的整个体系结构变得非常灵活。

　　其实IoC对编程带来的最大改变不是从代码上，而是从思想上，发生了“主从换位”的变化。应用程序原本是老大，要获取什么资源都是主动出击，但是在IoC/DI思想中，应用程序就变成被动的了，被动的等待IoC容器来创建并注入它所需要的资源了。

　　IoC很好的体现了面向对象设计法则之一—— 好莱坞法则：“别找我们，我们找你”；即由IoC容器帮对象找相应的依赖对象并注入，而不是由对象主动去找。

DI—Dependency Injection，即“依赖注入”：组件之间依赖关系由容器在运行期决定，形象的说，即由容器动态的将某个依赖关系注入到组件之中。**依赖注入的目的并非为软件系统带来更多功能，而是为了提升组件重用的频率，并为系统搭建一个灵活、可扩展的平台。通过依赖注入机制，我们只需要通过简单的配置，而无需任何代码就可指定目标需要的资源，完成自身的业务逻辑，而不需要关心具体的资源来自何处，由谁实现。**

- 谁依赖于谁：当然是应用程序依赖于IoC容器；

- 为什么需要依赖：应用程序需要IoC容器来提供对象需要的外部资源；

- 谁注入谁：很明显是IoC容器注入应用程序某个对象，应用程序依赖的对象；

- 注入了什么：就是注入某个对象所需要的外部资源（包括对象、资源、常量数据）。

**依赖**

```xml
       <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>5.3.24</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>5.3.24</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.24</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.3.24</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.26</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.9</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.7</version>
        </dependency>
```

## IoC工作原理

IoC 底层通过工厂模式、Java 的反射机制、XML 解析等技术，将代码的耦合度降低到最低限度，其主要步骤如下。

1. 在配置文件（例如 Bean.xml）中，对各个对象以及它们之间的依赖关系进行配置；
2. 我们可以把 IoC 容器当做一个工厂，这个工厂的产品就是 Spring Bean；
3. 容器启动时会加载并解析这些配置文件，得到对象的基本信息以及它们之间的依赖关系；
4. IoC 利用 Java 的反射机制，根据类名生成相应的对象（即 Spring Bean），并根据依赖关系将这个对象注入到依赖它的对象中。

**IOC操作底层原理使用的技术如下**：

- xml配置文件
- dom4j（解决xml问题）
- 工厂设计模式（用于创建对象）
- 反射（用于创建对象）

**IoC容器**

IoC 思想基于 IoC 容器实现的，IoC 容器底层其实就是一个 Bean 工厂。Spring 框架为我们提供了两种不同类型 IoC 容器，它们分别是 BeanFactory 和 ApplicationContext。

**BeanFactory **

BeanFactory 是 IoC 容器的基本实现，也是 Spring 提供的最简单的 IoC 容器，它提供了 IoC 容器最基本的功能，由 org.springframework.beans.factory.BeanFactory 接口定义。

## 代码示例

IOC创建实例对象有两种方法，一种是配置文件创建，另一种是注解的方法创建，在实际开发中我们主要使用，配置文件来创建对象。

### 1. 配置文件创建

**创建配置文件**

我们在根目录下创**applicationContext.xml**（PS：名称可以不唯一）的配置文件，并且主体部分如下，

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

</beans>
```

**创建实体类**

例如 User

**配置xml文件**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--
        id:用于SpringIOC调用，可以为任意
        class：类的全路径
        scope:作用范围，scope不是必填属性，不写的默认值单例。为创建对象的方式，有两种结果：
             1.singleton默认值，单实例。(常用)
             2.prototype 多实例。(常用)
             3.request：作用于 web 应用的请求范围
             4.session：作用于 web 应用的会话范围
             5.global-session：作用于集群环境的会话范围（全局会话范围），当不是集群环境时，就是session
        -->
    <bean id="user"  class="com.testWeb.daomain.User" scope="prototype"></bean>
</beans>
```

### 2. 注解创建



# Spring-AOP

**AOP（面向切面）**

是面向对象开发的一种补充，它允许开发人员在不改变原来模型的基础上动态的修改模型以满足新的需求，如：动态的增加日志、安全或异常处理等。AOP使业务逻辑各部分间的耦合度降低，提高程序可重用性，提高开发效率。

1. 横切关注点：从每个方法中抽取出来的同一类非核心业务代码。
2. 切面：封装横切信息点的类，每个关注点体现为一个通知方法。
3. 通知：切面必须要完成的各个具体工作，也就是切面里的一个个方法。
4. 目标：被通知的对象，也就是被通知方法所作用的对象。
5. 代理：像目标对象应用通知之后所创建的代理对象。
6. 连接点：横切关注点在程序代码中的具体体现，对应用程序执行的某个特定位置。（通俗来讲就是一个个的方法）
7. 切入点：切入点就是定位连接点的方式。每个通知上的切入点表达式找到对应的连接点，执行通知之后连接点也就变成了切入点。



![image-20230110171850958](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230110171850958.png)

spring-aop.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context-3.0.xsd
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- 开启AOP -->
    <aop:aspectj-autoproxy proxy-target-class="true"/>
 	
     <!-- 切面 -->
    <bean id="logHandler" class="cn.edu.guet.aop.LogHandler"/>
    <aop:config>
        <aop:aspect id="logAspect" ref="logHandler">
            <aop:after method="saveLog" pointcut-ref="logPointCut"></aop:after>
            <aop:pointcut id="logPointCut" expression="execution(* cn.edu.guet.service.*.*(..))"/>
        </aop:aspect>
    </aop:config>

</beans>
```



# SSM

## 介绍

📝 [(210条消息) SSM框架讲解（史上最详细的文章）_代码贩子、的博客-CSDN博客_ssm框架](https://blog.csdn.net/weixin_45650003/article/details/121623824)

官方Spring+官方SpringMVC+MyBatis

![img](https://img-blog.csdnimg.cn/20200704143030291.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0Nzg1MzUx,size_16,color_FFFFFF,t_70)

**SSM框架简介**

SSM框架是Spring MVC ，Spring和Mybatis框架的整合，是标准的MVC模式，将整个系统划分为View层，Controller层，Service层，DAO层四层，使用Spring MVC负责请求的转发和视图管理，Spring实现业务对象管理，Mybatis作为数据对象的持久化引擎。

**SSM框架各层介绍**

1. 持久层（Mybatis）：Dao层（mapper）
   DAO层：DAO层主要是做数据持久层的工作，负责与数据库进行联络的一些任务都封装在此。

   DAO层的设计首先是设计DAO的接口。

   然后在Spring的配置文件中定义此接口的实现类。

   然后就可在模块中调用此接口来进行数据业务的处理，而不用关心此接口的具体实现类是哪个类，显得结构非常清晰。

   DAO层的数据源配置，以及有关数据库连接的参数都在Spring的配置文件中进行配置。

2. 业务层（Spring）：Service层
   Service层：Service层主要负责业务模块的逻辑应用设计。

   首先设计接口，再设计其实现的类。

   接着再在Spring的配置文件中配置其实现的关联。这样我们就可以在应用中调用Service接口来进行业务处理。

   Service层的业务实现，具体要调用到已定义的DAO层的接口。

   封装Service层的业务逻辑有利于通用的业务逻辑的独立性和重复利用性，程序显得非常简洁。

3. 表现层（springMVC）：Controller层（Handler层）
   Controller层：Controller层负责具体的业务模块流程的控制。

   在此层里面要调用Service层的接口来控制业务流程。

   控制的配置也同样是在Spring的配置文件里面进行，针对具体的业务流程，会有不同的控制器，我们具体的设计过程中可以将流程进行抽象归纳，设计出可以重复利用的子单元流程模块，这样不仅使程序结构变得清晰，也大大减少了代码量。

4. View层

   作用：主要和控制层紧密结合，主要负责前台jsp页面的表示。

**SSM框架各层关系**

- DAO层、Service层这两个层次都可以单独开发，互相的耦合度很低，完全可以独立进行，这样的一种模式在开发大项目的过程中尤其有优势。
- Controller，View层因为耦合度比较高，因而要结合在一起开发，但是也可以看作一个整体独立于前两个层进行开发。这样，在层与层之前我们只需要知道接口的定义，调用接口即可完成所需要的逻辑单元应用，一切显得非常清晰简单。
- Service层是建立在DAO层之上的，建立了DAO层后才可以建立Service层，而Service层又是在Controller层之下的，因而Service层应该既调用DAO层的接口，又要提供接口给Controller层的类来进行调用，它刚好处于一个中间层的位置。每个模型都有一个Service接口，每个接口分别封装各自的业务处理方法。

## SpringMVC配置文件

📝[(210条消息) springMVC和applicationContext中的XML文件配置_gu_gu_bird的博客-CSDN博客_applicationcontext.xml include](https://blog.csdn.net/weixin_44654036/article/details/109502450#:~:text=applicationContext.xml 1 设置scope值是singleton时候，加载spring配置文件时候就会创建单实例对象,2 设置scope值是 prototype 时候，不是在加载spring配置文件时候创建对象，是在调用getBean方法时候创建多实例对象)

前端控制器，所有的请求都会到达这个Servlet，它负责统一调度

```java
@Controller
@Service
@Component
@Mapper
@Repository
request.getRequestDispatcher("viewUser.jsp").forward(request,response);
```

**配置springMVC的前端控制器**  web.xml

```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	version="3.1" metadata-complete="true">
     <display-name>Archetype Created Web Application</display-name>  
    <!-- Spring和mybatis的配置文件 -->  
    <context-param>  
        <param-name>contextConfigLocation</param-name>  
        <param-value>classpath:applicationContext.xml</param-value> 
    </context-param>  
    
	<!-- 如果是用mvn命令生成的xml，需要修改servlet版本为3.1 -->
	<!-- 配置DispatcherServlet -->
	<servlet>
		<servlet-name>mvc-dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<!-- 配置springMVC需要加载的配置文件
			spring-dao.xml,spring-service.xml,spring-web.xml
			Mybatis - > spring -> springmvc
		 -->
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<!-- <param-value>classpath:spring/spring-*.xml</param-value -->
            <param-value>spring-mvc.xml</param-value>
		</init-param>
        
         <!-- 配置启动加载,会随着项目启动就加载，值越小优先级越高（值为正整数才有效）(非必要) -->
    	<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>mvc-dispatcher</servlet-name>
		<!-- 默认匹配所有的请求 -->
		<url-pattern>/</url-pattern>
	</servlet-mapping>
</web-app>
```

配置请求过滤器，编码格式设为UTF-8，避免中文乱码（非必要）

```xml
<!-- 配置请求过滤器，编码格式设为UTF-8，避免中文乱码 -->
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class> org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
</filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

配置Listener自动加载spring的配置文件以及设置spring加载文件的名称及路径，默认情况是加载WEB-INF下的ApplicationContext.xml

```xml
<!-- 配置spring的加载文件名称及路径 -->
<listener>
	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>classpath: spring.xml</param-value>
</context-param>
```

配置HiddenHttpMethodFilter，处理从客户端发送的PUT、DELETE请求 （非必要）

```xml
<!-- 配置HiddenHttpMethodFilter，处理从客户端发送的PUT、DELETE请求 -->
<filter>
    <filter-name>HiddenHttpMethodFilter</filter-name>
    <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>HiddenHttpMethodFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```



📝 [(210条消息) SpringMVC配置文件（spring-mvc.xml）_ACGkaka_的博客-CSDN博客_spring-mvc.xml配置](https://blog.csdn.net/qq_33204709/article/details/81136484)

SpringMVC 主要有以下四个配置：

1. 配置组件扫描，必配，组件扫描会扫描包下的所有的Controller类

```xml
    <!-- 配置组件扫描 -->
    <context:component-scan base-package="controller" />
```

2. 配置MVC注解扫描，必配，和组件扫描搭配，相当于同时配置了HandlerMapping和Controller

```xml
    <!-- 配置MVC注解扫描 -->
	<mvc:annotation-driven />
```

3. 配置视图解析器，选配，视图解析器是为了当html，jsp等前端文件放到WEB-INF/的路径下时，浏览器不能直接访问，就需要使用视图解析器来访问相应的前端文件。

```xml
    <!-- 配置视图解析器， -->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/" /><!-- 前缀 -->
		<property name="suffix" value=".jsp" /><!-- 后缀 -->
	</bean>
```

4. 配置拦截器，选配，拦截器是拦截tomcat容器和spring容器之间的交互信息，主要是用于验证用户在访问该网页时是否登陆

```xml
    <!-- 配置拦截器 -->
	<mvc:interceptors>
		<mvc:interceptor>
			<mvc:mapping path="/*"/>
			<bean class="interceptors.SomeInterceptor"/>
		</mvc:interceptor>
	</mvc:interceptors>
```

spring-mvc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc" 
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/mvc
	http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd">
	<!-- 配置SpringMVC -->
    
    <!-- 自动扫描该包，使SpringMVC认为包下用了@controller注解的类是控制器 -->  
    <context:component-scan base-package="cn.edu.guet.controller" />  
    
	<!-- 1.开启SpringMVC注解模式 -->
	<!-- 简化配置： 
		(1)自动注册DefaultAnootationHandlerMapping,AnotationMethodHandlerAdapter 
		(2)提供一些列：数据绑定，数字和日期的format @NumberFormat, @DateTimeFormat, xml,json默认读写支持 
	-->
	<mvc:annotation-driven />
	
	<!-- 2.静态资源默认servlet配置
		(1)加入对静态资源的处理：js,gif,png
		(2)允许使用"/"做整体映射
	 -->
	 <mvc:default-servlet-handler/>
    
    <!-- 静态资源处理  css js imgs -->
    <mvc:resources location="/resources/**" mapping="/resources"/>
	 
	 <!-- 3.配置jsp 显示ViewResolver  定义跳转的文件的前后缀 ，视图模式配置 -->
	 <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 	<property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
	 	<property name="prefix" value="/WEB-INF/jsp/" />
	 	<property name="suffix" value=".jsp" />
	 </bean>
	 
</beans>
```

## spring配置文件

📝 [怎样使用Spring的配置文件？带大家一起玩转Spring配置文件-云社区-华为云 (huaweicloud.com)](https://bbs.huaweicloud.com/blogs/327394)

🧷 https://github.com/THEO-1126/ssm/blob/master/src/main/resources/spring/spring-dao.xml

applicationContext.xml

实际开发中，Spring的配置内容非常多，这就导致Spring配置很繁杂且体积很大，所以，可以将部分配置拆解到其他配置文件中，而在Spring主配置文件通过import标签进行加载

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
    
    <!-- resource="路径"，写出要加载的xml文件的相对路径 -->
    <import resource="spring-dao.xml"/>
    <import resource="spring-service.xml"/>
</beans>
```

spring-dao.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd">
	<!-- 配置整合mybatis过程 -->
	<!-- 1.配置数据库相关参数properties的属性：${url} -->
	<context:property-placeholder location="db.properties" />

	<!-- 2.数据库连接池 -->
	<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
		<!-- 配置连接池属性 -->
		<property name="driverClass" value="${driver}" />
		<property name="jdbcUrl" value="${url}" />
		<property name="user" value="${user}" />
		<property name="password" value="${password}" />

		<!-- c3p0连接池的私有属性 -->
		<property name="maxPoolSize" value="30" />
		<property name="minPoolSize" value="10" />
		<!-- 关闭连接后不自动commit -->
		<property name="autoCommitOnClose" value="false" />
		<!-- 获取连接超时时间 -->
		<property name="checkoutTimeout" value="10000" />
		<!-- 当获取连接失败重试次数 -->
		<property name="acquireRetryAttempts" value="2" />
	</bean>
    
    <!-- 或者使用数据库 -->
    <bean>
        <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"></property>
        <property name="url" value="${url}"></property>
        <property name="username" value="${name}"></property>
        <property name="password" value="${password}"></property>
    </bean>

	<!-- 3.配置SqlSessionFactory对象 -->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<!-- 注入数据库连接池 -->
		<property name="dataSource" ref="dataSource" />
		<!-- 配置MyBaties全局配置文件:mybatis-config.xml -->
		<property name="configLocation" value="classpath:mybatis-config.xml" />
		<!-- 扫描entity包 使用别名 -->
		<property name="typeAliasesPackage" value="com.soecode.lyf.entity" />
		<!-- 扫描sql配置文件:mapper需要的xml文件 -->
		<property name="mapperLocations" value="classpath:mapper/*.xml" />
	</bean>

	<!-- 4.配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中 -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<!-- 注入sqlSessionFactory -->
		<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
		<!-- 给出需要扫描Dao接口包 -->
		<property name="basePackage" value="com.soecode.lyf.dao" />
	</bean>
</beans>
```

spring-service.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/tx
	http://www.springframework.org/schema/tx/spring-tx.xsd">
	<!-- 扫描service包下所有使用注解的类型 -->
	<context:component-scan base-package="com.soecode.lyf.service" />

	<!-- 配置事务管理器 -->
	<bean id="transactionManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<!-- 注入数据库连接池 -->
		<property name="dataSource" ref="dataSource" />
	</bean>

	<!-- 配置基于注解的声明式事务 -->
	<tx:annotation-driven transaction-manager="transactionManager" />
</beans>
```



依赖 pom.xml

```xml
<dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>5.3.24</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>5.3.24</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.3.24</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>5.3.24</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.3.24</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>
	<!-- 数据库连接池 -->
    <dependency>
        <groupId>c3p0</groupId>
        <artifactId>c3p0</artifactId>
        <version>0.9.1.2</version>
    </dependency>
  </dependencies>


<build>
    <finalName>OfficialSpringMVC</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
```

# mySSM

## 架构

![img](https://img-blog.csdnimg.cn/20200704143030291.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0Nzg1MzUx,size_16,color_FFFFFF,t_70)

## SpringMVC 配置文件

**dispatcherServlet.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/mvc
	http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd">


    <!-- 扫描controller包 -->
    <context:component-scan base-package="cn.edu.guet.controller" />

    <!-- 配置SpringMVC -->
    <!-- 1.开启SpringMVC注解模式 -->
    <!-- 简化配置：
        (1)自动注册DefaultAnootationHandlerMapping,AnotationMethodHandlerAdapter
        (2)提供一些列：数据绑定，数字和日期的format @NumberFormat, @DateTimeFormat, xml,json默认读写支持
    -->
    <mvc:annotation-driven />

    <!-- 2.静态资源默认servlet配置
        (1)加入对静态资源的处理：js,gif,png
        (2)允许使用"/"做整体映射
     -->
    <mvc:default-servlet-handler/>

    <!-- 3.配置jsp 显示ViewResolver -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
        <property name="prefix" value="/WEB-INF/jsp/" />
        <property name="suffix" value=".jsp" />
    </bean>

</beans>
```

**springMVC的前端控制器 web.xml** 

```xml
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1" metadata-complete="true">
  <display-name>Archetype Created Web Application</display-name>
  <!-- Spring 配置文件 -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

  <!-- 如果是用mvn命令生成的xml，需要修改servlet版本为3.1 -->
  <!-- 配置DispatcherServlet -->
  <servlet>
    <servlet-name>DispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- 配置springMVC需要加载的配置文件
        spring-dao.xml,spring-service.xml,spring-web.xml
        Mybatis - > spring -> springmvc
     -->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:dispatcherServlet.xml</param-value>
    </init-param>


    <!-- 配置启动加载,会随着项目启动就加载，值越小优先级越高（值为正整数才有效）(非必要) -->
    <load-on-startup>1</load-on-startup>

  </servlet>

  <servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <!-- 默认匹配所有的请求 -->
    <url-pattern>/</url-pattern>
  </servlet-mapping>
</web-app>

```

## Spring配置文件

**applicationContext.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx
        https://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- resource="路径"，写出要加载的xml文件的相对路径 -->

    <import resource="spring-dao.xml"/>
    <import resource="spring-service.xml"/>

</beans>

```

**spring-dao.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 配置整合mybatis过程 -->
    <!-- 1.配置数据库相关参数properties的属性：${url} -->
    <context:property-placeholder location="classpath:db.properties" />

    <!-- 2.数据库连接池 -->
<!--    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">-->
<!--        &lt;!&ndash; 配置连接池属性 &ndash;&gt;-->
<!--        <property name="driverClass" value="${driver}" />-->
<!--        <property name="jdbcUrl" value="${url}" />-->
<!--        <property name="user" value="${name}" />-->
<!--        <property name="password" value="${password}" />-->

<!--        &lt;!&ndash; c3p0连接池的私有属性 &ndash;&gt;-->
<!--        <property name="maxPoolSize" value="30" />-->
<!--        <property name="minPoolSize" value="10" />-->
<!--        &lt;!&ndash; 关闭连接后不自动commit &ndash;&gt;-->
<!--        <property name="autoCommitOnClose" value="false" />-->
<!--        &lt;!&ndash; 获取连接超时时间 &ndash;&gt;-->
<!--        <property name="checkoutTimeout" value="10000" />-->
<!--        &lt;!&ndash; 当获取连接失败重试次数 &ndash;&gt;-->
<!--        <property name="acquireRetryAttempts" value="2" />-->
<!--    </bean>-->

    <!-- 2. 或者使用数据库 -->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="${driver}"></property>
        <property name="url" value="${url}"></property>
        <property name="username" value="${name}"></property>
        <property name="password" value="${password}"></property>
    </bean>

    <!-- 3.配置SqlSessionFactory对象 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!-- 注入数据库连接池 -->
        <property name="dataSource" ref="dataSource" />
        <!-- 配置MyBaties全局配置文件:mybatis-config.xml -->
<!--        <property name="configLocation" value="classpath:mybatis-config.xml" />-->
        <!-- 扫描bean包-->
        <property name="typeAliasesPackage" value="cn.edu.guet.bean" />
        <!-- 扫描sql配置文件:mapper需要的xml文件 -->
        <property name="mapperLocations" value="classpath:mapper/*.xml" />
    </bean>

    <!-- 4.配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!-- 注入sqlSessionFactory -->
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
        <!-- 给出需要扫描Dao接口包 -->
        <property name="basePackage" value="cn.edu.guet.dao" />
    </bean>
</beans>
```

**spring-service**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/tx
	http://www.springframework.org/schema/tx/spring-tx.xsd">

    <import resource="spring-dao.xml"/>

    <!-- 扫描service包下所有使用注解的类型  @Autowired 自动注入-->
    <context:component-scan base-package="cn.edu.guet.service" />

    <!-- 配置事务管理器 -->
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!-- 注入数据库连接池 -->
        <property name="dataSource" ref ="dataSource" />
    </bean>

    <!-- 配置基于注解的声明式事务 -->
    <tx:annotation-driven transaction-manager="transactionManager" />
</beans>
```

## mybatis

**mybatis-config.xml**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 配置全局属性 -->
    <settings>
        <!-- 使用jdbc的getGeneratedKeys获取数据库自增主键值 -->
        <setting name="useGeneratedKeys" value="true" />

        <!-- 使用列别名替换列名 默认:true -->
        <setting name="useColumnLabel" value="true" />

        <!-- 开启驼峰命名转换:Table{create_time} -> Entity{createTime} -->
        <setting name="mapUnderscoreToCamelCase" value="true" />
    </settings>
</configuration>
```

**db.properties**

```xml
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/redis_test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
name=root
password=THEO1126
```

## 日志

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <!-- 配置日志信息输出目的地 -->
    <Appenders>
        <!-- 输出到控制台 -->
        <Console name="Console" target="SYSTEM_OUT">
            <!--配置日志信息的格式 -->
            <PatternLayout
                    pattern="%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n"/>
            "/>
        </Console>

        <!-- 输出到文件，其中有一个append属性，默认为true，即不清空该文件原来的信息，采用添加的方式，若设为false，则会先清空原来的信息，再添加 -->
        <File name="MyFile" fileName="/Users/liwei/mybatis.log" append="false">
            <PatternLayout>
                <!--配置日志信息的格式 -->
                <pattern>%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n</pattern>
            </PatternLayout>
        </File>

    </Appenders>
    <!-- 定义logger,只有定义了logger并引入了appender,appender才会有效 -->
    <Loggers>
        <!-- 将业务mapper接口所在的包填写进去,并用在控制台和文件中输出 -->
        <logger name="cn.edu.guet.dao" level="TRACE" additivity="false">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="MyFile"/>
        </logger>

        <Root level="INFO">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="MyFile"/>
        </Root>
    </Loggers>
</Configuration>
```

## 依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>cn.edu.guet</groupId>
  <artifactId>mySSM</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <name>mySSM Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>

    <!-- 1.日志 -->
    <!-- 实现slf4j接口并整合 -->
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.1.1</version>
    </dependency>

    <!-- 2.数据库 -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.21</version>
    </dependency>

    <dependency>
      <groupId>c3p0</groupId>
      <artifactId>c3p0</artifactId>
      <version>0.9.1.2</version>
    </dependency>

    <!-- DAO: MyBatis -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.3.0</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.2.3</version>
    </dependency>

    <!-- 3.Servlet web -->
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.5.4</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
    </dependency>

    <!-- 4.Spring -->
    <!-- 1)Spring核心 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>5.3.24</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>5.3.24</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.3.24</version>
    </dependency>
    <!-- 2)Spring DAO层 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>5.3.24</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>5.3.24</version>
    </dependency>
    <!-- 3)Spring web -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>5.3.24</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.3.24</version>
    </dependency>
    <!-- 4)Spring test -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>4.1.7.RELEASE</version>
    </dependency>
    <!--  Spring aop  -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>5.3.24</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>5.3.24</version>
    </dependency>

    <!-- redis客户端:Jedis -->
    <dependency>
      <groupId>redis.clients</groupId>
      <artifactId>jedis</artifactId>
      <version>2.7.3</version>
    </dependency>
    <dependency>
      <groupId>com.dyuproject.protostuff</groupId>
      <artifactId>protostuff-core</artifactId>
      <version>1.0.8</version>
    </dependency>
    <dependency>
      <groupId>com.dyuproject.protostuff</groupId>
      <artifactId>protostuff-runtime</artifactId>
      <version>1.0.8</version>
    </dependency>
     <!--  日志   -->
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.17.1</version>
    </dependency>
    <!--  JSON 依赖  -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.9.3</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.9.3</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.3</version>
    </dependency>
    <!-- Map工具类 -->
    <dependency>
      <groupId>commons-collections</groupId>
      <artifactId>commons-collections</artifactId>
      <version>3.2</version>
    </dependency>

  </dependencies>

  <build>
    <finalName>mySSM</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>
```





## 问题

**问题1**

问题：解决 Could not open ServletContext resource [/jdbc.properties]

![image-20230114233435667](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230114233435667.png)

解决：

[ 解决 Could not open ServletContext resource /jdbc.properties\]_代码深耕的博客-CSDN博客](https://blog.csdn.net/m0_57310021/article/details/122651991)

ClassPath指定的是java加载类的路径。只有类在ClassPath中，java命令才能找到它，并解释它。

![image-20230114233445928](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230114233445928.png)

**问题2**

Error creating bean with name ‘dataSource‘ defined in class path resource报错解决方法

![image-20230114233510741](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230114233510741.png)

解决：

[(210条消息) Error creating bean with name ‘dataSource‘ defined in class path resource报错解决方法_tkrj7_的博客-CSDN博客_error creating bean with name 'datasourcescriptdat](https://blog.csdn.net/tkrj7_/article/details/115629939)

1. aspactj的jar包没导入进去

   ```xml
   <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-aspects</artifactId>
           <version>5.2.5.RELEASE</version>
   </dependency>
   
   ```

2. mysql-connector-java的版本问题 修改为最新版本：

   ```xml
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.21</version>
   </dependency>
   ```

**问题3**

No Spring WebApplicationInitializer types detected on classpath 加载不到配置文件或找不到spring主配置

解决：

1. 在web.xml当中配置错误，没有正确的引入spring的配置文件。找不到时，报告次错误

   检查配置文件，引入是否正确。

   classpath:springconfig.xml ,这个格式的配置为读取本项目classpath下的文件

   classpath*:springconfig.xml 这个格式的配置为读取本项目下或者是jar包的classpath下的配置文件。多个同名只读第一个。

2. No Spring WebApplicationInitializer types detected on classpath 

   tomacat 服务器加载jar 不全 ，导致启动错误。

   使用编译器 maven clean  下。在clean 下项目。

3. lag4j.properties 配置文件的加载 

   这个配置文件一般要配置到当前目录中。web.xml 当中引入日志配置文件时，使用classpath*:log4j.properties 配置参数，如果文件在jar包，会报错：找不到此文件。

**问题4 **

java.lang.ClassNotFoundException: com.fasterxml.jackson.databind.exc.InvalidDefinitionException

![image-20230115003458997](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20230115003458997.png)

解决：

[(210条消息) 解决java.lang.ClassNotFoundException: com.fasterxml.jackson.databind.exc.InvalidDefinitionException_开着拖拉机回家的博客-CSDN博客](https://blog.csdn.net/qq_35995514/article/details/90263116)

加入json依赖

```xml
<!--  JSON 依赖  -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.9.3</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>2.9.3</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.3</version>
</dependency>
<!-- Map工具类 -->
<dependency>
    <groupId>commons-collections</groupId>
    <artifactId>commons-collections</artifactId>
    <version>3.2</version>
</dependency>
```

