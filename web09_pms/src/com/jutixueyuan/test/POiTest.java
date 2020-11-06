package com.jutixueyuan.test;

import com.jutixueyuan.bean.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-06 10:54
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  poi  是 apache  团队 封装的 java api 操作 excel/doc/ppt
 *
 *  poi的入门:
 *    参考官方文档:
 *    http://poi.apache.org/components/spreadsheet/quick-guide.html
 *    01 导入 poi 的jar
 *
 *    02 使用 poi的api
 *
 */
public class POiTest {

//    01 创建一个 excel表格
    @Test
    public void test01() throws Exception {

        // Workbook 工作本  就是指  excel表格

        Workbook wb = new HSSFWorkbook();
        // 把 excel 通过 输出流 写到 指定的文件中
        // java io中 1.7 的新写法  自动关闭io流
        try  (OutputStream fileOut = new FileOutputStream("src/a.xls")) {
            // 把 工作本 写到 文件流中
            wb.write(fileOut);
        }

    }

    //    02  创建一个 excel表格 给这个表格添加sheet
    @Test
    public void test02() throws Exception {

        // Workbook 工作本  就是指  excel表格

        Workbook wb = new HSSFWorkbook();

        // 通过wb 创建sheet
        wb.createSheet("员工信息资料");
        wb.createSheet("员工的工资情况");

        // 把 excel 通过 输出流 写到 指定的文件中
        // java io中 1.7 的新写法  自动关闭io流
        try  (OutputStream fileOut = new FileOutputStream("src/b.xls")) {
            // 把 工作本 写到 文件流中
            wb.write(fileOut);
        }
    }

    //    03 创建一个 excel表格 给这个表格添加sheet
    //    给 sheet 添加 单元格的数据
    @Test
    public void test03() throws Exception {

        // Workbook 工作本  就是指  excel表格

        Workbook wb = new HSSFWorkbook();

        // 通过wb 创建sheet
        Sheet sh = wb.createSheet("员工信息资料");

        // sheet 中可以 添加多行数据
        Row row = sh.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("姓名");
        row.createCell(1).setCellValue("年龄");
        row.createCell(2).setCellValue("分数");

        // 把 excel 通过 输出流 写到 指定的文件中
        // java io中 1.7 的新写法  自动关闭io流
        try  (OutputStream fileOut = new FileOutputStream("src/c.xls")) {
            // 把 工作本 写到 文件流中
            wb.write(fileOut);
        }
    }

    // 给 excel中添加数据
    @Test
    public void test04() throws Exception {
        //01  创建excel
        Workbook wb = new HSSFWorkbook();
        //02  创建excel 的 sheet
        Sheet sheet = wb.createSheet("员工的信息资源");
        //03  创建excel的 sheet  的 row
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("电话");
        row.createCell(2).setCellValue("邮箱");

        //04  创建excel的 sheet  的 row  的cell 设置数据
        List<User> us = new ArrayList<>();

        User u1 = new User();
        u1.setUsername("乔峰");
        u1.setEmail("111@qq.com");
        u1.setQq("1234");


        User u2 = new User();
        u2.setUsername("王语嫣");
        u2.setEmail("111@qq.com");
        u2.setQq("1234");


        User u3 = new User();
        u3.setUsername("阿朱");
        u3.setEmail("111@qq.com");
        u3.setQq("1234");

        us.add(u1);
        us.add(u2);
        us.add(u3);
        //05  添加数据
        for (int i = 0; i < us.size(); i++) {
            User u = us.get(i);
            Row row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(u.getUsername());
            row1.createCell(1).setCellValue(u.getEmail());
            row1.createCell(2).setCellValue(u.getQq());
        }

        //06  把 excel 输入到文件中
        try  (OutputStream fileOut = new FileOutputStream("src/d.xls")) {
            // 把 工作本 写到 文件流中
            wb.write(fileOut);
        }
    }


}
