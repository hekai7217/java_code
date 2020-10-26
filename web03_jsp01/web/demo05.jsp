<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0023
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
     jsp中
       小脚本  <% %>   都是局部变量
       表达式  <%= %>  输出 (浏览器的页面输出)
       声明式  <%! %>  可以定义成员变量 和 方法

    jsp的原理:

1. jsp的本质也是serlvet     第一次访问jsp时候,tomcat会把jsp编译成servlet ,再执行serlvet ,jsp 本质就是serlvet
2. jsp页面 第一次访问   会把jsp编译成java文件(就是servlet)
      idea 复制 的tomcat下面的work 目录中

3. 再把java代码 编译成 .class文件  创建对象
4. 调用service() 方法
5. 如果是下次请求 直接调用service()方法
6. jsp存放在 tomcat 目录下面的work下面 (idea 不一样 C:\Users\Administrator\.IntelliJIdea2019.3\system\tomcat\Tomcat_9_0_31_web01_jsp\work)
7. jsp就是serlvet 向外输出 html 标签 (重点)

--%>
<%
    int a = 10;  // 局部变量
%>

<%= a%>

<%--定义全局变量--%>
<%!
    int age = 50;

    //定义一个方法
    public String hello(){
        return "hello msg";
    }
%>

<%= age %>
<%= hello() %>



</body>
</html>
