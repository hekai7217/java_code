package com.jutixueyuan.bean;

/**
 * @author 黄药师
 * @date 2020-11-04 16:36
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class Room {

    private Integer id;
    private Integer roomtype;
    private String roomname;
    private String roomnum;
    private Double roomarea;
    private Integer status;
    private Integer floor_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public Double getRoomarea() {
        return roomarea;
    }

    public void setRoomarea(Double roomarea) {
        this.roomarea = roomarea;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(Integer floor_id) {
        this.floor_id = floor_id;
    }

    public Room() {
    }

    public Room(Integer id, Integer roomtype, String roomname, String roomnum, double roomarea, Integer status, Integer floor_id) {
        this.id = id;
        this.roomtype = roomtype;
        this.roomname = roomname;
        this.roomnum = roomnum;
        this.roomarea = roomarea;
        this.status = status;
        this.floor_id = floor_id;
    }

    @Override
    public String toString() {
        return "Room [id=" + id + ", roomtype=" + roomtype + ", roomname=" + roomname + ", roomnum=" + roomnum
                + ", roomarea=" + roomarea + ", status=" + status + ", floor_id=" + floor_id + "]";
    }

}
