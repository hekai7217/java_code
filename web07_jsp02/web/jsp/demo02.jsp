<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0028
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象</title>
</head>
<body>

<%--
    写jsp的内置对象 一定要在 <%%>
    out内置对象 就是输出对象: 对应的是 表达式<%= %>
--%>

<%
    // 网页页面输出内容
    out.write("hello msg");
%>
<%= "hello " %>

<%--
    pageContext  域对象  只能jsp 页面使用,不能在servlet中使用
    数据共享只能在 jsp 前页面中可以使用，是最小的范围
    方法 和其他的域对象的方法一样:
    setAttribute("key","aaa")
    getAttribute("key")
--%>

<%
    // 设置数据
    pageContext.setAttribute("key1","hello");
    pageContext.setAttribute("key2",new Date());
%>
<br>
<%
    // 获取数据
    String str = (String) pageContext.getAttribute("key1");
    out.write(str);
    Date d = (Date) pageContext.getAttribute("key2");
    out.write(d.toString());
%>
<br>
<%--
    pageContext 可以操作其他的域对象
    pageContex.setAttribute("key","value",inte scope)
--%>
<%
    // 把 key3 的数据 设置到req 的域对象中
    pageContext.setAttribute("key3","湖人",PageContext.REQUEST_SCOPE);
    // 把 key4 的数据 设置到session的域对象中
    pageContext.setAttribute("key4","热火",PageContext.SESSION_SCOPE);
%>

<%
    String key3 = (String) request.getAttribute("key3");
    String key4 = (String) session.getAttribute("key4");
    out.write(key3);
    out.write(key4);
%>

<%--
    findAttribute()  从 4个域对象中找数据
        依次为pageContent、request、session、application。
        如果在前一个范围内查找到数据，那么就返回，而不会在到下一个范围中去查找！
--%>
<br>
<%
    String value = (String) pageContext.findAttribute("key4");
    out.write(value);
%>
<%--
    总结:
     pageContext 域对象:
       01 只能在jsp中使用
       02  可以把数据存储到其他的域对象中
--%>
</body>
</html>
