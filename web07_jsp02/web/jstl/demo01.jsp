<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0028
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    taglib 标签库
    prefix 前缀  的名称可以随便写 规范写c
    uri    引入指定的标签库  不需要记  idea 会提示 引入指定的标签库
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>jstl 表达式</title>
</head>
<body>

<%--
    jstl是 apache 对el表达式进行扩展的 第三方的工具类, jstl 是标签语言
    使用jstl 需要导包
    使用jstl步骤:
     01 导入 jar 包
     02 在jstl 引入 标签库

     set 和out标签
     set 标签 设置   var 设置变量名称   value 设置值
     out 标签输出    value是输出的值
                          可以输出指定的值
                          也可以输出${表达式}
    --%>
    <c:set var="a" value="hello"></c:set>
    <c:out value="hello jstl"></c:out>
<br>
    <c:out value="${a}"></c:out>

    <c:out value="${b}" default="sn夺冠"></c:out>

<%--    设置变量(c是域对象中的attribute中的key) c --%>
    <c:set var="c" value="hello c"></c:set>
<%--  输出c --%>
    <c:out value="${c}"></c:out>
<%-- 移除 变量 c --%>
    <c:remove var="c"></c:remove>
<%-- 输出变量c  --%>
    <c:out value="${c}"></c:out>

</body>
</html>
