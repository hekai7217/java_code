package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.Stu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Insert("insert into t_stu values(default ,#{name},#{age},#{info})")
    int addStu(Stu stu);

    //通过id查询stu
    @Select("select * from t_stu where id = #{id}")
    Stu findStuById(int id);

    // 更新的stu
    @Update("update t_stu set name = #{name},age = #{age},info = #{info} where id = #{id}")
    int updateStu(Stu stu);
}
