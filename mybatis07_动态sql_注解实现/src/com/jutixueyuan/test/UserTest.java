package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-12 17:32
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class UserTest {

    @Test
    public void testQuerycodition(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
//        user.setName("一灯");
////        user.setPassword("abc");
        user.setAge(44);

        List<User> userByCondition = mapper.findUserByCondition(user);
        System.out.println("userByCondition = " + userByCondition);

        Long userByConditionUserCount = mapper.findUserByConditionUserCount(user);

        System.out.println("统计条件查询的数据之和 = " + userByConditionUserCount);

        MybatisUtils.close(sqlSession);

    }


    /**
     * 测试条件更新
     */
    @Test
    public void testUpdate(){

        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName("黄蓉");
        user.setPassword("1234");
        user.setAge(44);
        user.setId(7);

        int row= mapper.updateUserByNotNUll(user);

        System.out.println("row = " + row);
        MybatisUtils.close(sqlSession);

    }

    /**
     *  批量删除
     */
    @Test
    public void testDelete(){

        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> list = Arrays.asList(1, 2, 5);
        int row = mapper.deleteBatchByid(list);
        System.out.println("row = " + row);
        MybatisUtils.close(sqlSession);

    }

    @Test
    public void testinserusers(){

        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u1 = new User();
        u1.setName("天山童姥");
        u1.setPassword("111");
        u1.setAge(45);

        User u2 = new User();
        u2.setName("李秋水");
        u2.setPassword("111");
        u2.setAge(44);
        List<User> users = Arrays.asList(u1, u2);

        int i = mapper.insertUsers(users);
        System.out.println("i = " + i);
    }
}
