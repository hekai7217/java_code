package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-10-10 17:10
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   测试驼峰 命名的配置
 */
public class BeanUser {

    private Integer uId;

    private String uName;

    private String uPwd;

    private String uAGe;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuAGe() {
        return uAGe;
    }

    public void setuAGe(String uAGe) {
        this.uAGe = uAGe;
    }

    @Override
    public String toString() {
        return "BenUser{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uAGe='" + uAGe + '\'' +
                '}';
    }
}
