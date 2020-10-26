package com.jutixueyuan.demo02;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-26 15:25
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
     *  用户输入并提交登录信息
     * 登录成功，跳转到success.jsp页面
 *           请求转发和重定向都可以
     * 登录失败，跳转回login.jsp页面
     *
 *
 *  总结:
 *      01  页面跳转,用请求转发和重定向都是可以的
 *
 *      02  页面跳转的时候,需要传递参数    请求转发
 *          页面跳转到外部路径(jd.com)   重定向
 *          页面跳转的时候浏览器的url不能变化, 请求转发
 *          页面跳转的时候浏览器的url要,  重定向
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 获取表单提交的数据
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        String pwd = req.getParameter("pwd");
        System.out.println("pwd = " + pwd);
        // 02 业务逻辑的处理
        if(name.equals("sxt") && pwd.equals("123")){
            //登陆成功  跳转到success.jsp页面
            // 请求转发和重定向都可以
            resp.sendRedirect("/web05/view/success.jsp");
        }else{
            //登陆失败  跳转回login.jsp页面
            // 转发  (如果失败了 可以传递一个参数过去)
            req.setAttribute("msg","用户名和密码存在错误...");
            
            // 获取 分发器 
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/login.jsp");
            // 调用方法
            requestDispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
