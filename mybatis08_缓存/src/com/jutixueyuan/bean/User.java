package com.jutixueyuan.bean;

import java.io.Serializable;

/**
 * @author 黄药师
 * @date 2020-10-09 16:46
 * @desc 百战程序员 http://www.itbaizhan.com
 *  user对象 和数据库中 表单最好是字段 和 bean对象属性名称 一致
 */
public class User implements Serializable {


    private Integer id;
    private String name;
    private String password;
    private Integer age;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
    }

    public User(Integer id, String name, String password, Integer age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
