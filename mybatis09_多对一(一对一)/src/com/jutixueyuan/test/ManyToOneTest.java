package com.jutixueyuan.test;

import com.jutixueyuan.bean.Emp;
import com.jutixueyuan.mapper.ManyToOne;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-13 14:36
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class ManyToOneTest {

    @Test
    public void test(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ManyToOne mapper = sqlSession.getMapper(ManyToOne.class);

        Emp emp = mapper.findEmpById(2);
        System.out.println("emp = " + emp);

    }

}
