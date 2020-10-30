package com.jutixueyuan.service;

import com.jutixueyuan.bean.Stu;
import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-28 17:03
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public interface StuService {

    List<Stu> queryStus();

    // 删除
    boolean delStu(int id);

    //添加 学生
    boolean addStu(Stu stu);

    //通过id查询stu
    Stu findStuById(int id);

    // 更新stu
    boolean updateStu(Stu stu);
}
