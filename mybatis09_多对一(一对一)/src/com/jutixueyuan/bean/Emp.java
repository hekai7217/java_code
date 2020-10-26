package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-10-13 14:19
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   以员工为中心:
 *      一个员工 对应一个部门
 *   java对象的依赖关系:
 *
 *      Emp对象中有 属性 Dept
 *
 */
public class Emp {

    private Integer id;
    private String name;

    // 通过java的依赖关系   表示 一对一的关系
    private Dept dept;

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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                '}';
    }
}
