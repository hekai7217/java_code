<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0028
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面 </title>
</head>
<body>

<%--  展示 登录 成功的用户
      从session中获取 name
      session 是  jsp 的内置对象,可以直接使用的对象
 --%>
    <%
        Object name = session.getAttribute("name");
        if (name != null){
    %>
    <%=name +"登录" %>
    <%
        }
    %>
</body>
</html>
