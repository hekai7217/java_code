package com.jutixueyuan.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.*;

/**
 * @author 黄药师
 * @date 2020-11-06 14:48
 * @desc 百战程序员 http://www.jutixueyuan.com
 *
 *  poi的读的方法
 */
public class Poi2Test {

    @Test
    public void test01() throws IOException {

        //通过一个输入流 创建一个 workbook
        Workbook wb = new HSSFWorkbook(new FileInputStream("src/d.xls"));
//        Workbook workbook1 = WorkbookFactory.create(new File("src/d.xls"));

        // 拿到工工作空间
        Sheet sheet = wb.getSheetAt(0);

        // sheet 拿到行
        // 拿到指定的行
//        Row row = sheet.getRow(1);
        // 拿到多少行
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {
            // 拿到指定的每一行
            Row row = sheet.getRow(i);
            // 拿到 最后一个cell 的num
            int lastCellNum = row.getLastCellNum();
            // 拿到指定的 每一个cell
            for (int j = 0; j < lastCellNum; j++) {
                Cell cell = row.getCell(j);
                // 通过判断 cell 的数据类型拿到数据
                // 这里判断省略
                String stringCellValue = cell.getStringCellValue();
                System.out.print(stringCellValue + "\t");
            }
            // 每一行数据换行
            System.out.println();
        }
    }
}
