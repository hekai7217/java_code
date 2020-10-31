package com.jutixueyuan.demo04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-27 15:37
 * @desc 百战程序员 http://www.jutixueyuan.com\
 *
 *    创建cookie, 给浏览器回写cookie
 *    查看: cookie 在http协议中的 响应
 */
@WebServlet("/cookie01")
public class Cookie01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 创建cookie   键值对
        Cookie c1 = new Cookie("aa", "11");
        Cookie c2 = new Cookie("bb", "22");

        // 给浏览器回写cookie
        resp.addCookie(c1);
        resp.addCookie(c2);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
