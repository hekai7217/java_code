<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0023
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
     jsp 是java服务器的动态网页技术
        jsp中可以写:
            01 可以写html
            02  jsp中可以写 java代码

        注解:
         <%-  -%>  这个是 jsp 的注解
         <!-- -->  这个是 html的注解
         //        这个是 java 的注解  在jsp中使用 // 这个注解必须是在 java代码片段中写

--%>


<%
    // 这里可以写 多条java代码片段
    // 多个  java脚本 标签 中的java代码变量可以共享
    String a = "hello";
    int b = 20;
%>

<%
    if(b > 10){
        // 服务器控制台的输出
        System.out.println("hello");
        System.out.println("hello1234");
    }
%>

<%--如果需要页面输出  需要 jsp的输出表达式--%>
<%-- <%=%> 这个属性是java表达式的输出  这个输出是  输出到客户端浏览器页面  --%>
<%= a %>
<%= b %>

</body>
</html>
