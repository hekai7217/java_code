package com.jutixueyuan.demo02;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-24 15:17
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *      servlet的开发的规范:
 *          编写一个Servlet,实际上就是按照Servlet规范( 接口 )编写一个java类。
 *       开发servlet 一定要 直接或者间接的实现servlet接口
 *       servlet 接口是 servlet的开发的规范
 *          servlet 接口中有5 个方法
 *
 *     servlet 在web.xml的配置 很繁琐:
 *      解决: servlet3.0 的规范后,servlet 支持注解开发 , 和web.xml配置servlet 效果一样,
 *            简化了开发的步骤
 *
 *    01  servlet的生命周期:
 *           servlet的创建和销毁的过程称为 生命周期
 *           init()     初始化的操作, 第一次访问servlet从时候 会调用 init()方法  只会调用一次
 *           service()  提供服务的方法   每次访问的时候 ,每次都会调用 service方法
 *           destroy()  销毁的方法    如果tomcat关闭 会调用销毁的方法
 *
 *    02  生命周期的调用过程?
 *        servlet的生命 周期的管理者是 tomcat, 通过反射调用指定的方法
 *
 */
@WebServlet(urlPatterns = "/demo02")
public class Demo01Servlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        System.out.println("Demo01Servlet.init");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("Demo01Servlet.service");
    }

    @Override
    public void destroy() {

        System.out.println("Demo01Servlet.destroy");
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }

}
