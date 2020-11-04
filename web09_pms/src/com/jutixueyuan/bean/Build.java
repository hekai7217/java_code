package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-11-04 16:35
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class Build {

    private Integer id;
    private String buildnum;
    private String buildname;
    private String addr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildnum() {
        return buildnum;
    }

    public void setBuildnum(String buildnum) {
        this.buildnum = buildnum;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Build() {
    }

    public Build(Integer id, String buildnum, String buildname, String addr) {
        this.id = id;
        this.buildnum = buildnum;
        this.buildname = buildname;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Build [id=" + id + ", buildnum=" + buildnum + ", buildname=" + buildname + ", addr=" + addr + "]";
    }


}
