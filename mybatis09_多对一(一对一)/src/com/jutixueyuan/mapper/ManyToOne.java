package com.jutixueyuan.mapper;

import com.jutixueyuan.bean.Emp;

/**
 * @author 黄药师
 * @date 2020-10-13 14:22
 * @ desc 百战程序员 http://www.jutixueyuan.com
 *    多对一的 mapper接口
 */
public interface ManyToOne {

    // 直接返回一个emp  (emp的内部有一个 dpet)
    Emp findEmpById(Integer id);
}
