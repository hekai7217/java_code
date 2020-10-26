package com.jutixueyuan.demo02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-26 14:12
 * @desc 百战程序员 http://www.jutixueyuan.com
 *     重定向的概念:
 *        重定向: 浏览器 A 访问服务器B, 服务器B给回写了响应码302,回写了一个地址C,浏览器A 访问C,C给浏览器A 回写结果
 *
 *     重定向的代码实现:
 *        回写 302 重定向的响应码
 *            resp.setState(302)
 *        给浏览器回写C的地址,可以设置头信息
 *            http协议中, 请求协议可以给浏览器回写具体的头信息
 *            头信息中可以设置location 设置C的访问的地址
 *
 *     01  重定向上面实现太麻烦了,resp中有封装 重定向的 方法
 *              重定向的地址: /项目的访问路径/项目中的资源
 *              sendRedirect("直接给重定向的地址就可以");
 *
 *    02  重定向:可以重定向
 *           服务器的内部资源(当前项目的访问资源): resp.sendRedirect("/web05/a.jsp");
 *           服务器的外部资源(可以是百度/京东):
 *
 *    03  重定向:和服务器的交互,发送了2次请求, 浏览器的请求的url发生了变化,显示的是重定向的地址
 *
 *    04  重定向后 resp 不要给浏览器响应结果
 *    应用:
 *      01 登陆操作错误,重定向到登陆页面
 *
 *
 */
@WebServlet("/resp02")
public class Demo02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("/web05/a.jsp");

        //重定向外部资源
        resp.sendRedirect("http://blog.jutixueyuan.com");

        //不要给 浏览器 回写 响应信息
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
