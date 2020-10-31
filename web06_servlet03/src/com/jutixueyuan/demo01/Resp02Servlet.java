package com.jutixueyuan.demo01;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

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
 *
 *     03  resp 回写响应体
 *         回写内容 需要拿到 PrintWrite() 流
 *        01 回写  字符串
 *              write("hello msg");
 *        02 回写  html 标签
 *              write("<h1> hello h1</h1>"); 浏览器会默认解析html标签
 *        03 回写  byte数组
 *             ServletOutputStream() 流
 *                  write(bytes);
 */
@WebServlet("/resp02")
public class Resp02Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write("hello msg");

//        resp.getWriter().write("<h1> hello h1</h1>");

//        ServletOutputStream outputStream = resp.getOutputStream();
//        byte[] bytes = "hello ".getBytes();
//        outputStream.write(bytes);

        InputStream is = getServletContext().getResourceAsStream("/img/0.jpg");
        ServletOutputStream os = resp.getOutputStream();

        int len = 0 ;
        byte [] bs = new byte[1024];

        while ((len = is.read(bs))!=-1){

            os.write(bs,0,len);
            os.flush();
        }

        os.close();
        is.close();
    }

}

