package com.jutixueyuan.controller;

import com.alibaba.fastjson.JSON;
import com.jutixueyuan.bean.Area;
import com.jutixueyuan.service.SSqService;
import com.jutixueyuan.service.impl.SSqServiceImpl;
import jdk.nashorn.internal.runtime.FindProperty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-31 9:40
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   把 查询省/市/区  写到一个servlet中
 *      doget方法只能处理一个请求, 怎么处理多个请求了?
 *      解决:
 *        请求的时候 带一个参数过来进行区别
 *
 *
 */
@WebServlet("/findssq")
public class SsqServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");
        System.out.println("method = " + method);

        if (method != null && method.length() > 0){

            if (method.equals("findProvince")){
                // 查询省的处理方法
                findProvince(req,resp);
            }

            if (method.equals("findCity")){
                // 查询市的处理方法
                findCity(req,resp);
            }

            if (method.equals("findTown")){
                // 查询区县的处理方法
                findTown(req,resp);
            }

        }
    }

    /**
     *  查询 区县的处理方法
     * @param req
     * @param resp
     */
    private void findTown(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取数据
        String cid = req.getParameter("cid");

        //调用service方法
        SSqService ssqService = new SSqServiceImpl();
        List<Area> citys = ssqService.findTown(Integer.parseInt(cid));

        // 回写数据
        // 给浏览器返回json
        resp.getWriter().write(JSON.toJSONString(citys));

    }

    /**
     * 查询市 的方法
     * @param req
     * @param resp
     */
    private void findCity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取数据
        String pid = req.getParameter("pid");

        //调用service方法
        SSqService ssqService = new SSqServiceImpl();
        List<Area> citys = ssqService.findCity(Integer.parseInt(pid));

        // 回写数据
        // 给浏览器返回json
        resp.getWriter().write(JSON.toJSONString(citys));

    }

    /**
     *  查询省的处理方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void findProvince(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用业务
        SSqService sqService = new SSqServiceImpl();
        List<Area> province = sqService.findProvince();

        // 给浏览器返回json
        resp.getWriter().write(JSON.toJSONString(province));
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
