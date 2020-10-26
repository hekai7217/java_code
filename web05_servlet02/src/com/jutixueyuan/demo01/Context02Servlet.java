package com.jutixueyuan.demo01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-26 9:40
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   servletcontext 对象:
 *   作用:   ServletContext  和 tomcat进行通信
 *
 *     01 每个web项目都有一个 ServletContext对象,唯一的
 *     02 ServletContext对象的生命周期 和 web项目一致
 *     03 ServletContext对象 可以实现多个servlet中数据共享 (不推荐)
 *
 *   写代码验证:
 *      web项目都有一个 ServletContext对象,唯一的
 *      在多个servlet中获取的context 都是同一个
 *      如何获取servletContext对象:
 *        01  servletconfig 提供了 获取 ServletContext对象 对象方法
 *              config.getServletContext();
 *        02 通过 GenericServlet 对象直接使用
 *              getServletContext() 获取
 *
 */
@WebServlet(urlPatterns = "/context02")
public class Context02Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 通过config 获取  ServletContext
        ServletContext context01 = getServletConfig().getServletContext();
        System.out.println("context01 = " + context01);

        // 获取域对象中的数据
        // 01 获取      ServletContext对象 
        
        // 02 调用方法 
        Object key1 = context01.getAttribute("key1");
       // 把obj转成指定的数据类型
        String attribute = (String) context01.getAttribute("key1");
        System.out.println("attribute = " + attribute);

        System.out.println("key1 = " + key1);
        Object key2 = context01.getAttribute("key2");

        System.out.println("key2 = " + key2);

        // 获取的是 obj
        // key3 如果不存在  返回的是null  null 能 integer (容易异常出错)
//        Integer key3 = (Integer) context01.getAttribute("key3");

    }
}
