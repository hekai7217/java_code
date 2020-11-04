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
 *   测试 filter拦截规则
 *
 *      01 filter默认只能拦截   REQUEST
 *          直接访问目标资源时执行过滤器。包括：在地址栏中直接访问、表单提交、超链接、重定向，只要在地址栏中可以看到目标资源的路径，就是REQUEST；
 *
 *      02 FORWARD：转发访问执行过滤器。包括RequestDispatcher#forward()方法、jsp:forward标签都是转发访问；
 *
 *      拦截方式可以进行配置:
 *         可以web.xml
 *             REQUEST 直接请求
 *             FORWARD 转发拦截
 *                  <dispatcher>FORWARD</dispatcher>
 *                  <dispatcher>REQUEST</dispatcher>
 *         可以注解配置:
 *
 */
@WebFilter(
        urlPatterns = "/b.jsp",
        dispatcherTypes = {
                DispatcherType.REQUEST,  // 直接请求
                DispatcherType.FORWARD   // 转发拦截
        }
)
public class Filter03 extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("拦截了....");
    }
}
