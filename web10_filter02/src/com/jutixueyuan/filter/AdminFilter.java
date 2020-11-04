package com.jutixueyuan.filter;

import com.jutixueyuan.bean.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-11-04 11:41
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebFilter("/admin/admin.jsp")
public class AdminFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        response.setContentType("text/html;charset=utf-8");

        // 判断 session中是否有user

        HttpSession session = request.getSession();

        User u = (User) session.getAttribute("u");

        if ( u != null){

            // 判断 user的 role
            if(u.getRole() == 2){
                chain.doFilter(request,response);
                return;
            }else{
                response.getWriter().write(" 权限不够");
            }
        }else{
            response.getWriter().write("please login");
        }

    }
}
