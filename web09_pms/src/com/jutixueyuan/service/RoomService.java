package com.jutixueyuan.service;

import com.jutixueyuan.bean.Build;
import com.jutixueyuan.bean.Floor;
import com.jutixueyuan.bean.Room;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-04 16:34
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public interface RoomService {

    List<Build> findBuild();

    List<Floor> findFloor(int bid);

    List<Room> findRoom(int fid);

    // 统计 房屋的 以出租/未出租
    int findRoomStatus(int status);
}
