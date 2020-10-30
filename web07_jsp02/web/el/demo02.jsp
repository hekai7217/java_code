<%@ page import="com.jutixueyuan.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0028
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 传统方式  --%>
<%
    // 存储一个 bean对象
    pageContext.setAttribute("u",new User("admin","admin"));
%>
<%--
    pageContex.getAttribute() 效果一样

--%>
${u}
<br>
<%-- 通过反射 拿到 的getter方法 获取数据 --%>
${u.name}
${u.pwd}

<%--
    el表达式 操作 集合 /对象 /map

    集合的el的输出:  ${域对象的隐藏对象.key[下标]}

    map的el的输出:  ${域对象的隐藏对象.map的key}

    el 没有判断,没有for循环 (el 的作用 jsp 页面输出简单)

--%>
<br>

<%
    List<String> list = new ArrayList<>();
    list.add("少林寺");
    list.add("武当");
    list.add("峨嵋");
    pageContext.setAttribute("list",list);

    Map<String,String> map = new HashMap<>();
    map.put("aa","张三丰");
    map.put("bb","宋远桥");
    map.put("cc","张翠山");

    pageContext.setAttribute("map",map);

    pageContext.setAttribute("msg","hello");
%>

${pageScope.list[0]}
${pageScope.list[2]}

<%--输出 map --%>
<br>
${pageScope.map.aa}
${pageScope.map.bb}
${pageScope.map.cc}
${pageScope.map.dd}

<%-- el中可以进行运算--%>
<br>
${ 1 + 2}
${ 1 * 2}
${ 3 > 1}
<%--  eq 等于  lt <  gt >  --%>
${ 5 eq 5}
${ 5 lt 10}
<%-- 取模--%>
${ 10 mod 3}

<br>
<%--输出字符串
    empty 判断字符串不为null
--%>
${pageScope.msg}
${empty pageScope.msg}
${empty pageScope.aaaa}

</body>
</html>
