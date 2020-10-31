package com.jutixueyuan.service.impl;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.service.UserService;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 黄药师
 * @date 2020-10-31 17:01
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class UserServiceImpl  implements UserService {
    @Override
    public User login(String username, String password) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.login(username, password);
        MybatisUtils.close(sqlSession);

        return user;
    }
}
