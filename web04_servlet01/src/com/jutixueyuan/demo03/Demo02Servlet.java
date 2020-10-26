package com.jutixueyuan.demo03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-24 16:54
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   servlet细节:
 *      02 一个servlet可以配置多个 url
 *          可以注解配置多个url
 *              @WebServlet(urlPatterns = {"/req01","/req02"})
 *          可以 xml配置多个url
 *          <servlet-mapping>
 *              <servlet-name>login</servlet-name>
 *              <url-pattern>/req01</url-pattern>
 *              <url-pattern>/req02</url-pattern>
 *          </servlet-mapping>
 *
 *
 */
@WebServlet(urlPatterns = {"/req01","/req02"})
public class Demo02Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo02Servlet.doGet");
    }
}
