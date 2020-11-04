package com.jutixueyuan.filter;

import com.jutixueyuan.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-11-04 11:41
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebFilter({"/user/user.jsp","/admin/admin.jsp"})
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 判断 session中是否有user

        HttpSession session = request.getSession();

        User u = (User) session.getAttribute("u");

        if ( u != null){
            //放行
            chain.doFilter(request,response);
            return;
        }else{

            response.getWriter().write("please login");
        }

    }
}
