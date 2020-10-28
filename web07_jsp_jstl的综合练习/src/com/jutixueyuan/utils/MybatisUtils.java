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
 */
public class MybatisUtils {

    private static  SqlSessionFactory sqlSessionFactory = null;


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
