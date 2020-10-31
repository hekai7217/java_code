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
 * @date 2020-10-28 10:20
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 拿到页面的数据
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        // 通过 req 获取session
        HttpSession session = req.getSession();

        // 02 处理数据
        if(name.equals("admin") && pwd.equals("123")){
        // 03 回写数据
            //登陆成功 把用户存储到session中
            session.setAttribute("name",name);

            // 重定向
            resp.sendRedirect("/web07/success.jsp");

        }else{ // 失败
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
