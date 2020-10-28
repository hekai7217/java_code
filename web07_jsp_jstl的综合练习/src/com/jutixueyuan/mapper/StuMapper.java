package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.Stu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-28 17:06
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public interface StuMapper {

    @Select("select * from t_stu")
    List<Stu> queryStus();

    //删除
    @Delete(" delete from t_stu where id = #{id} ")
    int delStu(int id);

}
