package com.jutixueyuan.demo01;

import jdk.nashorn.internal.runtime.RewriteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-30 10:43
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet("/ajax01")
public class Ajax01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 给ajax 回写一个数据
        System.out.println("ajax过啦了...");

        response.getWriter().write("hello ajax...");

    }
}
