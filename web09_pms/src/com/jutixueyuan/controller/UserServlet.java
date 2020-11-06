package com.jutixueyuan.controller;

import com.alibaba.fastjson.JSON;
import com.jutixueyuan.bean.Result;
import com.jutixueyuan.bean.User;
import com.jutixueyuan.service.UserService;
import com.jutixueyuan.service.impl.UserServiceImpl;
import com.jutixueyuan.utils.PageUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
 * <p>
 * user模块的功能都写在这里
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

        if (method != null && method.length() > 0) {

            // 分发 处理不同的 业务处理

            // 校验 用户是否存在
            if (method.equals("checkName")) {
                checkName(req, resp);
            }
            if (method.equals("addUser")) {
                addUser(req, resp);
            }
            // 查询所有
            if (method.equals("queryAll")) {
                queryAll(req, resp);
            }

            if (method.equals("delStu")) {
                delStu(req, resp);
            }

            //通过id查询user
            if (method.equals("findUserById")) {
                findUserById(req, resp);
            }

            //修改
            if (method.equals("updateUser")) {
                updateUser(req, resp);
            }
            //分页查询
            if (method.equals("pageUser")) {
                pageUser(req, resp);
            }
            // poi 导出
            if (method.equals("poi")) {
                poi(req, resp);
            }
        }

    }

    /**
     * poi 导出
     * @param req
     * @param resp
     */
    private void poi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置头信息让浏览器默认保存
        resp.setHeader("content-disposition","attachment;filename=user.xls");

        //01 拿到数据
        // 02 调用service 拿到集合数据
        UserService userService = new UserServiceImpl();
        PageUtils pageUtils = userService.pageUser(1, 20);
        // 03创建一个excel 表格
        Workbook wb = new HSSFWorkbook();
        // 04 给excel 设置数据
        Sheet sheet = wb.createSheet("班级同学录");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("用户名");
        row.createCell(1).setCellValue("真实姓名");
        row.createCell(2).setCellValue("电话");
        row.createCell(3).setCellValue("QQ号码");

        // 拿到集合中的数据
        List<User> data = pageUtils.getData();
        for (int i = 0; i < data.size(); i++) {
            User user = data.get(i);
            Row rowi = sheet.createRow(i + 1);
            rowi.createCell(0).setCellValue(user.getUsername());
            rowi.createCell(1).setCellValue(user.getRealname());
            rowi.createCell(2).setCellValue(user.getPhone());
            rowi.createCell(3).setCellValue(user.getQq());
        }
        //  把 Workbook 内存 保存到 xls 中,把 xls 往 浏览器回写

//        // 05 保存 excel表格
//        ServletContext servletContext = req.getServletContext();
//        String realPath = servletContext.getRealPath("/user.xls");
//        try  (OutputStream fileOut = new FileOutputStream(realPath)) {
//            // 把 工作本 写到 文件流中
//            wb.write(fileOut);
//        }
//
//        // 06 读取excel 表格 给 浏览器回写数据
//        InputStream is = servletContext.getResourceAsStream("/user.xls");
//        ServletOutputStream oos = resp.getOutputStream();
//        byte [] b = new byte[1024];
//        int len = 0;
//        while ((len = is.read(b)) != -1){
//            oos.write(b,0,len);
//            oos.flush();
//        }

        //  把 Workbook 内存 保存byte数组中  把byte数组 给浏览器回写

        // 选择流
        // 把文件转成 byte数组  内存流 ByteArrayOutputStream
        // 把byte数组转成文件   内存流 ByteArrayInputStream

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 把wb 的内存 写到 内存流中  ByteArrayOutputStream
        wb.write(bos);
        byte[] bytes = bos.toByteArray();

        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(bytes);

