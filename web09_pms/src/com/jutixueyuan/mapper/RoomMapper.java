package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.Build;
import com.jutixueyuan.bean.Floor;
import com.jutixueyuan.bean.Room;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-04 16:37
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public interface RoomMapper {

    @Select("select * from t_build")
    List<Build> findBuild();

    // 查询 楼层
    @Select("select * from t_floor where build_id = #{bid}")
    List<Floor> findFloor(int bid);

    //查询房间
    @Select("select * from t_room where floor_id = #{fid}")
    List<Room> findRoom(int fid);
}
