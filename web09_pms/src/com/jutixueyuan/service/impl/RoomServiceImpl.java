package com.jutixueyuan.service.impl;

import com.jutixueyuan.bean.Build;
import com.jutixueyuan.bean.Floor;
import com.jutixueyuan.bean.Room;
import com.jutixueyuan.mapper.RoomMapper;
import com.jutixueyuan.service.RoomService;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-04 16:36
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class RoomServiceImpl implements RoomService {


    @Override
    public List<Build> findBuild() {

        // 01 拿到 sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 02 拿到mapper
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        // 03 调用方法
        List<Build> build = mapper.findBuild();
        // 04 关闭资源
        MybatisUtils.close(sqlSession);

        return build;
    }

    @Override
    public List<Floor> findFloor(int bid) {
        // 01 拿到 sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 02 拿到mapper
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        // 03 调用方法
        List<Floor> fs = mapper.findFloor(bid);
        // 04 关闭资源
        MybatisUtils.close(sqlSession);

        return fs;

    }

    @Override
    public List<Room> findRoom(int fid) {

        // 01 拿到 sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 02 拿到mapper
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        // 03 调用方法
        List<Room> rs = mapper.findRoom(fid);
        // 04 关闭资源
        MybatisUtils.close(sqlSession);

        return rs;
    }
}
