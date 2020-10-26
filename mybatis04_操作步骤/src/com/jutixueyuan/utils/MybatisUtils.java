package com.jutixueyuan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 黄药师
 * @date 2020-10-10 10:13
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  封装 mybatis 获取sqlSession
 *
 *     SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域
 *
 *     SqlSessionFactory 的最佳作用域是应用作用域 最好单列
 *        静态代码块初始化 可以实现单例 (jvm 帮我们实现的)
 *
 *    SqlSession 这个作用域放在方法中 为了安全
 *        SqlSession 用完了需要关闭, 写在 finally 中
 *
 *       关闭 sqlsession:
 *       01
 *       try (SqlSession session = sqlSessionFactory.openSession()) {
 *        // 你的应用逻辑代码
 *       }    java 版本 1.7 写法 会默认关闭 资源  io操作也可以这么写关闭资源
 *
 *       02  单独的写一个方法  自己手动关闭
 *
 *         public static void close(SqlSession sqlSession){
 *         if (sqlSession != null) {
 *             sqlSession.close();
 *         }
 *     }
 *
 */
public class MybatisUtils {

    private static  SqlSessionFactory sqlSessionFactory = null;

    // config 的文件的读取 最好只 加载一次
    // 解决 可以在static 代码块中 加载
    static{

        String resource = "mybatis-config.xml";
        // Resources 资源读取 mybati提供读取资源的 工具类型
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取sqlsession 的工厂类
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    // sqlSessionFactory 先获取这个  sqlSessionFactory

    /**
     *  获取sqlSession
     * @return
     */
    public static SqlSession getSqlSession(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;

    }

    /**
     *  可以 一个sqlSession 自动提交事务
     *     修改操作 使用提交事务的sqlSession
     * @return
     */
    public static SqlSession getSqlSession(boolean autoCommit){

        SqlSession sqlSession = sqlSessionFactory.openSession(autoCommit);

        return sqlSession;

    }

    /**
     * 关闭 sqlSqlSession
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
