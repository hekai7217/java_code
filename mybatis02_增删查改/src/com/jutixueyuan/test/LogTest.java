package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-10 14:04
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  mybatis 整合 log4j  日志框架
 *    操作步骤:
 *     01  导入 log4j.jar
 *     02  添加配置文件  log4j.properties
 *
 *     日志的细节:
 *          可以控制某个类 或者包下面的所有的 日志输出
 *          log4j.logger.com.jutixueyuan.mapper.UserMapper=TRACE
 *      可以设置几个级别:
 *          log4j.rootLogger=ERROR 根部的级别配置 error 可以
 *              如果 root 别太低了 日志信息太多 不便于 程序日志查看
 *          log4j.logger.com.jutixueyuan.mapper.UserMapper=TRACE/Debug
 *              如果  mapper 配置的级别太高了 一些sql的信息都看不到 配置debug或者 trace
 *              Debug/TRACE
 *              dubug级别:
 *              DEBUG [main] - ==>  Preparing: select * from user where id = ?
                 * DEBUG [main] - ==> Parameters: 1(Integer)
                 * DEBUG [main] - <==      Total: 1
                 * user = User{id=1, name='乔峰', password='123', age=35}
 *
 *              TRACE
 *               DEBUG [main] - ==>  Preparing: select * from user where id = ?
                 * DEBUG [main] - ==> Parameters: 1(Integer)
                 * TRACE [main] - <==    Columns: id, name, password, age
                 * TRACE [main] - <==        Row: 1, 乔峰, 123, 35
                 * DEBUG [main] - <==      Total: 1
                 * user = User{id=1, name='乔峰', password='123', age=35}
 */
public class LogTest {

    @Test
    public void testlog(){

        // 获取 sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 调用方法
        User user = mapper.selectUserById(1);

        System.out.println("user = " + user);
        // 关闭资源
        MybatisUtils.close(sqlSession);
    }

}
