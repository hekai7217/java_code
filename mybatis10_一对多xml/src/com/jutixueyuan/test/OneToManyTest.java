package com.jutixueyuan.test;

import com.jutixueyuan.bean.Dept;
import com.jutixueyuan.mapper.OneToMany;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 黄药师
 * @date 2020-10-13 14:36
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class OneToManyTest {

    @Test
    public void test(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OneToMany mapper = sqlSession.getMapper(OneToMany.class);
        Dept dept = mapper.findDeptById(1);
        System.out.println("dept = " + dept);
    }

}
