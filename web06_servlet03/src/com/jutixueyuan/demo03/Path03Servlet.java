package com.jutixueyuan.demo03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-27 14:21
 * @desc 百战程序员 http://www.jutixueyuan.com
 *     转发: 服务器的内部操作
 *        / 相对路径  当前的项目下面的相对路径
 *
 */
@WebServlet("/path03")
public class Path03Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求转发
        req.getRequestDispatcher("/page/a.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
