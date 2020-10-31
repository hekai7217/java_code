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
 * @date 2020-10-27 16:27
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01  获取数据
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        // 勾选
        String ch = req.getParameter("ch");

        if (name == null || pwd == null){
            resp.getWriter().write("error");
            return;
        }
        // 记住密码
        Cookie c1 = new Cookie("name", name);
        Cookie c2 = new Cookie("pwd", pwd);
        // 02 处理登陆
        // 判断用户名或者密码是否正确
        if("sxt".equals(name) && "123".equals(pwd)){
            // 判断是否勾选了 checkbox
            if(ch != null && ch.equals("yes")){ // 勾选了 记住密码
                // 设置生命周期
                c1.setMaxAge(60 * 10);
                c2.setMaxAge(60 * 10);
            }else{
                //  如果没有记住密码 删除 cookie
                c1.setMaxAge(0);
                c2.setMaxAge(0);
            }
            // 给 浏览器回写cookie
            resp.addCookie(c1);
            resp.addCookie(c2);

            // 成功
        // 03 页面跳转
            resp.sendRedirect("/web06/success.jsp");
        }else{

            req.setAttribute("msg","error");
            // 转发
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
