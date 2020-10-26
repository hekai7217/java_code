package com.jutixueyuan.demo02;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-24 15:32
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *     开发servlet 需要实现servlet 接口, 需要 实现很多方法, 开发比较麻烦, 可以不用实现接口吗?
 *
 *     如果开发servlet ,GenericServlet 使编写 servlet 变得更容易. 只需要写 service() 方法就可以
 */
@WebServlet("/demo03")
public class Demo02Servlet extends GenericServlet {

    // 每次请求都会调用service 方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("请求过来了....");

    }
}
