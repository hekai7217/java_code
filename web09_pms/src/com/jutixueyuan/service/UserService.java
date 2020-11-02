package com.jutixueyuan.service;

import com.jutixueyuan.bean.User;

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
}
