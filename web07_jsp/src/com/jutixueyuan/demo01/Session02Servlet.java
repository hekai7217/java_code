package com.jutixueyuan.demo01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author 黄药师
 * @date 2020-10-28 9:39
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   01 session 的获取
 *      req.getSession()  如果存在session,返回session,
 *                        如果不存在 创建session
 *
 *   02 session的域对象
 *        内部有有一个map 可以实现(多个servlet中可以)数据共享
 *          存储数据的方法
 *          setAttribute("key","value")
 *          getAttribute("key")
 */
@WebServlet("/session02")
public class Session02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 多次访问(没有关闭浏览器) 会话是同一个

        // 获取共享的数据
        // 01 获取session
        HttpSession session = req.getSession();
        // 02 从session中获取数据
        Object key1 = session.getAttribute("key1");
        System.out.println("key1 = " + key1);
        Object key2 = session.getAttribute("key2");
        System.out.println("key2 = " + key2);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
