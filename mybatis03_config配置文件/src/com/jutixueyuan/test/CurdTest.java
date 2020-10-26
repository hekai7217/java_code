package com.jutixueyuan.test;

import com.jutixueyuan.bean.BeanUser;
import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.BeanUserMapper;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-10 14:20
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *
 *
 */
public class CurdTest {
    
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

        User u = mapper.findUserById(1);
        System.out.println("u = " + u);
        // 关闭资源
        MybatisUtils.close(sqlSession);
    }

    /**
     * 测试驼峰命名
     */
    @Test
    public void testQuery(){

        // 获取 sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 获取mapper
        BeanUserMapper mapper = sqlSession.getMapper(BeanUserMapper.class);
        BeanUser beanUser = mapper.findBeanUser(1);
        System.out.println("beanUser = " + beanUser);

    }
}
