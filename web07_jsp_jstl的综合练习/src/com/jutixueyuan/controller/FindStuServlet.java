package com.jutixueyuan.controller;

import com.jutixueyuan.bean.Stu;
import com.jutixueyuan.service.StuService;
import com.jutixueyuan.service.impl.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄药师
 * @date 2020-10-30 9:44
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet("/findStuById")
public class FindStuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            // 01  获取数据
        String stuId = req.getParameter("id");
        // 02  调用service
        // 调用service
        StuService stuService = new StuServiceImpl();
        Stu stu = stuService.findStuById(Integer.parseInt(stuId));
        //03 回写数据(把查询的stu 转发到jsp 页面 进行编辑)
        if (stu != null){
            req.setAttribute("stu",stu);
            req.getRequestDispatcher("/stu/editStu.jsp").forward(req,resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
