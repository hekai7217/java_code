<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0026
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试 req获取提交的数据</title>
</head>
<body>

<form action="/web05/request02" method="get">
    name:<input type="text" name="name"><br>
    pwd:<input type="password" name="pwd"><br>

    <br>
    爱好: <input type="checkbox" value="play" name="fav"> 打游戏
    <input type="checkbox" value="code" name="fav"> 写代码
    <input type="checkbox" value="sleep" name="fav"> 睡觉
    <input type="checkbox" value="eat" name="fav"> 吃<br>

    <input type="submit" value="登录">
</form>

</body>
</html>
