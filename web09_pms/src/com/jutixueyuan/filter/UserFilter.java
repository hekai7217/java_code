package com.jutixueyuan.filter;

import com.jutixueyuan.bean.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-11-04 14:20
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   添加过滤器  处理 没有登录就可以操作数据
 *
 *    添加过滤器：
 *    01  需要拦截的url
 *       如果是拦截所有的   /*
 *       如果是拦截所有jsp  *.jsp
 *       如果是拦截某个模块  /user
 *
 *    02  拦截的逻辑处理
 *        拿到 session中存储的 user 判断是否放行
 */
//@WebFilter({"/user","/index.jsp","/page/user/*"})
//@WebFilter({"/user","*.jsp"})   // *.jsp  一定要放行 login.jsp
public class UserFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        // 放行 login.jsp  要在  判断 user 前面进行放行
        if (requestURI.contains("login.jsp")){
            chain.doFilter(request,response);
            return; // 放行 不走后面的代码
        }

        // 判断 用户是否登录了
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // 判断
        if (user != null){ // 放行
            chain.doFilter(request,response);
        }else{
            // 重定向  login.jsp
            response.sendRedirect("/pms/login.jsp");
        }
    }
}
