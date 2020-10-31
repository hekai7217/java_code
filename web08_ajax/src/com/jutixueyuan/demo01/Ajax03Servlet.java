package com.jutixueyuan.demo01;

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
 *  测试ajax的同步和异步
 */
@WebServlet("/ajax03")
public class Ajax03Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 给ajax 回写一个数据
        System.out.println("ajax过啦了...");


        // 默认 服务器的耗时操作
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        response.getWriter().write("hello ajax async...");

    }
}
