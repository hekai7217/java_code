<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0028
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>循环标签</title>
</head>
<body>

<%--
    forEach 循环标签
        var  变量
        begin 开始
        end   结束
        step 每一步

--%>
<%--    使用循环标签输出 1- 10 --%>
    <c:forEach var="i" begin="1" end="10" step="2">
        <c:out value="${i}"></c:out>
    </c:forEach>

<%--    使用标签写一个循环求和 --%>

<c:set var="sum"/>
<%--
    sum += i
--%>
<c:forEach var="i" begin="1" end="5" step="1">
    <c:set var="sum" value="${sum + i}"/>
</c:forEach>
<c:out value="1- 5求和是 ${sum}"></c:out>


</body>
</html>
