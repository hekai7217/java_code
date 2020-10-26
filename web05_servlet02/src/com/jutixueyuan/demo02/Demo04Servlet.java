package com.jutixueyuan.demo02;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-26 14:35
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   请求转发:
 *       服务器中多个servlet需要功能完成一个任务,多个servlet协同实现完成
 *
 *   场景:
 *       查询商品, 查询的业务实现 (servlet中实现) + 商品的数据的展示( jsp )
 *
 *   请求转发的实现:
 *      01 获取请求转发器
 *            req.getRequestDispatcher("转发地址")
 *      02 调用请求转发的方法
 *            requestDispatcher.forward(req,resp);
 *
 *    请求转发的细节:
 *      01  请求转发可以实现 数据共享
 *             你访问aservlet中,转发到bservlet中, 可以把aservlet中的数据发送到bservlet中
 *             req 是我们域对象,可以实现数据共享
 *             域对象 ： 多个servlet 可以实现数据共享,内部有有个map存储数据,存在
 *                      setAttribute() getAttribute() 的方法
 *
 *                      req.setAttribute("key1","sn夺冠");
 *                      req.setAttribute("key2","abin nb");
 *
 *      02  请求转发, 是服务器的操作,请求转发的 路径只能是服务器的内部路径,
 *          浏览器的url不会发生变化, 效率问题,相对而言: 请求转发浏览器和服务器交互了1次
 *          效率比重定向高
 *
 */
@WebServlet("/req02")
public class Demo04Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 转发地址
        // 01  转发地址 一定是服务器的内部地址
        // 02   直接给当前项目的资源地址  /当前项目的资源地址
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/b.jsp");
        req.setAttribute("key1","sn夺冠");
        req.setAttribute("key2","abin nb");

        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
