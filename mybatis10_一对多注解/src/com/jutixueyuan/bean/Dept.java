package com.jutixueyuan.bean;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-13 14:18
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   部门表对应的java对象
 *
 *   以部门为中心 : 一个部门多个员工
 *      java的对象依赖关系:
 *        Dept 中有多个emp   dept中有属性 List<Emp> emps
 *
 */
public class Dept {

    private Integer id;
    private String name;

    List<Emp> emps;

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emps=" + emps +
                '}';
    }
}
