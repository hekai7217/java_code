package com.jutixueyuan.demo01;

import com.alibaba.fastjson.JSON;
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
@WebServlet("/ajax04")
public class Ajax04Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("name");

        Stu stu = null;
        if (name.equals("scott")){

            // 创建一个对象
            stu = new Stu("scott","普通用户",40,1);
        }
        if (name.equals("admin")){
            // 创建一个对象
            stu = new Stu("admin","管理员",40,1);

        }
        if (name.equals("root")){
            // 创建一个对象
            stu = new Stu("root","超级管理员",40,1);
        }

        // 把对象回写给 浏览器
        //  01 把java对象转成json 对象
        //  02  中文乱码
        response.getWriter().write(JSON.toJSONString(stu));

    }
}
