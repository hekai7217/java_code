package com.jutixueyuan.demo01;

import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
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
@WebServlet("/session01")
public class Session01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 第一次访问  没有session 创建
        // 如果第二次访问 获取的session是同一个对象
        HttpSession session = req.getSession();
        System.out.println("session = " + session);

        //存储数据
        session.setAttribute("key1","s10决赛见");
        session.setAttribute("key2",new Date());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
