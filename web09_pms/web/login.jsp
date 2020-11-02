<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0031
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">

    <title>物业管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <script src="/pms/js/jquery.min.js">   </script>
<%--
    jquery.form.js 的扩展,基于,jquery  一定要要jquery的环境 才可以使用 form, 要在form之前导入jquery
--%>
    <script src="/pms/js/jquery.form.js">
    </script>
</head>

<body class="signin">
<div class="signinpanel">

<%--
        class="row" 是 bootstrap 前端的css 的框架的栅栏系统
        bootstrap,简洁、直观、强悍的前端开发框架，让web开发更迅速、简单。

        Bootstrap 提供了一套栅格系统,系统会自动分为最多12列
        栅格系统用于通过一系列的行（row）与列（column）的组合来创建页面布局，
        你的内容就可以放入这些创建好的布局中。
        栅格系统中的列是通过指定1到12的值来表示其跨越的范围
        如果超过了12  会自动换行

--%>
    <div class="row">

<%--        <div class="row">--%>

<%--            <div class="col-sm-6">div1</div>--%>
<%--            <div class="col-sm-3">div2</div>--%>
<%--            <div class="col-sm-3">div3</div>--%>

<%--        </div>--%>

        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>欢迎使用</h1>
                </div>
                <div class="m-b"></div>
                <h4>巨梯学院 <strong>中央绿地广场物业办公系统</strong></h4>
                <ul class="m-b">
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一:所有的人都在上面写blog</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二：提供免费的学习资料</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三：今天你写blog了吗</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                </ul>
                <strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>
            </div>
        </div>
<%--
        表单的登录, 把数据发送到服务器, 服务器给我们完成数据校验, 页面的跳转是  服务器( 转发或者是重定向 )

        我的数据提交后,页面的跳转 页面自己完成
        可以使用ajax实现 (表单不能用ajax提交数据 )
        通过表单使用ajax 提交数据, 第三方的框架 jquery.form.js 框架,可以使用 ajax提交表单的数据
        01 需要导入 jquery的框架
        02 需要导入 query.form.js 的框架


--%>
        <div class="col-sm-5">
            <form  id="loginId" method="post" action="/pms/login">
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md">物业管理系统</p>
                <div class="form-group has-error">
                    <label class="control-label" for="inputError1" id="inputErrorid">欢迎使用本系统！</label>
                </div>
                <input id="nameId" type="text" name="username" value="admin" class="form-control uname" placeholder="用户名" />
                <input id="pwdId" type="password" name="password" value="admin" class="form-control pword m-b" placeholder="密码" />
                <input id="verifycodeid" style="color: black;" type="text" name="verifycode" maxlength="4" class="form-control  code	" width="50%" placeholder="验证码" />
                <span>
                    	<img  src="/pms/code" id="verId">
                </span>
                <a href="javascript:void(0)" id="verId2">看不清？点击图片更换</a>
                <a href="">忘记密码了？</a>
                <button class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 2020 All Rights Reserved. 巨梯学院
        </div>
    </div>
</div>

<script>
     // 验证码 看不清 点击验证码 验证刷新
    //   01 给验证添加点击事件, 修改src 属性就可以
    $("#verId,#verId2").click(function () {

        // 修改src 属性
        // 浏览器如果是 同一个请求  使用缓存,不会发送新的请求
        // 可以 欺骗 浏览器 设置参数 告诉它 这是一个新的请求
        $("#verId").attr("src","/pms/code?time=" + new Date())

    });
    // query.form.js 的用法
    //  ajaxForm({setting})    表单使用ajax 提交数据
    //  beforeSubmit   在表单提交之前执行的方法
     // resetForm      提交后表达数据的重置
     // resetForm      提交后表达数据的重置
     // dataType       返回的数据类型是json
     // success        请求成功的执行函数

     $("#loginId").ajaxForm({
         beforeSubmit:function(){ // 提交之前执行的方法true 就是提交 false不提交

             // 如果 输入框没有输入内容 提示不能为null
            var name = $("#nameId").val();
            var pwd = $("#pwdId").val();
            var code = $("#verifycodeid").val();

            if (name.length == 0 || pwd.length == 0 || code.length == 0){

                alert("输入框不能为空")
                return  false;
            }
             return true;
         },
         resetForm:true, // 提交后表达数据的重置
         dataType: "json", //返回的数据类型是json
         success:function(data){  // 请求成功的方法
             console.log(data);
             if (data.code == 200){ //成功
                 alert(data.msg);
                 // 页面跳转
                 //跳转到主页
                 location.href = "/pms/index.jsp";
             }
             if (data.code == 201){ //用户名或者密码错误
                    alert(data.msg);
             }
             if (data.code == 202){ // 验证码错误
                 alert(data.msg);
             }

         }
     });

</script>

</body>

</html>
