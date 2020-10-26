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
 *
 *     01 servlet的继承关系
 *           Servlet  是 servlet的底层接口  5 个方法
 *           GenericServlet抽象类 是 servlet的接口实现类,  需要重写  service() 方法
 *           HttpServlet 抽象类 , 是  GenericServlet的子类 ,  重写 doget/dopost 的方法
 *
 *     02   为什么 HttpServlet 不重写service方法 重写 doget/dopost
 *        01  第一次访问过来创建对象:
 *                      Servlet  demoService  = new Demo04Servlet();
 *             处理请求:
 *                      demoService.service() 方法   Demo04Servlet中没有service方法,
 *              去 父类中找,HttpServlet 中找service()方法
 *                    service(ServletRequest req, ServletResponse res) 这个方法的内部做了 把 ServletRequest转成了
 *                    HttpServletRequest , 处理http请求
 *
 *              调用http中的service()方法
 *               protected void service(HttpServletRequest req, HttpServletResponse resp) {
 *                    String method = req.getMethod();   拿到请求方式
 *               if (method.equals("GET")) { 判断请求 进行 doXXX 请求分发
     *             lastModified = this.getLastModified(req);
     *             if (lastModified == -1L) {
     *                 this.doGet(req, resp);
     *             }
     *              else if (method.equals("POST")) {
     *                  this.doPost(req, resp);
 *                  }
 *               }
 *
 *               分发后:
 *               protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *                      String msg = lStrings.getString("http.method_get_not_supported");
 *                      this.sendMethodNotAllowed(req, resp, msg);
 *                      这里没有写具体的代码实现
 *
 *               }
 *               protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *                   String msg = lStrings.getString("http.method_post_not_supported");
 *                    this.sendMethodNotAllowed(req, resp, msg);
 *                    这里没有写具体的代码实现
 *               }
 *
 *              如果我们的 Demo04Servlet重写了 doget/dopost 方法
 *                httpServlet中分发的时候调用的doget/dopost 方法是你自己重写的方法
 *
 *       03   重写doget/还是dopost ?
 *         01 我们不能确定 用户用get/post请求
 *             重写必须重写 doget/dopost
 *
 *         02  doget/dopost  中处理业务逻辑的方法都是一样的
 *             doget/dopost方法中的参数都是一样的
 *             可以在doget中调用dopost(只需要在dopost实现业务逻辑代码就可以)
 */
@WebServlet("/demo05")
public class Demo04Servlet extends HttpServlet {

    // 只能处理get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
