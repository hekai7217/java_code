package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-10-26 16:59
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class User {

    private String name;
    private String pwd;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }

    public User(String name, String pwd, Integer age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }
}
