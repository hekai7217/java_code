<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0023
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>html标签写table</h3>
<table border="1" cellspacing="0">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>地址</td>
    </tr>

    <tr>
        <td>乔峰</td>
        <td>40</td>
        <td>内蒙</td>
    </tr>

    <tr>
        <td>段誉</td>
        <td>30</td>
        <td>云南大理</td>
    </tr>

    <tr>
        <td>虚竹</td>
        <td>25</td>
        <td>河南</td>
    </tr>
</table>

<br>
jsp中java代码嵌套写html
<br>

<%
    String [] arr = {"乔峰","段誉","虚竹"};
%>

<table border="1" cellspacing="0">

    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>地址</td>
    </tr>
    <%
        for(int i = 0; i <arr.length;i++){
    %>
        <tr>
            <td><%= arr[i]%></td>
            <td>25</td>
            <td>河南</td>
        </tr>
    <%
        }
    %>
</table>


</body>
</html>
