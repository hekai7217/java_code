<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0028
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑stu页面</title>
</head>
<body>

<%--
    在编辑页面展示数据

    提交数据的时候,需要提交 stu的id
    通过 input的hidden属性 隐藏 提交一个 id到服务器
--%>
<form action="/web07/updateStu" method="post">
    <input type="hidden" name="id" value="${stu.id}">
    <p>
        学生姓名:<input type="text" name="name" value="${stu.name}"/>
    </p>
    <p>
        年龄:<input type="text" name="age" value="${stu.age}" />
    </p>
    <p>
        描述:<input type="text" name="info" value="${stu.info}" />
    </p>
    <p>
        <input type="submit"  value="更新学生"/>
    </p>
</form>

</body>
</html>
