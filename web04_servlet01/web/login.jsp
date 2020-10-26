<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0024
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    login.jsp 处理登陆的业务:

        01 拿到表单提交的数据
               http://localhost:8080/web04/login.jsp?username=admin&password=123
               req,resp 在jsp页面,对象的初始化 tomcat给我们实现了,可以拿着直接使用
               request提供了方法,获取请求提交的参数
                    request.getParameter("username");
               response 提供了方法,给浏览器回写数据
                     response.getWriter()  获取拿到是输出流
                     write() 方法 给 浏览器回写 响应的结果
                     response.getWriter().write("login success");

        02 处理表单的数据
        03 jsp给 请求回写数据响应

--%>
    <%
//        01 拿到表单提交的数据
//       request 获取请求提交的数据

        // getParameter() 这个方法是红色
        //  01 jsp中 这个方法是红色的 不影响项目
        //  02 如何解决
        //     项目设置,lib中添加 tomcat的环境
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //   02 处理表单的数据
        if(username.equals("admin") && password.equals("123")){

            //  03 jsp给 请求回写数据响应
            response.getWriter().write("login success");
        }else{
            response.getWriter().write("login error");
        }
    %>

</body>
</html>
