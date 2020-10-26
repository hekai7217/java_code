package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.User;

import java.util.List;

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

    //通过id查询
    User selectUserById(Integer id);

    //添加
    int insertUser(User user);

    //删除
    int deleteUserById(Integer id);

    int updateUser(User user);

    // 查询 所有
    List<User> findUser();

    //查询操作
    User selectPrimarykeyById(Integer id);

}
