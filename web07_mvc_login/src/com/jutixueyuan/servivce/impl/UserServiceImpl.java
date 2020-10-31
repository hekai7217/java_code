package com.jutixueyuan.servivce.impl;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.servivce.UserService;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 黄药师
 * @date 2020-10-28 11:32
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   业务的实现类型
 */
public class UserServiceImpl implements UserService {
    @Override
    public User login(User user) {

        // 查询数据库
        // 01 拿到sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 02 拿到mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 03 调用方法
        User login = mapper.login(user);
        // 04  关闭资源

        MybatisUtils.close(sqlSession);

        return login;
    }
}
