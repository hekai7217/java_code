<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0004
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
</head>
<body>

<%--
       图片上传的要求:
         01 必须是表单
         02 图片上传 必须是post
         03 图片上传 需要设置 enctype 数据类型 多文件数据表单数据  enctype="multipart/form-data"
         04 表单中 type=file 数据
--%>
    <form action="/pms/load" method="post" enctype="multipart/form-data">

        name:<input type="text" name="name"><br>
        pic <input type="file" name="pic"> <br>

        <input type="submit">
    </form>

</body>
</html>
