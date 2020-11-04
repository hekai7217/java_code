package com.jutixueyuan.demo01;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-11-04 9:42
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  filterConfig 对象
 *   可以获取配置的信息
 */
//@WebFilter(urlPatterns = "/index.jsp",
//        initParams = {
//            @WebInitParam(name="name",value = "scott"),
//            @WebInitParam(name="pwd",value = "tiger"),
//        }
//)
public class Demo02Filter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        //拿到 filterconfig 对象
        FilterConfig filterConfig = getFilterConfig();

        // 拿到初始化参数
        String name = filterConfig.getInitParameter("name");
        System.out.println("name = " + name);
        String pwd = filterConfig.getInitParameter("pwd");
        System.out.println("pwd = " + pwd);

        // 拿到 servletContext对象
        ServletContext servletContext = filterConfig.getServletContext();
        System.out.println("servletContext = " + servletContext);


    }

}
