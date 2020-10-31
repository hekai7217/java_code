package com.jutixueyuan.servivce;

import com.jutixueyuan.bean.User;

/**
 * @author 黄药师
 * @date 2020-10-28 11:31
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   所有的user的业务都放到这里
 */
public interface UserService {

    User login(User user);
    
}

