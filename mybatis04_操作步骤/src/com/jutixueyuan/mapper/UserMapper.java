package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.User;

/**
 * @author 黄药师
 * @date 2020-10-12 9:23
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *
 */
public interface UserMapper {

    User selectUserById(Integer id);
}
