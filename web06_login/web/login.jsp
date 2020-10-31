<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0027
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<%--
       整合jsp serlvet + 数据库 + mybatis实现一个登录的操作

       整合mybatis
       01 搭建环境
         1.1 添加mybatis的jar
         1.2 添加配置文件
         1.3 数据库准备好

      02  写jsp的登录页面

      03 servlet 处理登录操作
           需要调用mapper层代码  (mapper的实现)

      04 返回结果
--%>

<form action="login">
    <p>
        用户名:<input type="text" name="name"/>
    </p>
    <p>
        密码:<input type="text" name="pwd"  />
    </p>
    <p>
        <input type="submit"  value="登录"/>
    </p>
</form>

</body>
</html>
