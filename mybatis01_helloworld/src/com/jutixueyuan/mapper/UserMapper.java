package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.User;

/**
 * @author 黄药师
 * @date 2020-10-09 16:45
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    mybatis 开发的时候 不需要写实现类 直接写 接口
 *      mybatis 会通过 动态代理实现接口中的方法,执行sql
 *      返回结果
 *
 */
public interface UserMapper {

    //添加操作
    int insertUserInfo(User u);

}
