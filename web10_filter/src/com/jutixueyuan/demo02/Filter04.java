package com.jutixueyuan.demo02;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-11-04 10:34
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *
 *   /* 拦截所有的 访问资源
 *      01 可以通过req 拿到 请求的url 给指定的 url放行
 *      02 会拦截 css  要给css放行
 *
 */
@WebFilter("/*")
public class Filter04 extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        //放行  c.jsp
        // 放行 css的样式
        if (requestURI.contains("c.jsp") || requestURI.contains("css")){
            chain.doFilter(request,response);
            return;
        }
        System.out.println("拦截了....");
    }
}
