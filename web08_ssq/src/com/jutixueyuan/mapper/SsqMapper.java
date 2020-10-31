package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-31 9:43
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public interface SsqMapper {

    // 查询 省
    @Select("select * from area where parentid = 0")
    List<Area> findProvince();

    // 查询市
    @Select("select * from area where parentid = #{pid}")
    List<Area> findCity(Integer pid);

    //查询区
    @Select("select * from area where parentid= #{cid}")
    List<Area> findTown(Integer cid);

}
