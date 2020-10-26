<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0023
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

统计网站访问人数
<br>

<%--
    定义一个变量,你每次访问, 变量 ++ 就可以
     页面输出
    --%>
<%--<%--%>
<%--    int count = 0 ;--%>
<%--    count ++;--%>
<%--%>--%>

<%--定义全局变量--%>
<%!
    int count = 0;
%>

<%--每次访问都是 ++  --%>
<%
    count++;
%>
<%--
    统计的人数 count 都是局部变量, 每次重写访问的时候调用service方法
    count 会重置为 0 通过的时候 都是1个人
    解决:
    把count 定义为全局变量:
--%>
<%= "统计网站的访问人数:" + count%>

</body>
</html>
