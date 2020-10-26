<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0023
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

案例:
获得服务器时间和浏览器时间
<br>

页面输出服务器的时间:
<br>
<%-- 通过java代码获取 服务器的当前时间 , 页面输出就可以
     01  获取时间 Date()
     02  输出到浏览器 <%=%>
--%>
<%
    Date d = new Date();
    // 格式化:
    String serverTime = new SimpleDateFormat("yyyy_MM_dd:HH:mm:ss").format(d);
%>
<%= "服务器输出时间:" +serverTime %>

<br>
浏览器页面的时间输出:
<%--
    浏览器的时间通过js来输出:
      01 通过js获取时间
      02 通过dom给浏览器 展示数据
--%>

<!--  html注释  -->
<p id="p1"></p>

<script>

    // 拿到时间
    var d = new Date();
    var borwerTime = d.toLocaleString();

    // 拿到p1节点
   var p1Node = document.getElementById("p1");

   //修改显示文本
    p1Node.innerText = "浏览器的时间:" + borwerTime;

</script>

</body>
</html>
