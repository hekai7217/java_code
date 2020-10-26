package com.jutixueyuan.mapper;

import com.jutixueyuan.pojo.User;
import com.jutixueyuan.pojo.UserExample;
import java.util.List;

/**
 *  自动生成 mapper的对应 接口
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findUser(Integer id);

}