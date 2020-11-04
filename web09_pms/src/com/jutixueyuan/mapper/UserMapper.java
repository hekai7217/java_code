package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-31 17:02
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public interface UserMapper {

    User login(@Param("username") String username,@Param("password") String password);


    User checkName(String username);

    int addUser(User user);

    List<User> queryAll();

    int delStu(int id);

    User findUserById(int id);

    int updateUser(User user);

    // 分页的mapper fangfa
    List<User> pageUser(@Param("index") Integer index,@Param("pageSize") int pageSize);

    // 查询总数
    Integer selectCount();
}
