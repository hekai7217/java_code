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
 *  可以通过 req 来获取 请求头中的所有的cookie
 *      req.getCookies() 获取所有的cookie
 *
 *      c.getName() 获取cookie的名称
 *      c.getValue()  获取cookie的值
 *
 *
 */
@WebServlet("/cookie02")
public class Cookie02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cs = req.getCookies();

        if (cs != null) {
            for (Cookie c : cs) {
                System.out.println("c+ \"\" = " + c.getName() + "====" + c.getValue());

            }
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
