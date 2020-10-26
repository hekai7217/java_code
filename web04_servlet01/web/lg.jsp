<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0024
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<!--

     form 定义表单
     action 表单数据提交到服务器的位置
          把数据提交到一个jsp 页面,通过jsp 页面处理表单提交的数据
          login.jsp 在login.jsp页面出登陆的数据
     method 表单提交方式的 方法 get  参数直接在url上进行拼接
-->
<h3>登陆页面</h3>
<form action="login.jsp" method="get">
    name:<input type="text" name="username"><br>
    pwd:<input type="text" name="password"><br>
    <input type="submit" value="登陆">
</form>

</body>
</html>