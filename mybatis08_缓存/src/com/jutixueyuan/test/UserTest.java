package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


/**
 * @author 黄药师
 * @date 2020-10-12 17:32
 * @desc 百战程序员 http://www.jutixueyuan.com
 * 测试缓存
 */
public class UserTest {

    /**
     * 一级缓存: 了解
     * 在通一个 sqlSession中 查询统一条数据  如果sqlsession 关闭 会存在 sqlSession 缓存中
     * <p>
     * User userById = mapper.findUserById(7);
     * System.out.println("userById = " + userById);
     * <p>
     * User u2 = mapper.findUserById(7);
     * System.out.println("u2 = " + u2);
     * 查询2 次 , 第一次查询 存到缓存中
     * 第二次查询  从缓存中获取
     * <p>
     * 只给Db发送一次sql
     * 一级缓存 mybatis 是自动开启;
     * <p>
     * 缓存清理:
     * 01 sqlSession 缓存会清理掉
     * 02 缓存只能用于查询  如果是update 操作 清理缓存
     * 03 可以手动清理
     * clearCache()
     * 如果没有缓存 会查询2,数据库发送2次sql
     */
    @Test
    public void testQuery01() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userById = mapper.findUserById(7);
        System.out.println("userById = " + userById);

        //手动清理
        sqlSession.clearCache();

        User u2 = mapper.findUserById(7);
        System.out.println("u2 = " + u2);

        MybatisUtils.close(sqlSession);

    }

    /**
     * 测试二级缓存
     * 二级缓存需要手动开启
     * 01 javabean对象需要 序列化
     * Serializable
     * 02 配置cache 标签
     */
    @Test
    public void testQuery02() {

        // 二级缓存
        /*
         *
         * 二级缓存属于 SqlSessionFactory工厂级别
         *
         * 一个SqlSessionFactory可以创建多个SqlSession
         *
         * 实际开发中，项目部署到Tomcat中，服务器中也只有一个SqlSessionFactory
         *
         * 服务没有关闭，缓存到工厂的数据一致存在
         *
         * 无论多少个SqlSession 对象访问都是缓存的数据
         *
         * 缓存命中率
         *   缓存中获取数据的次数/总的请求次数 = xxx%
         *   命中率越高越好
         *   9次从缓存中获取/10次总的查询数据次数 = 90% 命中率
         *
         * 查看缓存的操作:
         *   01 查看 给数据库发送了几次sql  如果只 发送了一次, 后面的查询肯定是重缓存中获取
         *   02 查看缓存中 命中率
         */
        for (int i = 0; i < 10; i++) {
            // 1.创建SqlSession会话对象（每次增删改查都必须有）
            SqlSession session =MybatisUtils.getSqlSession();
            // 2.创建UserMapper映射接口的代理对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            // 3.执行UserMapper接口的单行查询方法方法
            User user = userMapper.findUserById(8);
            System.out.println("user :" + user);
            // 4.关闭session对象
            session.close();
        }
    }
}
