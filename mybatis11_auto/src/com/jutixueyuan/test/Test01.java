package com.jutixueyuan.test;

import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.pojo.User;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-13 17:00
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *    测试逆向工程的方法
 */
public class Test01 {

    @Test
    public void testInsert(){

        // 添加的操作
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName("尹志平");
        user.setAge(30);

        // 添加所有的字段
//        int insert = mapper.insert(user);
        // 条件条件
        int i = mapper.insertSelective(user);

        System.out.println("i = " + i);
        MybatisUtils.close(sqlSession);
    }

    @Test
    public void testUpdate(){

        // 添加的操作
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName("丘处机");
        user.setPassword("123");
        user.setId(15);
        int i = mapper.updateByPrimaryKeySelective(user);

        System.out.println("i = " + i);
        MybatisUtils.close(sqlSession);
    }

}
