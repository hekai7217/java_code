package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
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
 *
 *    mybatis的开发步骤:
 *     01 导入 mybatis 的jar
 *        mybatis.jar
 *        驱动jar
 *
 *     02 创建一个配置文件
 *         数据库连接的配置
 *           配置文件的名称可以随便写,mybatis-config.xml
 *            这个配置文件有要求:
 *
 *         配置 xxMapper.xml
 *
 *     03 数据库创建一个表 测试mybatis使用
 *
 *     04 usermapper 接口写好了
 *     05 usermapper 接口只有方法 (sql 写在哪里?)写一个
 *        UserMapper.xml 文件 和 usermapper 接口要进行映射
 *
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
 */
public class HelloTest {

    @Test
    public void helloworld() throws IOException {

        // 获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        // Resources 资源读取 mybati提供读取资源的 工具类型
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取sqlsession 的工厂类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 提供了方法 获取 sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //  sqlSession 获取的mapper 是mybatis 进行了动态代理后 的mapper 对象
        //这个动态代理的 mapper 实现了   接口中的方法的操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName("scott");
        user.setPassword("123");
        user.setAge(20);

        //调用方法
        int i = mapper.insertUserInfo(user);
        System.out.println("i = " + i);
        System.out.println(i > 0 ? "成功":"失败");

        // mybatis 默认 不能自动提交事务 需要手动提交
        sqlSession.commit();

        // 释放资源
        if (sqlSession != null){
            sqlSession.close();
        }
    }

}
