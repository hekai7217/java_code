package com.jutixueyuan.controller;

import com.alibaba.fastjson.JSON;
import com.jutixueyuan.bean.Result;
import com.jutixueyuan.bean.User;
import com.jutixueyuan.service.UserService;
import com.jutixueyuan.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.IntBuffer;
import java.sql.ResultSet;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-11-02 10:47
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  user模块的功能都写在这里
 */
@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 处理乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");

        // 拿到 method 参数 进行分发

        String method = req.getParameter("method");
        System.out.println("method = " + method);

        if ( method !=null && method.length() > 0) {

            // 分发 处理不同的 业务处理

            // 校验 用户是否存在
            if (method.equals("checkName")){
                checkName(req,resp);
            }
            if (method.equals("addUser")){
                addUser(req,resp);
            }
            // 查询所有
            if (method.equals("queryAll")){
                queryAll(req,resp);
            }

            if (method.equals("delStu")){
                delStu(req,resp);
            }


        }



    }

    /**
     *  删除
     * @param req
     * @param resp
     */
    private void delStu(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {

        // 01 拿到数据
        String id = req.getParameter("id");
        UserService userService = new UserServiceImpl();
        boolean flag = userService.delStu(Integer.parseInt(id));

        Result rs = null;

        if (flag){
            // 删除功
            rs = new Result(500,"删除成功...");
        }else{
            // 删除失败
            rs = new Result(501,"删除失败");
        }
        resp.getWriter().write(JSON.toJSONString(rs));
    }

    /**
     * 查询所有
     * @param req
     * @param resp
     */
    private void queryAll(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {

        // 02 调用方法
        UserService userService = new UserServiceImpl();
        List<User> list = userService.queryAll();

        // 03 回写数据
        //   查询的是 所有的user 把user发送到 jsp 页面展示
        if (list.size() > 0){
            req.setAttribute("users",list);
            req.getRequestDispatcher("/page/user/users.jsp").forward(req,resp);
        }else{
            resp.getWriter().write("查询数据为空");
        }

    }

    /**
     * 添加user
     * @param req
     * @param resp
     */
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 获取页面的数据
        Map<String, String[]> map = req.getParameterMap();
        
        // 把map转成bean对象 
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);
        // 添加的时候 提交了 6 条数据
        // 设置 2个数据为默认值
        user.setImg("/aaa/a.jpg");
        user.setRegtime(new Date());

        // 02 调用service方法
        UserService userService = new UserServiceImpl();
        boolean flag = userService.addUser(user);

        Result rs = null;
        // 03 回写数据
        if (flag){
            // 添加成功
            rs = new Result(400,"用户添加成功...");
        }else{
            // 添加失败
            rs = new Result(401,"用户添加失败");
        }
        resp.getWriter().write(JSON.toJSONString(rs));

    }

    /**
     * 校验 用户是否存在
     * @param req
     * @param resp
     */
    private void checkName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 01 获取参数
        String username = req.getParameter("username");
        // 02 调用service
        UserService userService = new UserServiceImpl();
        boolean flag =userService.checkName(username);

        // 03 回写数据
        Result rs = null;
        if (flag){  // true  用户名已存在
            rs = new Result(300,"用户名已存在不能使用");
        }else{
            rs = new Result(301,"用户名可以使用");
        }

        resp.getWriter().write(JSON.toJSONString(rs));

    }
}
