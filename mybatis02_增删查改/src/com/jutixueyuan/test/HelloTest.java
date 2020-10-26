package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 黄药师
 * @date 2020-10-09 16:29
 * @desc 百战程序员 http://www.itbaizhan.com
 *     06 写java代码进行测试
 *         01 读取配置文件
 *           Resources.getResourceAsStream(resource);  返回一个流
 *         02 通过配置文件
 *           new SqlSessionFactoryBuilder(config的流) 获取SqlSessionFactoryBuilder 对象
 *           SqlSessionFactoryBuilder 通过 获取 SqlSessionFactory 工厂对象
 *         03    SqlSessionFactory 工厂获取 sqlsession
 *
 *         04    通过 sqlsession 获取mapper代理对象
 *
 *         05   通过 代理对象直接调用方法  拿到sql执行的结果
 *
 *         06 释放资源
 *
 */
public class HelloTest {

    @Test
    public void helloworld() throws IOException {

//        // 获取 SqlSessionFactory
//        String resource = "mybatis-config.xml";
//        // Resources 资源读取 mybati提供读取资源的 工具类型
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//
//        // 获取sqlsession 的工厂类
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        // 提供了方法 获取 sqlsession
//        SqlSession sqlSession = sqlSessionFactory.openSession();

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //  sqlSession 获取的mapper 是mybatis 进行了动态代理后 的mapper 对象
        //这个动态代理的 mapper 实现了   接口中的方法的操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User user = mapper.selectUserById(1);
        System.out.println("user = " + user);

        // 释放资源
//        if (sqlSession != null){
//            sqlSession.close();
//        }
        MybatisUtils.close(sqlSession);
    }

    @Test
    public void select() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //  sqlSession 获取的mapper 是mybatis 进行了动态代理后 的mapper 对象
        //这个动态代理的 mapper 实现了   接口中的方法的操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用方法
        User user = mapper.selectUserById(1);
        System.out.println("user = " + user);

        MybatisUtils.close(sqlSession);
    }

    @Test
    public void testaa(){

        System.out.println("HelloTest.testaa");

    }

}
