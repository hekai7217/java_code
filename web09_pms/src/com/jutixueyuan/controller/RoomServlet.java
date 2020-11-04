package com.jutixueyuan.controller;

import com.alibaba.fastjson.JSON;
import com.jutixueyuan.bean.Build;
import com.jutixueyuan.bean.Floor;
import com.jutixueyuan.bean.Room;
import com.jutixueyuan.service.RoomService;
import com.jutixueyuan.service.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-04 16:30
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet("/room")
public class RoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String method = request.getParameter("method");

        if (method != null && method.length() > 0) {

            // 查询 build
            if (method.equals("findBuild")) {
                findBuild(request, response);
            }
            // 查询 floor
            if (method.equals("findFloor")) {
                findFloor(request, response);
            }
            // 查询 room
            if (method.equals("findRoom")) {
                findRoom(request, response);
            }
        }

    }

    /**
     *  查询room
     * @param request
     * @param response
     */
    private void findRoom(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        //01 获取数据
        String fid = request.getParameter("fid");

        // 02  调用service
        RoomService roomService = new RoomServiceImpl();
        List<Room> rs = roomService.findRoom(Integer.parseInt(fid));
        // 03 回写数据
        response.getWriter().write(JSON.toJSONString(rs));

    }

    /**
     *  查询楼层
     * @param request
     * @param response
     */
    private void findFloor(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        //01 获取数据
        String bid = request.getParameter("bid");

        // 02  调用service
        RoomService roomService = new RoomServiceImpl();
        List<Floor> build = roomService.findFloor(Integer.parseInt(bid));
        // 03 回写数据
        response.getWriter().write(JSON.toJSONString(build));

    }

    /**
     * 查询 build
     * @param request
     * @param response
     */
    private void findBuild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //01 获取数据

        // 02  调用service
        RoomService roomService = new RoomServiceImpl();
        List<Build> build = roomService.findBuild();
        // 03 回写数据
        response.getWriter().write(JSON.toJSONString(build));
    }
}
