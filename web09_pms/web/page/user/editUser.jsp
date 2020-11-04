<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 项目的访问路径 pms
    String contextPath = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>
<base href="<%=basePath%>">
<html>
<head>
    <title>修改用户页面</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <script src="js/jquery.min.js">   </script>
    <script src="js/jquery.form.js">   </script>
</head>
<body>

<div class="ibox-content">
    <form  id="addFormId" method="post" action="/pms/user" class="form-horizontal">

        <%--        隐藏 hidden 提交一个 method 提交过去
                    修改需要提交id
        --%>
        <input type="hidden" name="method" value="updateUser">
        <input type="hidden" name="id" value="${u.id}">

        <div class="form-group has-success">
            <label class="col-sm-2 control-label">用户名:</label>

            <div class="col-sm-8">
                <input id="usernameId" type="text" name="username" value="${u.username}" class="form-control">
            </div>

            <div class="col-sm-2" style="line-height: 34px">
                <span id="msgUserName"></span>
            </div>
        </div>

        <div class="form-group has-success">
            <label class="col-sm-2 control-label">密码:</label>

            <div class="col-sm-8">
                <input id="passwordId" type="password"  name="password" value="${u.password}" class="form-control">
            </div>

            <div class="col-sm-2" style="line-height: 34px">
                <span  id="msgPassword"></span>
            </div>
        </div>

        <div class="form-group has-success">
            <label class="col-sm-2 control-label">真实姓名:</label>

            <div class="col-sm-8">
                <input id="realNameId" type="text"  name="realname" value="${u.realname}"  class="form-control">
            </div>
            <div class="col-sm-2" style="line-height: 34px">
                <span  id="msgRealName"></span>
            </div>
        </div>


        <div class="form-group has-success">
            <label class="col-sm-2 control-label">邮箱:</label>

            <div class="col-sm-8">
                <input id="emailId" type="text"  name="email"  value="${u.email}" class="form-control">
            </div>

            <div class="col-sm-2" style="line-height: 34px">
                <span  id="msgEmail"></span>
            </div>
        </div>


        <div class="form-group has-success">
            <label class="col-sm-2 control-label">qq:</label>

            <div class="col-sm-8">
                <input  id="qqId" type="text"  name="qq" value="${u.qq}" class="form-control">
            </div>

            <div class="col-sm-2" style="line-height: 34px">
                <span  id="msgQq"></span>
            </div>
        </div>

        <div class="form-group has-success">
            <label class="col-sm-2 control-label">电话:</label>

            <div class="col-sm-8">
                <input id="phoneId" type="text"  name="phone" value="${u.phone}" class="form-control">
            </div>

            <div class="col-sm-2" style="line-height: 34px">
                <span id="msgPhone"></span>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-5">
                <button class="btn btn-primary" type="submit">修改内容</button>
                <button class="btn btn-white" type="submit">取消</button>
            </div>
        </div>
    </form>

    <script>

        $("#addFormId").ajaxForm({
            beforeSubmit:function () {  // 在表单提交之前执行的方法

                return true;
            },
            resetForm:true,             // 表单提交之前的 重置
            dataType:"json",            // 服务器返回的数据类型
            success:function (data) {   // 成功执行从函数

                // 判断 如果修改成功 查询所有的数据
                if (data.code == 600){

                    location.href = "/pms/user?method=queryAll"
                }
                if (data.code == 601){
                    //提示 查询失败
                    alert(data.msg);
                }
            }

        });
    </script>
</div>

</body>
</html>
