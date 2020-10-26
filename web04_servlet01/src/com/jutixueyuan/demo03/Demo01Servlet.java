package com.jutixueyuan.demo03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-24 16:47
 * @desc 百战程序员 http://www.jutixueyuan.com
 *    servlet的细节:
 *     01  servlet 一般是 第一次访问的时候创建servlet
 *        可以通过 xml配置,启动tomcat后就创建servlet
 *              <load-on-startup>1</load-on-startup>
 *         可以通过注解的方式配置:
 *         @WebServlet(urlPatterns = "/init",loadOnStartup = 1)
 *
 */
@WebServlet(urlPatterns = "/init",loadOnStartup = 1)
public class Demo01Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Demo01Servlet.init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
