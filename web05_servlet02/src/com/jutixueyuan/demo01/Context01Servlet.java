package com.jutixueyuan.demo01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

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
 *      01  如何获取servletContext对象:
 *        01  servletconfig 提供了 获取 ServletContext对象 对象方法
 *              config.getServletContext();
 *        02 通过 GenericServlet 对象直接使用
 *              getServletContext() 获取
 *
 *      02 ServletContext对象是域对象
 *         01 域对象可以存储数据,存储数据的内部有一个map集合
 *         02 可以在多个servlet中传递数据,有存储的方法
 *
 *       域对象的方法 :
 *            setAttribute("key","value")  给域对象设置 存储数据
 *            getAttribute("key")           获取域对象中的数据, 返回的数据类型是object对象
 *            removeAttribute("key")
 *        细节: 01 如果key不存在,获取的数据是null
 *             02 如果key重复了,value 会被覆盖
 *
 */
@WebServlet(urlPatterns = "/context01")
public class Context01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 通过config 获取  ServletContext
        ServletContext context01 = getServletConfig().getServletContext();
        System.out.println("context01 = " + context01);

        // 通过 GenericServlet 来获取  ServletContext  本质上 2个方法都是 通一个方法的实现 过config 获取  ServletContext
        ServletContext context02 = getServletContext();
        System.out.println("context01 = " + context01);

        // 设置 域对象数据
        // key是字符串   value是obj对象
        context01.setAttribute("key1","sn夺冠");
        context01.setAttribute("key2",new Date());
        context01.setAttribute("key3",20);
    }
}
