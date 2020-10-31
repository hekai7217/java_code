package com.jutixueyuan.controller;

import com.jutixueyuan.bean.User;
import com.jutixueyuan.mapper.UserMapper;
import com.jutixueyuan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-27 17:11
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 获取数据
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        // 02 处理请求

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName(name);
        user.setPwd(pwd);

        User login = mapper.login(user);

        // 03 回写数据

        if (login != null){
            resp.getWriter().write("success");
        }else{
            resp.getWriter().write("error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
