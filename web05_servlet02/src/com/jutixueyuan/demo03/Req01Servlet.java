package com.jutixueyuan.demo03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 黄药师
 * @date 2020-10-26 16:20
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *    req 对象的详情:
 *
 *        01  req对象    HttpServletRequest   http请求协议中的数据 都封装到req对象中了
 *        02  resp对象   HttpServletResponse  http响应协议中的数据 都封装到resp对象中了
 *
 *        req对象和resp对象从哪儿来的?
 *            req/resp对象是tomcat 出来请求给我们创建的
 *
 *
 *       req对象中的一些方法:
 *       01 req 对象可以获取头信息
 *           req.getHeader("Host"); 获取指定的头信息
 *       02 获取 url的操作: http://localhost:8080/web04/demo05/req01
 *           http 协议
 *           localhost ip
 *           8080     端口
 *           /web04    项目的访问路径
 *           /demo05/req01  项目下面的资源
 *
 *       03  获取服务器的信息
 *
 *         客户端用于发出请求的 URL。
 *         返回的 URL 包含一个协议、服务器名称、端口号、服务器路径，但是不包含查询字符串参数。
 *         req.getRequestURL();  http://localhost:8080/web05/request01
 *         请求的 URL 的一部分，从协议名称一直到 HTTP 请求的第一行中的查询字符串
 *         req.getRequestURI();  /web05/request01
 */
@WebServlet("/request01")
public class Req01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取指定的头信息
        String host = req.getHeader("Host");
        System.out.println("host = " + host);
        String header = req.getHeader("Accept-Language");
        System.out.println("header = " + header);

        // 获取所有的头信息
        //  Enumeration 迭代器 (老古董的迭代器 )
        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println("s = " + s);
        }

        // req获取 url的信息
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL.toString() = " + requestURL.toString());
//
//        String remoteHost = req.getRemoteHost();
//        System.out.println("remoteHost = " + remoteHost);
//        int remotePort = req.getRemotePort();
//        System.out.println("remotePort = " + remotePort);
//        String remoteAddr = req.getRemoteAddr();
//        System.out.println("remoteAddr = " + remoteAddr);

        String servletPath = req.getServletPath(); // /request01
        System.out.println("servletPath = " + servletPath);
        int serverPort = req.getServerPort();  //  8080
        System.out.println("serverPort = " + serverPort);

        String requestURI = req.getRequestURI(); // /web05/request01
        System.out.println("requestURI = " + requestURI);

        // 获取请求的方式
        String method = req.getMethod();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
