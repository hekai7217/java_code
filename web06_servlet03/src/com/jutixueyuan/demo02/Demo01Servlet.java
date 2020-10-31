package com.jutixueyuan.demo02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-27 10:51
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *   编码问题中的乱码问题:
 *      01 字符串的编码
 *           01 字符串的编码和解码不统一
 *  *        02 数据丢失
 *      02 javaweb的编码
 *          01 req 中的数据提交乱码
 *              get 提交
 *               参数会拼接在url的后面,会把中文转成url编码
 *               服务器会自动解析url编码,不能出现乱码
 *
 *              post 提交 参数通过请求体提交数据,服务器获取数据会乱码
 *                解决问题:
 *                  // 重写此请求正文中(请求体)使用的字符编码的名称
 *                  // tomcat解析请求体的默认编码不是utf-8
 *                  req.setCharacterEncoding("utf-8");
 *
 *          02  resp 中回写数据乱码
 *               resp 回写内容会乱码  不同的浏览器用不同的编码解析
 *
 *              解决: 设置回写头信息 告诉 浏览器 用指定的编码解析回写的内容
 *`                   resp.setContentType("text/html;charset=utf-8");
 *
 *        总结 :
 *          req 中post提交会乱码:   req.setCharacterEncoding("utf-8");
 *          resp 中回写会乱码:      resp.setContentType("text/html;charset=utf-8");
 *
 *
 *      03 文件编码/数据库编码
 *
 *         修改工作空间的乱码
 *         数据库的乱码:  url上面配置 characterEncoding=utf-8
 *
 */
@WebServlet("/code")
public class Demo01Servlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 重写此请求正文中(请求体)使用的字符编码的名称
//        req.setCharacterEncoding("utf-8");
//
//        // 获取参数
//        String name = req.getParameter("name");
//        System.out.println("name = " + name);
//        String info = req.getParameter("info");
//        System.out.println("info = " + info);

        resp.setContentType("text/html;charset=utf-8");

        // 服务器会洗的编码是 utf-8
         resp.getWriter().write("31晚上6点s10总决赛");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
