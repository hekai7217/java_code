package com.jutixueyuan.controller;

import com.jutixueyuan.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-11-04 11:32
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 拿到数据

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        User user = null;
        // 02 处理数据
        if (name.equals("sxt") && pwd.equals("123")){  // 普通用户
            user = new User();
            user.setName(name);
            user.setPwd(pwd);
            user.setRole(1);
        }
        if (name.equals("zhangsan") && pwd.equals("123")){  // 管理员用户
            user = new User();
            user.setName(name);
            user.setPwd(pwd);
            user.setRole(2);
        }
        if (user != null){  // 登录  把用户存到session`
            req.getSession().setAttribute("u",user);
        }
        // 03 回写数据
        resp.sendRedirect("/web10/index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
