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
    <title>循环标签便利集合map</title>
</head>
<body>

<%-- foreach 标签遍历 集合--%>
<%
    List<String> list = new ArrayList<>();
    list.add("逍遥派");
    list.add("武当");
    list.add("丐帮");
    pageContext.setAttribute("list",list);

    Map<String,String> map = new HashMap<>();
    map.put("aa","张三丰");
    map.put("bb","宋远桥");
    map.put("cc","张翠山");

    pageContext.setAttribute("map",map);
%>

<%--
items 直接从域对象获取的集合
  items中写${} 表达式
--%>
<c:forEach var="ele" items="${list}">
    <c:out value="${ele}"></c:out>
</c:forEach>

<br>
<%--变量map
    items="${map}" 从域对象中获取map 数据
    var="entry" map中每一个元素是一个entry
    ${entry.key} 获取 entry中的key
    ${entry.value} 获取 entry中的value
--%>
<c:forEach var="entry" items="${map}">
    <c:out value="${entry.key} : ${entry.value}"></c:out>
</c:forEach>

</body>
</html>
