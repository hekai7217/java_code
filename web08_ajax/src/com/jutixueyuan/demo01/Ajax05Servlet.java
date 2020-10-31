package com.jutixueyuan.demo01;

import com.alibaba.fastjson.JSON;
import com.jutixueyuan.bean.Result;
import com.jutixueyuan.bean.Stu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-30 10:43
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   服务器给浏览器返回json数据
 */
@WebServlet("/ajax05")
public class Ajax05Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("name");

        Result rs = null;
        if (name.equals("scott")){
            // 创建一个对象
            // false 用户名不能使用
            rs = new Result(false,"用户名已存在");

        }else if (name.equals("admin")){
            // false 用户名不能使用
            rs = new Result(false,"用户名已存在");

        }else{
            // false 用户名不能使用
            rs = new Result(true,"用户名可以使用...");
        }

        // 把对象回写给 浏览器
        //  01 把java对象转成json 对象
        //  02  中文乱码
        response.getWriter().write(JSON.toJSONString(rs));

    }
}
