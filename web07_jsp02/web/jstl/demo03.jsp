<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0028
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>choose 标签 </title>
</head>
<body>

<c:set var="score" value="60"></c:set>

<%--
    使用if else if 进行判断
    可以对应choose 标签
    c:when 对应是 if(){}else if(){}
--%>
<c:choose>
    <c:when test="${score >= 80}">
        <c:out value="学习很厉害"></c:out>
    </c:when>

    <c:when test="${score >= 60 && score <80 }">
        <c:out value="学习需要努力"></c:out>
    </c:when>

    <c:when test="${score >= 40 && score < 60}">
        <c:out value="加油"></c:out>
    </c:when>
<%--    都不满足 执行 other--%>
    <c:otherwise>
        <c:out value="好好努力"></c:out>
    </c:otherwise>
</c:choose>


</body>
</html>
