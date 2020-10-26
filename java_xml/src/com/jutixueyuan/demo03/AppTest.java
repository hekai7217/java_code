package com.jutixueyuan.demo03;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;

/**
 * @author 黄药师
 * @date 2020-10-09 15:27
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class AppTest {

    @Test
    public void test() throws Exception {

        // 解析xml
        Document doc = new SAXReader().read(new File("src/web.xml"));
        Element servlet = doc.getRootElement().element("servlet");
        String classPath = servlet.element("servlet-class").getText();
        System.out.println("classPath = " + classPath);
        String method = servlet.element("method").getText();
        System.out.println("method = " + method);
        // 通过反射创建对象 调用方法
        Class<Servlet> clazz = (Class<Servlet>) Class.forName(classPath);
        //创建了对象
        Servlet serv = clazz.newInstance();
        // 拿到方法
        Method methodObj = clazz.getDeclaredMethod(method);
        //反射调用 方法
        methodObj.invoke(serv);
    }

}
