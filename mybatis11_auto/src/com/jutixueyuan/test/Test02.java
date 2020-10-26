package com.jutixueyuan.test;

import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.pojo.User;
import com.jutixueyuan.pojo.UserExample;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-13 17:09
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   逆向工程的 条件查询对象的使用
 */
public class Test02 {

    @Test
    public void testQuery01(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByPrimaryKey(3);
        System.out.println("user = " + user);
        MybatisUtils.close(sqlSession);

    }

    /**
     * 条件查询
     */
    @Test
    public void testQuery02(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //创建条件对象 
        UserExample userExample = new UserExample();

        // 条件构造器 (提供了很多的条件的方法)
        UserExample.Criteria criteria = userExample.createCriteria();

        //条件1  查询  20 < age <30  
//        criteria.andAgeBetween(20,30);
        criteria.andAgeEqualTo(25);
        // 条件2  name = "虚竹"
        criteria.andNameEqualTo("虚竹");

        // 模糊查询
        criteria.andNameLike("%天%");

        List<User> users = mapper.selectByExample(userExample);
        System.out.println("users = " + users);
        MybatisUtils.close(sqlSession);

    }

    /**
     *  多个条件 默认是and 如果要用or 需要多个 Criteria
     */
    @Test
    public void testQuery03(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //创建条件对象
        UserExample userExample = new UserExample();

        // 条件构造器 (提供了很多的条件的方法)
        UserExample.Criteria criteria = userExample.createCriteria();

        // 条件1
        criteria.andAgeEqualTo(25);

        //条件2 如果直接写 条件是and

        // or 需要单独写一个单独条件构造器
        UserExample.Criteria criteria2 = userExample.createCriteria();
        criteria2.andNameLike("%天%");

        // 把 2个条件进行or关联
        userExample.or(criteria2);
        List<User> users = mapper.selectByExample(userExample);
        System.out.println("users = " + users);
        MybatisUtils.close(sqlSession);

    }

    /**
     *  测试新增自己写的mapper方法也是可以
     */
    @Test
    public void testQuery04(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.findUser(3);
        System.out.println("user = " + user);
        MybatisUtils.close(sqlSession);

    }

}
