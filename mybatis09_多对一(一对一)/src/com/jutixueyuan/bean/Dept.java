package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-10-13 14:18
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   部门表对应的java对象
 */
public class Dept {

    private Integer id;
    private String name;

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
                '}';
    }
}
