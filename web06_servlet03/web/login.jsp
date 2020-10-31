<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0027
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login 页面 </title>
</head>
<body>

<%--
    01 登陆    把数据提交到login serlvet中,实现页面跳转到success.jsp
              失败 转发到 login.jsp

    02   记住密码
          01 如果checkbox 勾选了   发送到服务器数据
          02 判断是否登陆, 判断 是否记住密码
             01 如果记住密码了    使用cookie 保存用户名和密码
             02  如果没有记住密码  不存储用户名和密码

          03 如果再次访问 login.jsp
               从 cookie中获取用户名密码
                     把用户和密码 填充在input标签上
--%>

<%

    // 获取cookie中的值
    // 获取所有的cookie

    String msg = (String) request.getAttribute("msg");
    String name = "";
    String pwd = "";
    String ch = "";  // 如果存在 用户或者密码 肯定记住了密码

    if(msg != null && msg.equals("error") ){

    }else{
        Cookie[] cs = request.getCookies();
        if (cs != null) {
            for (Cookie c : cs) {
                // 判断是否存在 name/pwd
                if (c.getName().equals("name")){
                    name = c.getValue();
                    ch = "checked";
                }
                if (c.getName().equals("pwd")){
                    pwd = c.getValue();
                }
            }
        }
    }
%>

<form action="login">
    <p>
        用户名:<input type="text" id="uname" name="name" value="<%= name%>" />
    </p>
    <p>
        密码:<input type="text" name="pwd" value="<%=pwd%>" />
    </p>
    <p>
        <input type="checkbox" name="ch" value="yes" <%=ch%>/>记住密码
    </p>
    <p>
        <input type="submit"  value="登录"/>
    </p>
</form>

</body>
</html>
