package com.jutixueyuan.controller;

import com.alibaba.fastjson.JSON;
import com.jutixueyuan.bean.Bean;
import com.jutixueyuan.bean.Data;
import com.jutixueyuan.bean.Pie;
import com.jutixueyuan.bean.User;
import com.jutixueyuan.service.RoomService;
import com.jutixueyuan.service.UserService;
import com.jutixueyuan.service.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-06 9:41
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   报表回写数据
 */
@WebServlet("/data")
public class EchartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");
        if (method.length() > 0 && method != null){

            if (method.equals("demo01")){
                 demo01(req,resp);
            }

            if (method.equals("demo02")){
                demo02(req,resp);
            }
        }

    }

    /**
     *  给报表回写数据
     * @param req
     * @param resp
     */
    private void demo02(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 组装数据
        Pie pie = new Pie();
        pie.setTitle("房屋出租情况");

        List<String> legend = Arrays.asList("已出租", "未出租");
        pie.setLegends(legend);

        // b1 以出租从数据   从数据库查询
        RoomService roomService = new RoomServiceImpl();
        int roomStatus1 = roomService.findRoomStatus(1);
        Bean b1 = new Bean(legend.get(0), roomStatus1);

        // b2 未出租从数据
        int roomStatus0 = roomService.findRoomStatus(0);
        Bean b2 = new Bean(legend.get(1), roomStatus0);

        List<Bean> bs = Arrays.asList(b1, b2);

        pie.setDatas(bs);
        // 02 回写数据
        resp.getWriter().write(JSON.toJSONString(pie));
    }

    /**
     *  给报表回写数据
     * @param req
     * @param resp
     */
    private void demo01(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 组装数据
        Data data = new Data();
        data.setTitle("双十一班级采购");

        List<String> names = Arrays.asList("键盘", "鼠标", "笔记本", "电脑支架", "电脑桌");
        data.setNames(names);

        List<Integer> nums = Arrays.asList(20, 15, 30, 30, 20);
        data.setNums(nums);
        // 02 回写数据
        resp.getWriter().write(JSON.toJSONString(data));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
