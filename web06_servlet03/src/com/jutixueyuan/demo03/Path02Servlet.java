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
 *   重定向的客户端路径: /项目访问路径/访问资源
 *
 */
@WebServlet("/path02")
public class Path02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 重定向的路径   /项目访问路径/访问资源
        resp.sendRedirect("/web06/page/a.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
