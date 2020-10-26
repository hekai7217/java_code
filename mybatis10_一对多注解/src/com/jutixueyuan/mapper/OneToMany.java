package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.Dept;
import com.jutixueyuan.bean.Emp;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-13 14:22
 * @ desc 百战程序员 http://www.jutixueyuan.com
 *    一对多的 mapper接口
 *     一个部门多个员工(基于注解来实现)
 *
 *
 */
public interface OneToMany {

    // 返回的是 dept (一个dept中有多个 emp对象)

    // 注解开发 一对多的操作  Java的注解没有循环操作
    // 使用注解的操作: 01  查询dept 数据  02 再次发送一条sql 查询 emp的数据  把emp的数据添加到 dept的集合属性中

    @Select("select * from dept where id = #{id}")
    @Results({

            // 基本的属性 id/name 的映射配置
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
//            配置 emp的属性  需要 再次发送一条sql查询 emp的数据
            @Result(column = "id",property = "emps",
               many = @Many(select = "findEmpByDeptId") //
                    // @many 一对多的映射    select 配置 查询的sql的id  需要发次sql查询emp的数据 自己写
            )
    })
    Dept findDeptById(Integer id);

    // 查询的结果  赋值给 dept的 emps的属性中
    @Select("select * from emp where dept_id = #{dpetId}")
    List<Emp> findEmpByDeptId(Integer dpetId);
}
