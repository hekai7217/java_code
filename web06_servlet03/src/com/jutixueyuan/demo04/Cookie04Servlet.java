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
    cookie的生命周期: cookie 在浏览器中存活的时间

     通过 setMaxAge() 设置存活的时间
        setMaxAge(60)  单位是s  60 就是1分钟
        setMaxAge(-1)  默认值, 浏览器关闭,cookie 就会销毁
        setMaxAge(0)   删除cookie
 *
 */
@WebServlet("/cookie04")
public class Cookie04Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie c1 = new Cookie("dd", "hello");
        c1.setMaxAge(10 * 60);
        resp.addCookie(c1);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
