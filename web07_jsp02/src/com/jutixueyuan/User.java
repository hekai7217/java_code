package com.jutixueyuan;

/**
 * @author 黄药师
 * @date 2020-10-27 17:13
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class User {


    private String name;
    private String pwd;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}
