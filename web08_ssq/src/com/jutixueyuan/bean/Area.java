package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-10-31 9:37
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class Area {

    private Integer areaId;
    private String areaName;
    private Integer parentid;
    private Integer arealevel;
    private Integer status;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getArealevel() {
        return arealevel;
    }

    public void setArealevel(Integer arealevel) {
        this.arealevel = arealevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Area(Integer areaId, String areaName, Integer parentid, Integer arealevel, Integer status) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.parentid = parentid;
        this.arealevel = arealevel;
        this.status = status;
    }

    public Area() {
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", parentid=" + parentid +
                ", arealevel=" + arealevel +
                ", status=" + status +
                '}';
    }
}

