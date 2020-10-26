<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0026
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        b page
    <%
        // request 是jsp的内置,不用初始化(tomcat帮我们实现了初始化)就可以直接使用
        Object key1 = request.getAttribute("key1");
        Object key2 = request.getAttribute("key2");

    %>
        <br>
    <%=key1%>
        <br>
    <%=key2%>

</body>
</html>
