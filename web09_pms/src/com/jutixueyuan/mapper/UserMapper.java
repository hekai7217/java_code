package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 黄药师
 * @date 2020-10-31 17:02
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public interface UserMapper {

    User login(@Param("username") String username,@Param("password") String password);

}
