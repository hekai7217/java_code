package com.jutixueyuan.controller;

import com.jutixueyuan.bean.Stu;
import com.jutixueyuan.service.StuService;
import com.jutixueyuan.service.impl.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-28 17:02
 * @desc 百战程序员 http://www.jutixueyuan.com
 *  查询所有的学生的servlet
 */
@WebServlet( "/queryStus")
public class QueryStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 调用service
        StuService stuService = new StuServiceImpl();
        List<Stu> stus = stuService.queryStus();

        // 判断 转发jsp 页面展示数据
        if (stus.size() > 0 ){

            // 设置数据
            request.setAttribute("stus",stus);
            // 转发
            request.getRequestDispatcher("/stu/stus.jsp").forward(request,response);
        }

    }
}
