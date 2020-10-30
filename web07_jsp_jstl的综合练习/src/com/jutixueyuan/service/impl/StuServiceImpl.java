package com.jutixueyuan.service.impl;

import com.jutixueyuan.bean.Stu;
import com.jutixueyuan.mapper.StuMapper;
import com.jutixueyuan.service.StuService;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.text.Style;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-28 17:05
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class StuServiceImpl implements StuService {

    @Override
    public List<Stu> queryStus() {

        // 01 获取sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 02 获取mapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        // 03 获取 调用方法
        List<Stu> stus = mapper.queryStus();
        // 04 关闭资源
        MybatisUtils.close(sqlSession);
        return stus;
    }

    @Override
    public boolean delStu(int id) {
        // 01 获取sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 02 获取mapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        // 03 获取 调用方法
        int i = mapper.delStu(id);
        sqlSession.commit();
        MybatisUtils.close(sqlSession);
        return i > 0 ;
    }

    @Override
    public boolean addStu(Stu stu) {

        // 01 获取sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 02 获取mapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        // 03 获取 调用方法
        int i = mapper.addStu(stu);
        sqlSession.commit();
        MybatisUtils.close(sqlSession);

        return i > 0 ;
    }

    @Override
    public Stu findStuById(int id) {

        // 01 获取sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 02 获取mapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        // 03 获取 调用方法
        Stu stu = mapper.findStuById(id);
        // 04 关闭资源
        MybatisUtils.close(sqlSession);

        return stu;
    }

    @Override
    public boolean updateStu(Stu stu) {

        // 01 获取sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 02 获取mapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        // 03 获取 调用方法
        int i = mapper.updateStu(stu);
        sqlSession.commit();
        MybatisUtils.close(sqlSession);

        return i > 0 ;
    }


}
