<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0023
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    静态的包含和动态的包含:
    如果有一个显示布局在很多页面需要用到, 可以把 个页面单独的写一个a页面,在其他页面引入这个a页面
    jsp中引入公共的页面:
     01 可以静态的包含:  <%@include file="head.jsp" %>
     02 可以动态的包含:   <jsp:include page="head.jsp"></jsp:include>


--%>
<%-- 静态的引入 head.jsp 页面到 当前的页面中  --%>
<%--<%@include file="head.jsp" %>--%>

<%--动态的引入  --%>
<jsp:include page="head.jsp"></jsp:include>

<h1>content page</h1>

</body>
</html>
