package com.jutixueyuan.demo01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-24 14:30
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   使用servlet 来 处理login的请求
 *
 *      servlet的开发步骤还是一样:
 *        01 继承HttpServlet
 *        02 重写service方法
 *              01 处理请求
 *                 01 获取数据
 *                 02 处理数据
 *                 03 回写数据
 *        03 配置web.xml
 *        04 启动服务器
 *
 *    处理请求:
 *      用servlet /还是jsp ?
 *
 *      01  servlet 和jsp 都可以处理请求和响应结果
 *      02  jsp中可以写 html代码, jsp一般用于展示数据
 *          如果是处理login/注册等等业务操作,都是通过servlet来实现
 *
 *    servlet的小结:
 *    01 servlet 是 java的 动态网页技术
 *    02 servlet 开发必须遵守 servlet的开发步骤( 实现servlet接口 + web.xml中配置 )
 *    03 servlet的管理 是tomcat来完成  (servlet的创建和 service方法的调用都是tomcat来完成的)
 *
 *   Servlet和JSP的关系:
 *      JSP的本质是servlet,jsp 的调用的过程是:  jsp 编译成servlet类,调用servlet中的service方法 给浏览器回写
 *       html标签
 *   jsp和 servlet的分工:
 *      jsp  用于展示数据
 *      servlet  用于处理业务逻辑
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        01 获取数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

//         02 处理数据
        if (username.equals("admin") && password.equals("123")){

//       03 回写数据
            resp.getWriter().write("login success");
        }else{
            resp.getWriter().write("login error");
        }
    }
}
