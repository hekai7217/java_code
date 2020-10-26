package com.jutixueyuan.demo03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

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
 *       req对象获取 请求提交的参数:
 *          01 通过  getParameter("key") 如果存在key 返回数据,如果key不存在返回的是null
 *            key是表单的name的属性值
 *
 *        02  req.getParameterValues("fav"); 可以获取数组
 *
 *        03 获取所有的提交的数据  把这个数据以键值对的方式存储在map中
 *           req.getParameterMap();
 *
 */
@WebServlet("/request02")
public class Req02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取数据
        String name = req.getParameter("name");
        System.out.println("name = " + name);
        String pwd = req.getParameter("pwd");
        System.out.println("pwd = " + pwd);

        String[] favs = req.getParameterValues("fav");
        System.out.println("favs = " + Arrays.toString(favs));

        // 获取所有的提交的数据  把这个数据以键值对的方式存储在map中
        // key是 string   就是表单提交数据的 name的属性名称
        // value是 string[]     提交的数据的数组

        System.out.println("***************Map*******************");
        Map<String, String[]> map = req.getParameterMap();

        Set<Map.Entry<String, String[]>> entries = map.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.println("entry.getKey() +  = " + entry.getKey() + Arrays.toString(entry.getValue()));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
