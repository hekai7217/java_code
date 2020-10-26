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
 * @date 2020-10-26 9:25
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *
 *      servlet 的参数的配置 :
 *       <init-param>
 *            <param-name>name</param-name>
 *            <param-value>old player</param-value
 *       </init-param>
 *       参数的配置只能是 在单个servlet中进行使用,不能全局的使用
 *
 *       javaweb中项目参数的配置实现全局使用:
 *          01  初始化参数的配置(全局配置)
*           <context-param>
 *              <param-name>name</param-name>
 *              <param-value>root</param-value>
 *          </context-param>
 *
 *          02  解析参数的配置
 *             </init-param> 的配置通过servletconfig 来读取配置
 *             <context-param>  使用servletContext来实现参数的读取
 *             01 ServletContext  和 tomcat进行通信
 *             02 web项目中 ServletContext 只有一个对象
 *             03 ServletContext 可以实现多个servlet 数据共享 (不推荐)
 *
 *        参数的配置的应用场景:
 *  *        01 在springmvc中可以配置 加载 配置
 *  *        02 过滤器中配置参数的初始化的编码格式
 *
 */
@WebServlet("/demo01")
public class Demo01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 解析web.xml中的配置  <context-param>

        // 01 获取 ServletContext 对象
        // 父类中提供了 获取 servletContext对象的方法
        ServletContext servletContext = getServletContext();

        // 02 调用方法
        String name = servletContext.getInitParameter("name");
        System.out.println("name = " + name);
        String pwd = servletContext.getInitParameter("pwd");
        System.out.println("pwd = " + pwd);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
