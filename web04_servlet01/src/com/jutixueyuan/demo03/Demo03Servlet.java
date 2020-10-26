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
 *      配置 url的详情
 *       01 url可以精确的配置:
 *              /abc/a    url的匹配一定要 和 /abc/a 一致
 *              <url-pattern>/abc/b</url-pattern>
 *       02 url可以扩展名的匹配:
 *              *.do / *.action  后缀扩展名(不要在*.do前面加/)
 *              <url-pattern>*.do</url-pattern>
 *              如果以 .do 结尾或者 .action结尾的都可以访问 指定的servlet
 *
 *       03 url可以通配符匹配
 *               /*         所有的url都可以
 *               /user/*    url下面的所有的资源
 *               <url-pattern>/user/*</url-pattern>
 *
 */
//@WebServlet("/abc/a")   url可以精确的配置:
//@WebServlet("*.do")     url可以扩展名的匹配:
@WebServlet("/user/*")      // url可以通配符匹配
public class Demo03Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo03Servlet.doGet");
    }
}
