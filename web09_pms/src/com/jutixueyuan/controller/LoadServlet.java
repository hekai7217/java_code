package com.jutixueyuan.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-04 14:45
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
@WebServlet("/load")
public class LoadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 下载图片
//        loadImage(resp);
//        getFormContext(req);

        // 解析 表单提交的数据

        // 01  需要 导入 第三方的 fileUpload.jar / io.jar

        // 02 需要 按照 人家提供您的方式来解析 数据
        // 创建磁盘工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        String path = "C:/img";
        //配置图片的保存位置
        File repository = new File(path);
        // 设置磁盘工程图片保存的位置
        factory.setRepository(repository);
        // 图片解析 ServletFileUpload 对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析 req
        try {
            List<FileItem> items = upload.parseRequest(req);

            // 遍历 items
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) { // 判断 是否是表单数据
//                    processFormField(item);
                    String name = item.getFieldName(); // 字段的名称
                    System.out.println("name = " + name);
                    String value = item.getString();   // 提交字段的值
                    System.out.println("value = " + value);

                } else {
//                    processUploadedFile(item); // 判断是否是文件

                    String fieldName = item.getFieldName();
                    System.out.println("fieldName = " + fieldName); // 字段名称
                    String fileName = item.getName();
                    System.out.println("fileName = " + fileName);  // 文件名称
                    long sizeInBytes = item.getSize();
                    System.out.println("sizeInBytes = " + sizeInBytes); // 文件的大小

                    //把图片保存起来

                    //fileName 文件的名称
                    // fileName通过 file 拿到  文件的后缀  a8.jpg

                    String fName = getTime();
                    // 拿到 文件的后缀 截取  .jpg
                    // 拿到 最后一个 .的下标
                    int index = fileName.lastIndexOf(".");

                    // 截取 后缀
                    String p = fileName.substring(index);
                    System.out.println(p);

                    // 新文件的名称
                    String picName = fName + p;

                    // 通过 parentPath 创建一个文件
                    // 存储文件的名称 和存储的位置
                    File uploadedFile = new File(path,picName);

                    // 把 item 数据存储到 文件中
                    item.write(uploadedFile);
                    System.out.println("图片解析完毕...");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    /**
     *  获取表单 提交的内容
     * @param req
     * @throws IOException
     */
    private void getFormContext(HttpServletRequest req) throws IOException {
        // 拿到 表单提交的数据
        ServletInputStream is = req.getInputStream();
        // 把输入 写到一个文件中观察
        FileOutputStream fis = new FileOutputStream(new File("c:/a.txt"));
        byte [] b = new byte[1024];
        int len = 0;
        while ((len = is.read(b)) != -1){
            fis.write(b,0,len);
            fis.flush();
        }
        fis.close();
        is.close();
        System.out.println("图片 保存完毕...");
    }

    /**
     * 下载图片
     * @param resp
     * @throws IOException
     */
    private void loadImage(HttpServletResponse resp) throws IOException {
        // resp 设置头信息
        //  激活 浏览器的下载对话框  告诉浏览器  收到了文件 自动 下载保存文件
        // filename 是保存文件的 名称
        resp.setHeader("content-disposition","attachment;filename=a8.jpg");

        // 下载图片
        // 01 读取要下载的图片
        InputStream is = getServletContext().getResourceAsStream("/img/a8.jpg");
        //02 通过 io流给浏览器回写
        ServletOutputStream oos = resp.getOutputStream();
        // io操作 给 浏览器回写 图片文件
        byte []  b = new byte[1024];
        int len = 0;
        while ((len = is.read(b)) != -1) {
            oos.write(b,0,len);
            oos.flush();
        }

        oos.close();
        is.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
