<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0026
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Object msg = request.getAttribute("msg");
    if (msg != null){
%>
<%=msg%>
<%
    }
%>

<form action="/web05/login" method="get">
    name:<input type="text" name="name"><br>
    pwd:<input type="password" name="pwd"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
