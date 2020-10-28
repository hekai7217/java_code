<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0028
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>

<%--
     需求:
     使用 jsp / servlet / jstl + mybatis 做个增删改成的学生管理系统

     01 jsp 展示数据  (     04 jstl 在jsp 页面展示数据 )
     02 servlet 处理业务
     03 mybatis 操作db
--%>
    <title>Title</title>
</head>
<body>
    <a href="/web07/stu/addStu.jsp"> 添加 </a>
    <table border="1" cellspacing="0">

        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>描述</td>
            <td>操作</td>
        </tr>

        <c:forEach var="stu" items="${stus}">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>${stu.age}</td>
                <td>${stu.info}</td>
                <td>
                    <a href="#"> 修改 </a>
<%--                    可以通过 a标签中 在url上传递 id编号进行删除 --%>
                    <a href="/web07/delStu?id=${stu.id}">  删除 </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
