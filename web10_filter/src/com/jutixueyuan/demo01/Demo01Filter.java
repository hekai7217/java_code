package com.jutixueyuan.demo01;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-11-04 9:42
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   servlet的开发  可以继承 httpServlet 也可以实现servlet 接口
 *
 *   filter 和servlet基本上是一样的
 *       可以实现filter 接口
 *       也可以实现 HttpFilter 接口
 *
 *   用HttpFilter类来实现filter 的开发
 *    01  继承  HttpFilter  (tomcat 9.0 以上版本才有  HttpFilter )
 *    02  重写dofilter方法
 *    03  可以使用注解配置
 *           @WebFilter("/index.jsp") 拦截指定的 url
 *
 *      继承 HttpFilter  和 实现Filter 接口:
 *      继承 HttpFilter 方便些
 *          HttpFilter 他的内部把  ServletRequest  转成了 HttpServletRequest  更好的处理http请求
 *
 *
 *   filter 的声明周期: 和 servlet 一样的
 *       init       初始化方法, 只会执行一次
 *       doFilter   拦截请求的方法 每次请求都会执行的方法
 *       destroy    销毁方法 web项目关闭后 销毁
 *          这些声明周期的方法都是以tomcat 进行管理
 *
 */
//@WebFilter("/index.jsp")
public class Demo01Filter extends HttpFilter {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Demo01Filter.init");
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("Demo01Filter.doFilter");
        chain.doFilter(request,response);

    }


    @Override
    public void destroy() {
        System.out.println("Demo01Filter.destroy");
    }
}
