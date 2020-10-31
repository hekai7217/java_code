package com.jutixueyuan.service;

import com.jutixueyuan.bean.Area;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-31 9:41
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public interface SSqService {

    // 查询 省
    List<Area> findProvince();

    // 查询市
    List<Area> findCity(Integer pid);

    //查询区
    List<Area> findTown(Integer cid);

}
