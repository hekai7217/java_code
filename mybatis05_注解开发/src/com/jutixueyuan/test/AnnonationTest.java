package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-12 10:23
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   测试注解开发
 *     操作步骤:
 *       01 在mapper接口中的具体的方法上使用 @Select
 *       02 在config.xml 中配置 解耦
 *       03 测试
 */
public class AnnonationTest {
    
    @Test
    public void testSelect(){
        
        // 获取sqlsession 

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User user = mapper.selectUserById(1);
        System.out.println("user = " + user);
        //释放资源
        MybatisUtils.close(sqlSession);

    }

    /**
     * 放回的结果集的字段和 java的属性名称不一致
     */
    @Test
    public void testSelect02(){

        // 获取sqlsession

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User user = mapper.selectUserPrimaryById(1);
        System.out.println("user = " + user);
        //释放资源
        MybatisUtils.close(sqlSession);

    }

    /**
     * 查询的返回结果是  集合
     */
    @Test
    public void testSelect03(){

        // 获取sqlsession

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用方法

        List<User> allUsers = mapper.findAllUsers();
        System.out.println("allUsers = " + allUsers);

        MybatisUtils.close(sqlSession);

    }


    /**
     *  添加操作测试
     */
    @Test
    public void testInsert(){

        // 获取sqlsession

        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用方法

        User user = new User();
        user.setName("黄药师");
        user.setPassword("123");
        user.setAge(67);

        System.out.println(" 添加之前:user = " + user);
        int i = mapper.insertUser(user);
        System.out.println("i = " + i);

        System.out.println(" 添加之后的:user = " + user);
        MybatisUtils.close(sqlSession);

    }

    /**
     * 测试修改的注解
     */
    @Test
    public void testUpdate(){

        // 获取sqlsession

        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User user = new User();
        user.setName("一灯");
        user.setPassword("123");
        user.setAge(70);
        user.setId(7);

        int i = mapper.updateUser(user);
        System.out.println(i);

        MybatisUtils.close(sqlSession);

    }

    /**
     * 测试修改的注解
     */
    @Test
    public void testDelete(){

        // 获取sqlsession

        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用方法

        int i = mapper.delUserByid(6);
        System.out.println(i);

        MybatisUtils.close(sqlSession);

    }

}
