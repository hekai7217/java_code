package com.jutixueyuan.test;

import com.jutixueyuan.bean.Area;
import com.jutixueyuan.mapper.SsqMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-31 11:04
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class AreaTest {
    
    @Test
    public void testFindProvince(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SsqMapper mapper = sqlSession.getMapper(SsqMapper.class);
        List<Area> province = mapper.findProvince();
        MybatisUtils.close(sqlSession);
        System.out.println("province = " + province);
        
    }
    
}
