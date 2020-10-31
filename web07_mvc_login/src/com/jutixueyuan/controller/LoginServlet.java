package com.jutixueyuan.controller;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.servivce.UserService;
import com.jutixueyuan.servivce.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-28 11:28
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //01 获取数据
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        User user = new User();
        user.setName(name);
        user.setPwd(pwd);

        // 02 调用业务层
        UserService userService = new UserServiceImpl();
        User u = userService.login(user);
        // 03 回写数据
        if (u != null){
            //成功
            resp.getWriter().write("success");
        }else{
            // 失败
            resp.getWriter().write("error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
