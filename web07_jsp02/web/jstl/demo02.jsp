<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0028
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
    jstl 中的标签库
      if 标签
         判断标签 (和mybatis的动态sql 中的if 一样 )
       test 中写 表达式,如果表达式结果为true 就执行 if标签总的代码
       if标签没有else 和 java中的if一样
    --%>
    <c:if test="${30 > 10}">
        <c:out value="不在年轻了..."></c:out>
    </c:if>

    <c:set var="money" value="5"></c:set>

    <c:if test="${money == 100}">
        <c:out value="吃kfc..."></c:out>
    </c:if>
    <c:if test="${money == 90}">
        <c:out value="吃水饺..."></c:out>
    </c:if>
    <c:if test="${money  == 5 }">
        <c:out value="泡面..."></c:out>
    </c:if>

</body>
</html>
