<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
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
    <title>varState属性</title>
</head>
<body>

<%-- foreach 标签遍历 集合--%>
<%
    List<String> list = new ArrayList<>();
    list.add("逍遥派");
    list.add("武当");
    list.add("丐帮");
    pageContext.setAttribute("list",list);
%>

<%--
        items 从域对象中获取 集合
        varStatus 循环遍历的状态
            属性: first 第一个        返回的是 obj
            属性: last  最后一个      返回的是 obj
                 current  当前的对象  返回的是object
                  index 下标         返回的是下标
                  count  统计       返回统计的个数(遍历了多个个)
     --%>
<c:forEach varStatus="vs" items="${list}">

    <c:if test="${vs.first}">
        <c:out value="${vs.current}"></c:out>
        <c:out value="${vs.index}"></c:out>
    </c:if>
    <c:if test="${vs.last}">
        <c:out value="${vs.current}"></c:out>
        <c:out value="${vs.count}"></c:out>
    </c:if>

</c:forEach>


</body>
</html>
