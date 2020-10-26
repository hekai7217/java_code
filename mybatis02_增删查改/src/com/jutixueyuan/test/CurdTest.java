package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-10 14:20
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  总结:
 *     mapper中基本标签
 *
 *       01 查询标签
 *           select  查询标签
 *               id           和mapper接口中的方法 一致
 *               parameterType   查询的条件的参数
 *               resultType   查询返回的结果 配置全限定名
 *               如果是返回的是多行:
 *                    resultType 配置的是集合的泛型
 *
 *       02 修改标签
 *            update/delete/insert
 *            id/parameterType  和查询标签一样
 *            2.1  修改操作 不用写 resultType 标签
 *            2.2  修改操作需要  提交事务 (mybatis默认不提交事务)
 *            2.3  标签不要 瞎写  查询中写update的标签
 *
 */
public class CurdTest {

    // 测试添加
    @Test
    public void testInsert(){

        // 获取 sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 调用方法
        User u = new User();
        u.setName("王语嫣");
        u.setPassword("1234");
        u.setAge(60);
        System.out.println("添加之前的对象: = " + u);
        int i = mapper.insertUser(u);

        System.out.println(i>0 ? "成功":"失败");
        //提交事务
        sqlSession.commit();

        System.out.println("添加之后的对象: = " +  u);
        // 关闭资源
        MybatisUtils.close(sqlSession);
    }

    // 删除

    /**
     *      sqlSession 默认是不会提交事务
     *         查询 不需要事务
     *         添加/ 修改 / 删除 需要手动提交事务
     */
    @Test
    public void testDelete(){

        // 获取 sqlSession (自动提交事务)
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUserById(6);

        System.out.println(i>0 ? "成功":"失败");
        // 关闭资源
        MybatisUtils.close(sqlSession);
    }

    /**
     * 测试修改
     */
    @Test
    public void testUpdate(){

        // 获取 sqlSession (自动提交事务)
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(8);
//        user.setName("黄药师");
        user.setPassword("1234");
        user.setAge(60);
        int i = mapper.updateUser(user);
        System.out.println(i>0 ? "成功":"失败");

        // 关闭资源
        MybatisUtils.close(sqlSession);
    }

    /**
     * 多行操作 查询所有:
     */
    @Test
    public void testQuery(){

        // 获取 sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findUser();
        System.out.println("users = " + users);
        // 关闭资源
        MybatisUtils.close(sqlSession);
    }

    /**
     *  测试查询 :
     *    返回的结果集 和  返回对象属性值不一致
     */
    @Test
    public void testQueryPrimarykey(){

        // 获取 sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectPrimarykeyById(1);
        System.out.println("user = " + user);

        // 关闭资源
        MybatisUtils.close(sqlSession);
    }
}
