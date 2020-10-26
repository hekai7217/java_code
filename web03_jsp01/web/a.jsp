<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0023
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    问题:
    <br>
    01  WEB-INF 下面放到资源 浏览器中不能直接访问 (javaweb为了安全 )
    <br>
    02  web目录下面的资源才可以直接访问
    <br>
    03 如果在web目录下面 创建了文件夹,访问资源时候,访问路径需要添加 文件夹名称
       /项目访问路径/html/a.html

<%--
    html的 emm 表达式
--%>
<%--   > 子元素  --%>
    <div>
        <div>
            <ul></ul>
        </div>
    </div>

<%-- + 兄弟--%>
    <div></div>
    <table></table>

<%--     id  # 与 class  . --%>
<div class="box1"></div>
<div id="div1"></div>

<%-- {} 给标签添加文本--%>
    <p>hellp</p>
    <div>hello</div>

</body>
</html>
