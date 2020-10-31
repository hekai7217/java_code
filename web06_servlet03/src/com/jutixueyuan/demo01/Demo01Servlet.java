package com.jutixueyuan.demo01;

import com.jutixueyuan.bean.User;
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
 * @date 2020-10-27 9:31
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  01 写一个页面, 提交数据
 *  02 servlet中获取数据 把数据封装成一个javabean对象
 *     01 创建一个javabean
 *           表单提交的数据的name 的属性值 必须和javabean的属性名称一样
 *     02 req 获取提交的数据
 *           req.getParameterMap();
 *     03 使用beanUtils 把map转成bean对象
 *          01 导入jar  javaweb项目中,jar 必须导入WEB-INF下面的lib中 (tomcat加载 classes 文件只会找 WEB-INF/classes下面或者是lib中的class文件)
 *          02 使用beanUtils
 *
 *
 */
@WebServlet("/reg")
public class Demo01Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  拿到表单提交的数据
        Map<String, String[]> map = req.getParameterMap();

        User user = new User();

        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

