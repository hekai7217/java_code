package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-03 14:35
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  usermapper的测试
 */
public class UserMapperTest {

    @Test
    public void test01(){


        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.pageUser(0, 10);
        System.out.println("users = " + users);
        MybatisUtils.close(sqlSession);

    }


}
