package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-11-04 16:35
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class Floor {

    private Integer id;
    private String floorname;
    private Double floorarea;
    private Integer build_id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFloorname() {
        return floorname;
    }
    public void setFloorname(String floorname) {
        this.floorname = floorname;
    }
    public Double getFloorarea() {
        return floorarea;
    }
    public void setFloorarea(Double floorarea) {
        this.floorarea = floorarea;
    }
    public Integer getBuild_id() {
        return build_id;
    }
    public void setBuild_id(Integer build_id) {
        this.build_id = build_id;
    }

    public Floor() {
        // TODO Auto-generated constructor stub
    }
    public Floor(Integer id, String floorname, Double floorarea, Integer build_id) {
        this.floorname = floorname;
        this.floorarea = floorarea;
        this.build_id = build_id;
    }
    @Override
    public String toString() {
        return "Floor [id=" + id + ", floorname=" + floorname + ", floorarea=" + floorarea + ", build_id=" + build_id
                + "]";
    }

}
