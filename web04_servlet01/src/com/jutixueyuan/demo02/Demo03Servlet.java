package com.jutixueyuan.demo02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-24 15:40
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *     servlet的开发的规范:
 *          方式1:  可以实现Servlet 接口 重写所有的方法实现 servlet的开发
 *          方式2:  可以继承GenericServlet抽象类  只需要重写service() 方法
 *          方式3:  推荐, 开发servlet 可以直接继承 HttpServlet 重写doget/dopost方法
 *               HttpServlet 的子类至少必须重写一个方法，该方法通常是以下这些方法之一
 *                 doget/dopost方法
 *                 没有理由重写 service 方法。service 通过标准 HTTP 请求分发给每个 HTTP 请求类型的
 *                 处理程序方法(doget/dopost)
 *                 doget 只能处理get请求
 *                 dopost 只能处理post请求
 *
 *
 */
@WebServlet("/demo04")
public class Demo03Servlet  extends HttpServlet {

    // 只能处理get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo03Servlet.doGet");
    }
}
