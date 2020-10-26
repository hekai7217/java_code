package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-10-12 9:23
 * @desc 百战程序员 http://www.jutixueyuan.com
 *    测试 mybatis 基于注解开发
 *
 *    注解开发 使mybatis操作变的更加简单,不用写xxxMapper.xml,可以直接在方法上面使用注解配置sql

      mybatis的常用注解:

        @select  查询的注解
           @Results 配置  结果集 和对象的映射

        @delete  删除注解
        @update  添加注解
        @insert  注解

      开发中是使用注解还是xml?
        01 官方文档说了, 注解 便捷了 部分sql的开发操作,
            复杂的 sql还是推荐使用xml, 注解有局限性

      如果使用注解:
         在config核心文件中需要配置
           <mapper class="xxx"></mapper


 */
public interface UserMapper {

    /**
     *   @Select  查询的注解
     *      如果需要配置 查询的sql语句,直接使用注解 在注解中配置sql的字符串
     *   如果 查询的结果集的字段和java的属性名称一致, 可以不用配置返回结果映射,
     *   放回结果会自动封装成 方法的返回结果
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User selectUserById(Integer id);

    // 如果查询的结果集的字段和 java的 属性名称不一致
    // xml中使用的是 resultMap 进行映射   注解中也有配置结果映射

    //  @Results 注解可以把结果集  和 查询返回的对象进行映射

    // @Result 注解 配置 查询的结果集合 对象的属性的映射
    //       注解中的属性: id   是否是主键  默认false 如果是主键配置 true
    //       注解中的属性: column   配置结果集的列名
    //       注解中的属性: property  配置 实体对象的 的属性名称
    //              可以配置 javaType/jdbcType 一般都是省略

    @Select("select id uid,name uname,password pwd,age uage from user where id = #{id}")
    @Results({
            @Result(id = true,column = "uid",property = "id"),
            @Result(column = "uname",property = "name"),
            @Result(column = "pwd",property = "password"),
            @Result(column = "uage",property = "age"),
    })
    User selectUserPrimaryById(Integer id);

    // 如果是查询结果返回的是多行 配置和当行一行
    @Select("select * from user")
    List<User> findAllUsers();

    /**
     *  xml中可以 批准 自动返回新增数据的主键id  注解也可以配置
     *    添加其他的配置 @Options
     *      keyProperty  对象的主键
     *      useGeneratedKeys 是否使用自增的主键
     *
     * @param u
     * @return
     */
    // 添加注解
    @Insert("insert into user(name,password,age) values(#{name},#{password},#{age})")
    @Options(keyProperty = "id",useGeneratedKeys = true)
    int insertUser(User u);

    // Update 修改的注解
    @Update("update user set name = #{name},age = #{age},password = #{password} where id = #{id}")
    int updateUser(User u);

    //Delete 删除的注解
    @Delete("delete from user where id = #{id}")
    int delUserByid(Integer id);


    // mybatis 中查询参数为多个的情况
    //多参: 查询的方法的参数中有多个参数

    // Parameter 'name' not found. Available parameters are [arg1, arg0, param1, param2]
    // 找不到参数
    // 解决: 使用参数 数组 arg[x] 来解决
    // 默认可以使用param + 参数类表中的位置来命名  #{param1}, #{param2}

    // 不好 多参容易写错了
    @Select("select * from USER where name = #{param1} and password=#{param2}")
    User userfindOne01(String name,String password);

    // oop思想 面向对象   可以把多个参数封装到 对象或者map中

    // 把多参数封装成对象
    //ognl 语法 : #{对象的属性/map的key 获知值}
    @Select("select * from USER where name = #{name} and password=#{password}")
    User userfindOne02(User user);

    //封装成map
    @Select("select * from USER where name = #{name} and password=#{password}")
    User userfindOne03(Map<String,Object> map);

    // mybats 也有自己的解决方案
    // 使用注解 @Param 告诉sql的 #{xxx} 从而获取数值
    // mybatis的底层 把注解解析 把 参数封装到 一个map中 通过 #{name} 把map中存储的注解的参数的值获取到
    @Select("select * from USER where name = #{name} and password=#{password}")
    User userfindOne04(@Param("name") String name,@Param("password") String password);

    // 总结: 上面的4个方式都可以 推荐大家使用对象或者  @Param("name") 解决多参的问题

    // 测试 ognl的 # 和 $ 符号

    // 使用 #{} 后的sql语句:  select * from user where id = ?   , ? 占位符,预编译,安全
    // 使用 ${} 后的sql语句:  select * from user where id = 1    , id = 1 直接值的拼接,这个不安全,容易出现sql的注入
    // 以后都是使用数据集操作都是使用 #{}
    @Select("select * from user where id = ${id}")
    User selectUser(Integer id);


}
