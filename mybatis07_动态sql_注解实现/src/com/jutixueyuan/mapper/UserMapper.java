package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.utils.UserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-10-12 9:23
 * @desc 百战程序员 http://www.jutixueyuan.com
 *    测试 mybatis 基于mybatis动态sql注解开
 *
 *    动态sql的注解:
 *      @SelectProvider  查询的注解
 *      @UpdateProvider
 *      @InsertProvider
 *      @DeleteProvider  常用的注解
 *         注解的属性:
 *          type    配置动态sql产生的java类(要自己完成)
 *          method  当前的方法对应的动态sql中产生sql的方法
 *
 *    产生动态sql的类:
 *       SQL  类 mybatis 提供的拼接sql的的javaapi, 和Stringbuilder 类似提供了很多方法拼接sql
 *
 *       常用的方法:
 *          select()  拼接查询的column
 *          from()    拼接查询的table
 *          where()   拼接查询的where条件
 *          OR()/And   默认多个条件都是and  可以用or方法 变为or
 *          update()   拼接更新的表
 *          set()      拼接更新的字段的更新
 * */
public interface UserMapper {

    //通过 条件查询User   把user的条件 封装到 user对象中

    // SelectProvider 动态sql的查询注解
    /**
     *  type  那个类创建动态的SQL  UserProvider.class
     *  method  方法   当前的这个方法 使用UserProvider 中的xxx动态的sql
     *
     *    当前的方法名称 和 动态sql创建类中的方法名称一致
     *
     *
     *    接口中的方法  findUserByCondition(User u)  使用的动态的sql 语句是
     *      UserProvider.class(动态sql创建类)中的 findUserByCondition 这个返回的结果
     *
     * @param u
     * @return
     */
    @SelectProvider(type = UserProvider.class,method = "findUserByCondition")
    List<User> findUserByCondition(User u);

//    // 条件查询的统计操作
    @SelectProvider(type =UserProvider.class,method = "findUserByConditionUserCount")
    Long findUserByConditionUserCount(User u);
//
//    // 动态的sql更新
    @UpdateProvider(type = UserProvider.class,method = "updateUserByNotNUll")
    int updateUserByNotNUll(User user);
//
//    // 批量删除  可以删除多条数据
    // 集合的操作 使用@params处理下
    @DeleteProvider(type = UserProvider.class,method = "deleteBatchByid")
    int deleteBatchByid(@Param("ids") List<Integer> ids);
//
//    //通过id查询 多个user
//    List<User> selectUserByIds(@Param("list") List<Integer> list);
//
//    // 批量添加user
    @InsertProvider(type = UserProvider.class,method = "insertUsers")
    int insertUsers(@Param("us") List<User> us);

}
