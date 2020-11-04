package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-11-04 11:31
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class User {
    private String name;
    private String pwd;

    // role  角色
    //  1  普通用户       只能访问user
    //  2  管理员用户      能访问 user / admin
    private int role;

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
