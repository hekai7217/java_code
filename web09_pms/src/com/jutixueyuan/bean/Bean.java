package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-11-06 10:29
 * @desc 百战程序员 http://www.jutixueyuan.com
 */

public class Bean {
    private String name;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Bean() {
    }

    public Bean(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
