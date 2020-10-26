package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-10-12 9:23
 * @desc 百战程序员 http://www.jutixueyuan.com
 *    测试 mybatis 基于mybatis动态sql开发
 */
public interface UserMapper {

    //通过 条件查询User   把user的条件 封装到 user对象中
    List<User> findUserByCondition(User u);

    // 条件查询的统计操作
    Long findUserByConditionUserCount(User u);

    // 动态的sql更新
    int updateUserByNotNUll(User user);

    // 批量删除  可以删除多条数据
    // 集合的操心 使用@params处理下
    int deleteBatchByid(@Param("ids") List<Integer> ids);

    //通过id查询 多个user
    List<User> selectUserByIds(@Param("us") List<Integer> list);

    // 批量添加user
    int inserUsers(@Param("us") List<User> us);

}
