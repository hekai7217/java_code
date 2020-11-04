<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0004
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>a</title>
</head>
<body>

    a page

    <%
        request.setAttribute("aaa","aaaa");
        // 转发 到b.jsp 页面   跳过拦截
        request.getRequestDispatcher("/b.jsp").forward(request,response);

    %>

</body>
</html>
