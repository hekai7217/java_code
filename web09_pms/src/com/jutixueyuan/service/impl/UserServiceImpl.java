package com.jutixueyuan.service.impl;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.service.UserService;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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

    /**
     *  用户名是否存在
     * @param username
     * @return
     */
    @Override
    public boolean checkName(String username) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkName(username);
        MybatisUtils.close(sqlSession);

//        return user == null; // 为null 返回 true   不为null 返回false
        return user != null; // 为null 返回 false   不为null 返回true
    }

    @Override
    public boolean addUser(User user) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int row = mapper.addUser(user);

        sqlSession.commit();
        MybatisUtils.close(sqlSession);

        return row > 0;
    }

    @Override
    public List<User> queryAll() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.queryAll();
        MybatisUtils.close(sqlSession);

        return list;
    }

    @Override
    public boolean delStu(int id) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int row = mapper.delStu(id);

        sqlSession.commit();
        MybatisUtils.close(sqlSession);

        return row > 0 ;
    }

    @Override
    public User findStuById(int id) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(id);
        MybatisUtils.close(sqlSession);

        return user;
    }

    @Override
    public boolean updateUser(User user) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int row = mapper.updateUser(user);

        sqlSession.commit();
        MybatisUtils.close(sqlSession);

        return row > 0 ;
    }
}
