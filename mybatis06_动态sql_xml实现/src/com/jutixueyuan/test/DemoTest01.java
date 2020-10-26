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
 * @date 2020-10-12 14:35
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   测试动态的sql
 *
 */
public class DemoTest01 {

    // user的 条件查询
    @Test
    public void test01(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 把查询user的 条件封装到u对象中
        // sql: select * from user WHERE age = ?
//        User user = new User();
//        // sql中只有 一个age = 25 的条件
//        user.setAge(25);
//        // 查询 user都是 25
//        List<User> us = mapper.findUserByCondition(user);
//        System.out.println("us = " + us);

        //如果 user有多个条件
        // 查看动态的sql语句 : select * from user WHERE name = ? or age = ?
        User user = new User();
        // sql中只有 一个age = 25 的条件
        user.setAge(25);
        user.setName("花");
        // 查询 user都是 25
        List<User> us = mapper.findUserByCondition(user);

        //条件查询的统计操作
        Long userByConditionUserCount = mapper.findUserByConditionUserCount(user);
        System.out.println("userByConditionUserCount = " + userByConditionUserCount);

        System.out.println("us = " + us);

    }

    @Test
    public void testUpdate(){

        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();

        // 动态的sql更新
        // 只 更新 age/name  如果属性为null 不更新
        //更新的动态sql: update user SET name = ?, age = ? where id = ?
        user.setAge(30);
        user.setName("郭啸天");
        user.setId(4);

        int i = mapper.updateUserByNotNUll(user);
        System.out.println("i = " + i);
        MybatisUtils.close(sqlSession);

    }


    @Test
    public void testDeleteBatchIds(){

        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        List<Integer> list = Arrays.asList(1, 20, 30);
//        int i = mapper.deleteBatchByid(list);
//        System.out.println("i = " + i);
//        MybatisUtils.close(sqlSession);

        List<Integer> ids = Arrays.asList(1, 2, 3);
        List<User> users = mapper.selectUserByIds(ids);
        System.out.println("users = " + users);
        MybatisUtils.close(sqlSession);
    }

    @Test
    public void testInseruser(){

        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u1 = new User();
        u1.setName("段正淳");
        u1.setPassword("111");
        u1.setAge(45);

        User u2 = new User();
        u2.setName("白刀凤");
        u2.setPassword("111");
        u2.setAge(44);

        List<User> users = Arrays.asList(u1, u2);
        int i = mapper.inserUsers(users);
        System.out.println("i = " + i);
        MybatisUtils.close(sqlSession);
    }
}
