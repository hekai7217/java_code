package com.jutixueyuan.demo02;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-09 14:45
 * @ desc 百战程序员 http://www.itbaizhan.com
 *
 *  dom4j 解析
 *    01  导入 dom4j 架包
 *    02  编码
 *        01 获取解析器
 *               new SAXReader(); 创建解析器
 *
 *        02 读取xml文件
 *
 *        03 获取 root节点 根节点
 *             Element rootEle = doc.getRootElement();
 *              获取root节点
 *             rootEle.getName()   获取root节点的名称
 *
 *        04 获取 root 下面的子节点的列表
 *
 *             rootEle.elements("student"); 获取root 节点下面的 子节点 student
 *              返回的是list
 *
 *        05 解析子节点
 *             Element nameNode = ele.element("name");
 *             拿到 name 节点
 *             String nameValue = nameNode.getStringValue();
 *             获取 name节点的值
 *
 *             Attribute sidArribute = ele.attribute("sid");
 *             // 拿到stu的属性节点
 *             String sid = sidArribute.getValue();
 *             获取节点属性的值
 *
 */
public class Demo01 {

    @Test
    public void readXml() throws DocumentException {

        // 01 获取解析器  注意导包
        SAXReader read = new SAXReader();

        //02  读取xml文件
        // 返回文档对象
        Document doc = read.read(new File("src/stus.xml"));

        //03 获取 root节点 根节点
        Element rootEle = doc.getRootElement();
        // 获取根节点的名称
        System.out.println(rootEle.getName());

        // 拿到 根节点下面的所有的子节点
        List<Element> stus = rootEle.elements("student");
        for (Element ele : stus) {
            System.out.println(ele.getName());
            // 拿到所有的 学生节点
            // 获取 其他的节点
            // name
            Element nameNode = ele.element("name");
            String nameValue = nameNode.getStringValue();
            System.out.println("stringValue = " + nameValue);
            // 拿到age 节点
            String age = ele.element("age").getText();
            System.out.println("age = " + age);

            // 拿到 phone 节点
            String phone = ele.element("phone").getText();
            System.out.println("phone = " + phone);

            // 拿到stu的属性节点
            Attribute sidArribute = ele.attribute("sid");
            String sid = sidArribute.getValue();
            System.out.println("sid = " + sid);
        }
    }
}
