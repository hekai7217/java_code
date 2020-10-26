package com.jutixueyuan.demo04;

import org.jcp.xml.dsig.internal.dom.DOMXPathFilter2Transform;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-24 17:13
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *    可以在servlet中配置参数:
 *
 *      01 xml中配置参数
 *
 *         <init-param>
 *             <param-name>name</param-name>
 *             <param-value>old player</param-value>
 *         </init-param>
 *
 *         可以在注解中配置参数
 *
         *     @WebServlet(urlPatterns = "/parmater",
         *     initParams = {
         *         @WebInitParam(name = "name",value = "old play"),
         *         @WebInitParam(name = "pwd",value = "1234"),
         *     }
         * )
 *
 *      02 解析servlet配置的参数
 *           解析servlet中的参数配置: servlet 提供了一个接口 servletConfig
 *           servletConfig 接口提供了方法 来获取 配置信息
 *           config.getInitParameter("name");  获取 配置从参数信息
 *              String servletName = config.getServletName(); 获取servletname的名称
 *
 *        如果获取servletConfig 对象:
 *         01  重写init方法 init方法中存在 servletConfig 对象
 *
 *         02  可以获取 servletConfig 对象
 *            servlet接口中存在    ServletConfig getServletConfig(); 方法
 *            GenericServlet 中  实现了 抽象方法  getServletConfig
 *            可以直接调用父类的方法 getServletConfig()
 *
 *     参数的配置的应用场景:
 *        01 在springmvc中可以配置 加载 配置
 *        02 过滤器中配置参数的初始化的编码格式
 *
 *
 */
@WebServlet(urlPatterns = "/parmater",
    initParams = {
        @WebInitParam(name = "name",value = "old play"),
        @WebInitParam(name = "pwd",value = "1234"),
    }
)
public class ParmaterServlet extends HttpServlet {

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//
//        String name = config.getInitParameter("name");
//        System.out.println("name = " + name);
//        String pwd = config.getInitParameter("pwd");
//        System.out.println("pwd = " + pwd);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            // 直接调用父类的方法
        ServletConfig config = getServletConfig();

        String name = config.getInitParameter("name");
        System.out.println("name = " + name);

        String pwd = config.getInitParameter("pwd");
        System.out.println("pwd = " + pwd);

        String servletName = config.getServletName();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
