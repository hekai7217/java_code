package com.jutixueyuan.controller;

import com.alibaba.fastjson.JSON;
import com.jutixueyuan.bean.Contants;
import com.jutixueyuan.bean.Result;
import com.jutixueyuan.bean.User;
import com.jutixueyuan.service.UserService;
import com.jutixueyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-31 16:53
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        // 01 拿到数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");

        // 02 调用service

        // 判断 验证码是否正确  如果验证码正确 通过name和pwd 查询数据库
        // 拿到session 拿到验证码
        HttpSession session = request.getSession();

        String sess_code = (String) session.getAttribute(CodeSerlvet.CHECK_CODE_KEY);

        // equalsIgnoreCase 忽略大小写的比较
        Result rs = null;
        if (verifycode.equalsIgnoreCase(sess_code)) {
            //登陆
            UserService userService = new UserServiceImpl();
            User user = userService.login(username, password);

            if (user != null) { //成功
                session.setAttribute("user", user);
                //返回要是 json对象
                rs = new Result(Contants.LOGIN_SUCCESS_CODE, Contants.LOGIN_SUCCESS_MSG);

            } else {   //失败
                rs = new Result(201, "用户名或者密码错误");
            }
        } else {
            rs = new Result(202, "验证码错误");
        }

        // 03 回写
        // 01 乱码 02 转成 json
        response.getWriter().write(JSON.toJSONString(rs));

    }
}