//        oos.close();
//        is.close();

        outputStream.close();
        bos.close();

    }

    /**
     * 分页查询
     *
     * @param req
     * @param resp
     */
    private void pageUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 获取数据
        String pageSizeStr = req.getParameter("pageSize");
        String currentPageStr = req.getParameter("currentPage");


        Integer pageSize = 0;
        try {
            pageSize = Integer.parseInt(pageSizeStr);
        } catch (Exception e) {
            pageSize = 10;
        }
        Integer currentPage = 0;
        try {
            currentPage = Integer.parseInt(currentPageStr);
        } catch (Exception e) {
            currentPage = 1;
        }
        // 02 调用service
        UserService userService = new UserServiceImpl();
        PageUtils pageUtils = userService.pageUser(currentPage, pageSize);
        // 03 回写数据

        if (pageUtils != null){

            // 转发到 分页jsp 页面展示
            req.setAttribute("pageUtils",pageUtils);
            req.getRequestDispatcher("/page/user/pageuser.jsp").forward(req,resp);
        }


    }

    /**
     * 修改
     *
     * @param req
     * @param resp
     */
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 获取数据

        // 01 获取页面的数据
        Map<String, String[]> map = req.getParameterMap();

        // 把map转成bean对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);
        // 添加的时候 提交了 6 条数据
        // 设置 2个数据为默认值
        user.setImg("/aaa/a.jpg");
        user.setRegtime(new Date());

        // 02 调用service
        UserService userService = new UserServiceImpl();
        boolean flag = userService.updateUser(user);

        // 03 回写数据
        Result rs = null;

        if (flag) {
            // 修改成功
            rs = new Result(600, "修改成功...");
        } else {
            // 修改失败
            rs = new Result(601, "需改失败");
        }
        resp.getWriter().write(JSON.toJSONString(rs));


    }

    /**
     * 通过id 查询 user
     *
     * @param req
     * @param resp
     */
    private void findUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 获取数据
        String id = req.getParameter("id");
        //02 调用service
        UserService userService = new UserServiceImpl();
        User user = userService.findStuById(Integer.parseInt(id));

        // 03 回写数据
        if (user != null) {

            req.setAttribute("u", user);
            // 转发    /资源路径
            // 重定向  /项目访问路径/资源路径
            req.getRequestDispatcher("/page/user/editUser.jsp").forward(req, resp);

        }


    }

    /**
     * 删除
     *
     * @param req
     * @param resp
     */
    private void delStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 拿到数据
        String id = req.getParameter("id");
        UserService userService = new UserServiceImpl();
        boolean flag = userService.delStu(Integer.parseInt(id));

        Result rs = null;

        if (flag) {
            // 删除功
            rs = new Result(500, "删除成功...");
        } else {
            // 删除失败
            rs = new Result(501, "删除失败");
        }
        resp.getWriter().write(JSON.toJSONString(rs));
    }

    /**
     * 查询所有
     *
     * @param req
     * @param resp
     */
    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 02 调用方法
        UserService userService = new UserServiceImpl();
        List<User> list = userService.queryAll();

        // 03 回写数据
        //   查询的是 所有的user 把user发送到 jsp 页面展示
        if (list.size() > 0) {
            req.setAttribute("users", list);
            req.getRequestDispatcher("/page/user/users.jsp").forward(req, resp);
        } else {
            resp.getWriter().write("查询数据为空");
        }

    }

    /**
     * 添加user
     *
     * @param req
     * @param resp
     */
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 01 获取页面的数据
        Map<String, String[]> map = req.getParameterMap();

        // 把map转成bean对象 
        User user = new User();
        try {
            BeanUtils.populate(user, map);
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
        if (flag) {
            // 添加成功
            rs = new Result(400, "用户添加成功...");
        } else {
            // 添加失败
            rs = new Result(401, "用户添加失败");
        }
        resp.getWriter().write(JSON.toJSONString(rs));

    }

    /**
     * 校验 用户是否存在
     *
     * @param req
     * @param resp
     */
    private void checkName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 01 获取参数
        String username = req.getParameter("username");
        // 02 调用service
        UserService userService = new UserServiceImpl();
        boolean flag = userService.checkName(username);

        // 03 回写数据
        Result rs = null;
        if (flag) {  // true  用户名已存在
            rs = new Result(300, "用户名已存在不能使用");
        } else {
            rs = new Result(301, "用户名可以使用");
        }

        resp.getWriter().write(JSON.toJSONString(rs));

    }
}
