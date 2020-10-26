package com.jutixueyuan.demo01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 黄药师
 * @date 2020-10-24 14:08
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   实现servlet的开发步骤:
 *      01  创建一个servlet 继承HttpServlet
 *      02 重写service 方法
 *              service()  这个方法是 处理请求
 *              如果你每次都来请求servlet 每次都会调用service()
 *              req   获取请求的对象
 *              resp   回写请求的对象
 *              req, resp 这 2个对象是 tomcat 给我们的对象,不用初始化就可以使用的对象
 *
 *      03  在web.xml 配置 service
 *      04 启动项目
 *
 *  jsp的代码中:
 *   index_jsp extends org.apache.jasper.runtime.HttpJspBase
 *   HttpJspBase 内部也是继承了 httpServlet
 *   jsp的本质也是servlet  只不过,jsp的技术中,自动把jsp转成了xxxServlet
 *   xxxServlet  会给浏览器回写 http标签
 *   下面是 jsp 回写 html标签的代码
 *       out.write("\n");
 *       out.write("\n");
 *       out.write("<html>\n");
 *       out.write("  <head>\n");
 *       out.write("    <title>$Title$</title>\n");
 *       out.write("  </head>\n");
 *       out.write("  <body>\n");
 *       out.write("  $END$\n");
 *       out.write("  </body>\n");
 *       out.write("</html>\n");
 *
 */
public class Demo01Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 通过 resp对象 给浏览器回写数据

        // 给浏览器回写 html标签

        // 给浏览器会回写的数据的类型 和编码格式
        // 如果 不设置 charset=utf-8  浏览器页面显示中文会乱码

        resp.setContentType("text/html;charset=utf-8");
        // 获取输出流
        PrintWriter out = resp.getWriter();

        // 给浏览器输出 html标签  浏览器会自动解析html标签
        out.print("<html>");
        out.print("<head>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h3>This  is  My First Servlet  哈哈</h3>");
        out.print("</body>");
        out.print("</html>");

    }
}
