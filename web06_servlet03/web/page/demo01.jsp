<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0027
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户端路径</title>
</head>
<body>

<%--
      客户端路径:
        绝对路径:       http://localhost:8080/web06/page/a.jsp
        相对路径 /      / 是个相对服务器的路径,   http://localhost:8080 从服务器后面开始

        相对路径 没有斜杠  从当前的文件夹中的路径开始( http://localhost:8080/web06/page) a.jsp

        如果是在web目录结构下面:
        <form action="reg" method="get">
            <input type="submit" value="注册">
        </form>
         reg 这里这个路径是当前项目的项目访问路径下面开始找reg这个url (找web.xml中配置的/reg 或者是 servlet注解上面的配置/reg)

        路径的选择:
            绝对路径: 太长了
            相对路径 /   用的多
            相对路径 没有斜杠   (用的少文件位置发生了变化,相对路径都出现错误)

        如果路径问题出错了: 如何解决
            01 报 404   查看url的.修改路径
            常见的错误01:
              <a href="/web06/page/a.jsp"> 相对路径1</a> 少写/
            常见的错误02:
              <a href="/a.jsp"> 相对路径2</a> 相对路径  多写/
--%>
<a href="http://localhost:8080/web06/page/a.jsp"> 绝对路径</a>
<br>
<a href="/web06/page/a.jsp"> 相对路径1</a>
<br>
<a href="a.jsp"> 相对路径2</a>
<br>

练习: <br>
<a href="http://localhost:8080/web06/demo01.jsp"> 练习1</a>
<br>
<a href="/web06/demo01.jsp"> 练习2</a>
<br>
<%--  当前的目录是 http://localhost:8080/web06/page   ..的操作是上一级   http://localhost:8080/web06/demo01.jsp
  --%>
<a href="../demo01.jsp"> 练习3</a>

<br>
练习2:
<br>
<a href="http://localhost:8080/web06/path01"> 练习1</a>
<br>
<a href="/web06/path01"> 练习2</a>
<br>
<a href="../path01"> 练习3</a>


</body>
</html>
