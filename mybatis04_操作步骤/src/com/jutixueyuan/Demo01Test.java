package com.jutixueyuan;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-12 9:35
 * @desc 百战程序员 http://www.jutixueyuan.com
 * 
 *  测试 mapper 的接口方法 
 * 
 */
public class Demo01Test {
    
    @Test
    public void test(){

        // 获取sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 获取mapper对象 (代理后的对象 实现了接口中的sql的方法)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用方法
        User user = mapper.selectUserById(1);

        System.out.println("user = " + user);
        //释放资源
        MybatisUtils.close(sqlSession);


    }
    
}
