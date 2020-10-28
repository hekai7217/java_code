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
@WebServlet( "/delStu")
public class DelStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取数据
        String id = request.getParameter("id");
        System.out.println("id = " + id);

        // 调用service
        StuService stuService = new StuServiceImpl();

        boolean flag = stuService.delStu(Integer.parseInt(id));

        if (flag){ // 删除成功
            // 重定向 查询所有的学生
            response.sendRedirect("/web07/queryStus");
        }

    }
}
