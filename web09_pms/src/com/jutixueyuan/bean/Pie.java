package com.jutixueyuan.bean;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-06 10:27
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  饼状图的数据的封装
 */
public class Pie {

    private String title;
    private List<String> legends;

    private List<Bean> datas;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLegends() {
        return legends;
    }

    public void setLegends(List<String> legends) {
        this.legends = legends;
    }

    public List<Bean> getDatas() {
        return datas;
    }

    public void setDatas(List<Bean> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Pie{" +
                "title='" + title + '\'' +
                ", legends=" + legends +
                ", datas=" + datas +
                '}';
    }

    public Pie(String title, List<String> legends, List<Bean> datas) {
        this.title = title;
        this.legends = legends;
        this.datas = datas;
    }

    public Pie() {
    }
}
