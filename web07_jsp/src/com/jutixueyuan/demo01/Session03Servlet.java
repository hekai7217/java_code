package com.jutixueyuan.demo01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-28 9:39
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *      学了 3个域对象
 *
 *          Servletcontext  web应用创建一个servlet,在整个web中可以实现数据共享
 *          req        每次请求都有req对象, 在转发中实现数据共享
 *          HttpSession  一个会话中,多次请求 可以实现数据共享
 *
 *          比较3个域对象:
 *          01 生命周期:  Servletcontext > HttpSession > req
 *                    Servletcontext 太长,req 太短了, 数据共享推荐使用 HttpSession
 *          02 数据共享的范围: Servletcontext > HttpSession > req
 *                    Servletcontext 太大,req 太小, 数据共享范围推荐使用 HttpSession
 *          经过上面的比较: 域对象数据共享 推荐使用 session
 *                如果是查询数据转发jsp展示数据(req)
 *      域的方法:
 *          存储的方法:
 *           setAttribute("key",obj)  存储数据的方法
 *           getAttribute("key")          获取数据的方法
 *           removeAttribute() 移除数据
 *
 *       上面的三个域对象都有相同的方法
 *          key重复 数据覆盖
 *          存储从数据是obj类型
 *
 */
@WebServlet("/session03")
public class Session03Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        // 手动注销 session
        session.invalidate();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
