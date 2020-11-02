<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0002
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>查询所有的用户</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">

                <div class="ibox-content">

                    <table class="table table-bordered">
                        <tr>
                            <th>id</th>
                            <th>用户名</th>
                            <th>真实姓名</th>
                            <th>邮箱</th>
                            <th>电话</th>
                            <th>qq</th>
                            <th>注册时间</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="u" items="${users}">
                            <tr>
                                <td>${u.id}</td>
                                <td>${u.username}</td>
                                <td>${u.realname}</td>
                                <td>${u.email}</td>
                                <td>${u.phone}</td>
                                <td>${u.qq}</td>
                                <td>
                                    <a href="#">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                        修改
                                    </a>
                                    &nbsp;  &nbsp;&nbsp;&nbsp;
                                    <a onclick="delStu(${u.id},this)">
                                        <i class="glyphicon glyphicon-trash"></i>
                                        删除
                                    </a>
                                </td>
<%--
        使用格式化标签:
        01 导入标签库 fmt
             taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"
        02 使用标签库
                <fmt:formatDate value="" pattern=""></fmt:formatDate>
                value 格式化的值
                pattern 格式化的 格式 和date的格式一样 yyyy-MM-dd
                格式化 date日期 如果是java8 新的 DataTime LocalDate 不能格式化
    --%>
                                <td>
                                    <fmt:formatDate value="${u.regtime}" pattern="yyyy-MM-dd:HH:mm:ss"></fmt:formatDate>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
        </div>
    </div>
</div>

<script>

    // obj 是当前的 点击的 删除a标签
    function delStu(id,obj){

        $.post(
            "/pms/user",             // 请求的url
            {method:"delStu",id:id}, // 发送数据
            function (data){         // 请求成功执行的函数
                console.log(data);
                if (data.code == 500){
                    // 删除成功
                    alert(data.msg);

                    // 进行dom操作  删除这个一行的 tr
                    //  $(obj).parent() 拿到删除的a表 的 td
                    //   $(obj).parent().parent() 拿到删除的a表 的 td 的fu父节点 tr
                    // remove 删除
                    $(obj).parent().parent().remove()

                }
                if (data.code == 501){
                    // 删除失败
                    alert(data.msg);
                }

            },
            "json"                   // 返回结果的数据
            );
    }
</script>


</body>

</html>
