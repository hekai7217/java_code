package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-10-28 17:04
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class Stu {

    private String name;
    private String info;
    private Integer age;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stu() {
    }

    public Stu(String name, String info, Integer age, Integer id) {
        this.name = name;
        this.info = info;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
