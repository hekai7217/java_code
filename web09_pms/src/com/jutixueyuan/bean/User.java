package com.jutixueyuan.bean;

import java.util.Date;

/**
 * @author 黄药师
 * @date 2020-10-31 16:58
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  对象 和 数据库的表的字段一致
 *
 */
public class User {

    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String email;
    private String qq;
    private String phone;
    private String img;
    private Date regtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public User(Integer id, String username, String password, String realname, String email, String qq, String phone, String img, Date regtime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.email = email;
        this.qq = qq;
        this.phone = phone;
        this.img = img;
        this.regtime = regtime;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", img='" + img + '\'' +
                ", regtime=" + regtime +
                '}';
    }
}
