package com.jutixueyuan.controller;

import com.jutixueyuan.bean.Stu;
import com.jutixueyuan.service.StuService;
import com.jutixueyuan.service.impl.StuServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-10-30 9:55
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet(urlPatterns = "/updateStu")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 处理 post提交数据中文乱码
        request.setCharacterEncoding("utf-8");

        // 处理回写的中文乱码
        response.setContentType("text/html;charset=utf-8");

        // 01 获取数据
        Map<String, String[]> map = request.getParameterMap();

        Stu stu = new Stu();
        try {
            BeanUtils.populate(stu,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("stu = " + stu);

        //02 处理数据 调用service
        StuService stuService = new StuServiceImpl();
        boolean flag = stuService.updateStu(stu);

        // 回写数据
        if (flag){  // 成功 重定向   查询所有

            response.sendRedirect("/web07/queryStus");

        }else{  // 回写错误信息
            response.getWriter().write("添加失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
