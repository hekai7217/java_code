package com.jutixueyuan.bean;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-06 9:39
 * @desc 百战 程序员 http://www.jutixueyuan.com
 *
 *   报表要展示的数据
 *
 *
 */
public class Data {

    private String title;

    private List<String> names;
    private List<Integer> nums;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }

    public Data() {
    }

    public Data(String title, List<String> names, List<Integer> nums) {
        this.title = title;
        this.names = names;
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "Data{" +
                "title='" + title + '\'' +
                ", names=" + names +
                ", nums=" + nums +
                '}';
    }
}
