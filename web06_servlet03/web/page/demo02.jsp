<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0027
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户端路径</title>
</head>
<body>

    绝对路径<br>
    <form action="http://localhost:8080/web06/page/a.jsp" method="get">
        用户名:<input type="text" name="name"> <br>
        密码:<input type="password" name="pwd"> <br>
        手机:<input type="text" name="phone"> <br>
        邮箱:<input type="text" name="email"> <br>
        <input type="submit" value="注册1">
    </form>

    相对路径:<br>
    <form action="/web06/page/a.jsp" method="get">
        用户名:<input type="text" name="name"> <br>
        密码:<input type="password" name="pwd"> <br>
        手机:<input type="text" name="phone"> <br>
        邮箱:<input type="text" name="email"> <br>
        <input type="submit" value="注册2">
    </form>

    相对路径2<br>
    <form action="a.jsp" method="get">
        用户名:<input type="text" name="name"> <br>
        密码:<input type="password" name="pwd"> <br>
        手机:<input type="text" name="phone"> <br>
        邮箱:<input type="text" name="email"> <br>
        <input type="submit" value="注册3">
    </form>

</body>
</html>
