package com.jutixueyuan.demo04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author 黄药师
 * @date 2020-10-27 15:37
 * @desc 百战程序员 http://www.jutixueyuan.com\
 *
    cookie中可以存储特殊符号 (了解)
       把特殊符号转成url编码 (存储中文的处理也是一样的)
 *
 */
@WebServlet("/cookie03")
public class Cookie03Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 创建一个cookie
        String msg = URLEncoder.encode("hello,hi", "utf-8");
        Cookie c3 = new Cookie("cc", msg);
        resp.addCookie(c3);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
