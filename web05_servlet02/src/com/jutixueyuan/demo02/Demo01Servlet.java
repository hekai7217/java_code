package com.jutixueyuan.demo02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-26 14:12
 * @desc 百战程序员 http://www.jutixueyuan.com
 *     重定向的概念:
 *        重定向: 浏览器 A 访问服务器B, 服务器B给回写了响应码302,回写了一个地址C,浏览器A 访问C,C给浏览器A 回写结果
 *
 *     重定向的代码实现:
 *        回写 302 重定向的响应码
 *            resp.setState(302)
 *        给浏览器回写C的地址,可以设置头信息
 *            http协议中, 请求协议可以给浏览器回写具体的头信息
 *            头信息中可以设置location 设置C的访问的地址
 *
 */
@WebServlet("/resp01")
public class Demo01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 302 编码
        resp.setStatus(302);
        // 回写c的地址
        // 回写 的 路径的地址的细节:  /项目访问路径/项目中的访问资源
        resp.setHeader("location","/web05/a.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
