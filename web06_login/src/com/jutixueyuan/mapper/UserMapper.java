package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author 黄药师
 * @date 2020-10-27 17:12
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public interface UserMapper {

    @Select("select * from t_user where name = #{name} and pwd = #{pwd}")
    User login(User u);

}
