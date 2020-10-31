package com.jutixueyuan.service.impl;

import com.jutixueyuan.bean.Area;
import com.jutixueyuan.mapper.SsqMapper;
import com.jutixueyuan.service.SSqService;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-31 9:43
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class SSqServiceImpl implements SSqService {
    @Override
    public List<Area> findProvince() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SsqMapper mapper = sqlSession.getMapper(SsqMapper.class);
        List<Area> province = mapper.findProvince();
        MybatisUtils.close(sqlSession);
        return province;
    }

    @Override
    public List<Area> findCity(Integer pid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SsqMapper mapper = sqlSession.getMapper(SsqMapper.class);
        List<Area> province = mapper.findCity(pid);
        MybatisUtils.close(sqlSession);
        return province;
    }

    @Override
    public List<Area> findTown(Integer cid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SsqMapper mapper = sqlSession.getMapper(SsqMapper.class);
        List<Area> province = mapper.findTown(cid);
        MybatisUtils.close(sqlSession);
        return province;
    }
}
