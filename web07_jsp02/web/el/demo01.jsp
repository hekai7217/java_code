<%@ page import="com.jutixueyuan.User" %><%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0028
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式</title>
</head>
<body>

<%-- 传统方式  --%>
<%
    pageContext.setAttribute("msg","hello");

    // 存储一个 bean对象
    pageContext.setAttribute("u",new User("admin","admin"));
%>
<%= pageContext.getAttribute("msg")%>
<%= pageContext.getAttribute("key1")%>

<br>
<%--
  el表达式: 使jsp 输出更加简单
  jsp的域对象  pageContext 对应的   el表达式中的 pageScope
  jsp的域对象  application 对应的   el表达式中的 applicationScope
   el的语法: ${域对象.key}
    --%>
  ${pageScope.msg} <br>
  ${pageScope['msg']}
<%--
    el和 传统写法
    el 数据不存在 不输出
    传统写法,数据不存在 返回null
--%>
  ${pageScope.key1}

<br>
<%--
    el表达式  输出 对象
--%>
${pageScope.u}
<br>
<%-- el可以输出对象的属性
     ${域对象.key.对象属性}
--%>
<br>
${pageScope.u.name}
${pageScope.u.pwd}

<%--
    从 4个 隐藏对象 ( pageScope (pageContext)/ requestScope (request) )
    pageScope < requestScope < sessionScope < applicationScope
    findAttribute() 方法同等
--%>
<br>
${u}

</body>
</html>
