package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.Dept;
import com.jutixueyuan.bean.Emp;

/**
 * @author 黄药师
 * @date 2020-10-13 14:22
 * @ desc 百战程序员 http://www.jutixueyuan.com
 *    一对多的 mapper接口
 *     一个部门多个员工
 *
 */
public interface OneToMany {

    // 返回的是 dept (一个dept中有多个 emp对象)
    Dept findDeptById(Integer id);

}
