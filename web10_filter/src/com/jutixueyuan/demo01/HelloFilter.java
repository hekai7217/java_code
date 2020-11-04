package com.jutixueyuan.demo01;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-11-04 9:31
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *     filter是 javaweb的三大组件
 *      servlet 处理请求
 *      filter 是 拦截请求
 *      请求servlet的时候,一定是先执行 这个项目中的filter 如果放行 才执行 servlet
 *
 *     filter的开发步骤: (基本上和 servlet 一样 )
 *       01 实现filter接口
 *              Filter 是  servlet 下面的filter  java1.8 中 接口中可以定义默认方法  默认方法可以重写,可以不用重写
 *       02 实现抽象方法
 *              doFilter  处理拦截的方法
 *
 *        03 在 web.xml配置 filter
 *
 */
public class HelloFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("servlet 请求拦截了");
        // 放行
        filterChain.doFilter(req,response);

    }
}
