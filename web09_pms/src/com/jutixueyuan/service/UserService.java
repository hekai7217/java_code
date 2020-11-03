package com.jutixueyuan.service;

import com.jutixueyuan.bean.User;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-31 16:58
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     *  判断用户名是否可以使用
     * @param username
     * @return
     */
    boolean checkName(String username);

    /**
     * 添加user
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 查询所有
     * @return
     */
    List<User> queryAll();

    /**
     * 通过id删除 stu
     * @param id
     * @return
     */
    boolean delStu(int id);

    /**
     * 通过id查询
     * @param parseInt
     * @return
     */
    User findStuById(int parseInt);

    /**
     * 修改
     * @param user
     * @return
     */
    boolean updateUser(User user);
}
