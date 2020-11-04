package com.jutixueyuan.demo02;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-11-04 10:25
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebFilter("/index.jsp")
public class Filter01 extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("Filter01.doFilter 拦截器开始");
        // 放行
        chain.doFilter(request, response);

        System.out.println("Filter01.doFilter 拦截器结束");
    }
}
