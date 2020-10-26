package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author 黄药师
 * @date 2020-10-12 11:33
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   多参数的 处理
 */
public class ParamsTest {

    @Test
    public void testQuery(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        User user = mapper.userfindOne01("乔峰", "123");
        System.out.println("user = " + user);

    }

    // 测试多参数的 对象的封装
    @Test
    public void testQuery2(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        User user1 = new User();
        user1.setName("乔峰");
        user1.setPassword("123");
        User user = mapper.userfindOne02(user1);
        System.out.println("user = " + user);

    }

    // 测试多参数的 map的封装
    @Test
    public void testQuery3(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        HashMap<String,Object> map = new HashMap();

        // map的key 要和sql中#{xxx}的一致
        map.put("name","乔峰");
        map.put("password","123");
        User user = mapper.userfindOne03(map);
        System.out.println("user = " + user);

    }

    // 测试多参数的 @param注解
    @Test
    public void testQuery4(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.userfindOne04("乔峰","123");
        System.out.println("user = " + user);

    }

    /**
     *  测试 # 和 $ 符号
     */
    @Test
    public void testQuery5(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectUser(1);
        System.out.println("user = " + user);


    }
}
