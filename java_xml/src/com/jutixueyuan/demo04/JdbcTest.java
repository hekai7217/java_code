package com.jutixueyuan.demo04;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.sql.*;

/**
 * @author 黄药师
 * @date 2020-10-09 15:38
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class JdbcTest {

    /**
     *    jdbc如果用了 EmpMapper.xml 的好处
     *      01  sql 和  jdbc代码进行了分离  好维护 扩展
     *      02  jdbc 操作的时候 返回结果处理很麻烦 如果配置了
     *           resultType="com.jutixueyuan.demo04.Emp" 返回结果 处理起来比较简单
     *
     *     我们有一个很好的jdbc的框架:
     *       mybatis, 可以 把代码和 sql 进行分离解耦,操作jdbc变的更加简单
     *
     * @throws Exception
     */
    @Test
    public void demo01() throws Exception {

        // 获取conn
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test01",
                "root",
                "root");

        // 解析 xml 获取sql

        // 解析xml
        Document doc = new SAXReader().read(new File("src/EmpMapper.xml"));
        Element servlet = doc.getRootElement().element("select");

        String resultType = servlet.attribute("resultType").getText();
        System.out.println("resultType = " + resultType);
        String sql = servlet.getText();
        System.out.println("sql = " + sql);

        // sql 准备好了

        // 获取ps 对象
        PreparedStatement ps = conn.prepareStatement(sql);

        // 执行
        ResultSet rs = ps.executeQuery();

        // 元数据
//        ResultSetMetaData metaData = rs.getMetaData();
        // 列数
//        int columnCount = metaData.getColumnCount();

        //拿到列名 + ResultSet 封装成指定对象

        // 通过 metaData 拿到每一列的列名
        // 拿到列名 /  ResultSet  可以拿到每一列的值
        // ResultSet  可以拿到每一列的值 反射 把这个值赋值给  resultType

        // 处理结果
        while (rs.next()){
            // 反射创建一个对象
            Class<Emp> clazz = (Class<Emp>) Class.forName(resultType);
            Emp emp = clazz.newInstance();

            // select id uid,name uname from t_emp

            // 获取数据
            int id = rs.getInt("uid");
            int age = rs.getInt("age");
            String name = rs.getString("uname");

            // 把 数据的数据封装到 emp 对象中

            emp.setId(id);
            emp.setName(name);
            emp.setAge(age);
            System.out.println("emp = " + emp);
        }
        // 资源关闭
        rs.close();
        ps.close();
        conn.close();
    }


}
