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
    <title>Title</title>
</head>
<body>

<%--
     添加的细节:
     01 action 的路径问题  客户端路径 /项目访问路径/资源路径
     02 method是 post 需要注意中文乱码
     03 input的name属性值 必须和 javaBean的属性字段一致
--%>
<form action="/web07/addStu" method="post">
    <p>
        学生姓名:<input type="text" name="name"/>
    </p>
    <p>
        年龄:<input type="text" name="age"  />
    </p>
    <p>
        描述:<input type="text" name="info"  />
    </p>
    <p>
        <input type="submit"  value="添加"/>
    </p>
</form>

</body>
</html>
