package com.jutixueyuan.demo01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-27 9:44
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   测试 resp 的基本的方法
 *   resp 是给浏览器回写 响应信息的
 *      响应协议:
 *        响应首行
 *        响应头
 *        响应体
 *
 *      01 resp 可以回写 状态码
 *             resp.setStatus(203);
 *         如果请求成功,服务器会默认给我们回写 200
 *           发送错误的信息
 *              resp.sendError();
 *
 *     02   resp 回写响应头
 *      `      resp.setContentType("text/html;charset=utf-8");
 */
@WebServlet("/resp01")
public class Resp01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 回写状态码
//        resp.setStatus(203);

        // 回写状态码 带提示信息
//        resp.sendError(404,"5次扫黄你都在,资源下架了...");

        // resp 回写响应头
        // msg 这种响应头没有意义  有意义的响应头是 http支持的响应头
//        resp.setHeader("msg","hello");
//        resp.setHeader("msg2","hello2");
        // 服务器告诉浏览器 我的会回写的数据类型
//        resp.setHeader("contentType","text/html");
//        // 服务器告诉浏览器  数据编码
//        resp.setHeader("charset","utf-8");

        // resp 把有意义的响应头都封装成了指定的方法 可以直接哪来的用
//        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html");

        // 上面的写法很繁琐  可以把上面的写法综合在一起 推荐这么写
        resp.setContentType("text/html;charset=utf-8");

        resp.getWriter().write("苏宁加油...");
    }

}

