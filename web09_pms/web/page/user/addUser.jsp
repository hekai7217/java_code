<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 项目的访问路径 pms
    String contextPath = request.getContextPath();
    // request.getScheme()  协议          http
    // request.getServerName() 服务器名称  localhost
    // request.getServerPort() 端口       8080

    // 把上面的字符串进行拼接   动态的获取项目访问的根路径:http:localhost:8080/pms
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>
<%-- <base> 标签为页面上的所有链接规定默认地址或默认目标--%>
<base href="<%=basePath%>">
<html>
<head>
    <title>添加用户页面</title>

<%--    路径问题:
        01 /项目访问路径/指定的资源
        02 jsp中 可以动态的获取路径
           设置相对路径
--%>
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

<%--        隐藏 hidden 提交一个 method 提交过去 --%>
        <input type="hidden" name="method" value="addUser">

        <div class="form-group has-success">
            <label class="col-sm-2 control-label">用户名:</label>

            <div class="col-sm-8">
                <input id="usernameId" type="text" name="username" class="form-control">
            </div>

            <div class="col-sm-2" style="line-height: 34px">
                <span id="msgUserName"></span>
            </div>
        </div>

        <div class="form-group has-success">
            <label class="col-sm-2 control-label">密码:</label>

            <div class="col-sm-8">
                <input id="passwordId" type="password"  name="password" class="form-control">
            </div>

            <div class="col-sm-2" style="line-height: 34px">
                <span  id="msgPassword"></span>
            </div>
        </div>

        <div class="form-group has-success">
            <label class="col-sm-2 control-label">真实姓名:</label>

            <div class="col-sm-8">
                <input id="realNameId" type="text"  name="realname"  class="form-control">
            </div>
            <div class="col-sm-2" style="line-height: 34px">
                <span  id="msgRealName"></span>
            </div>
        </div>


        <div class="form-group has-success">
            <label class="col-sm-2 control-label">邮箱:</label>

            <div class="col-sm-8">
                <input id="emailId" type="text"  name="email"  class="form-control">
            </div>

            <div class="col-sm-2" style="line-height: 34px">
                <span  id="msgEmail"></span>
            </div>
        </div>


        <div class="form-group has-success">
            <label class="col-sm-2 control-label">qq:</label>

            <div class="col-sm-8">
                <input  id="qqId" type="text"  name="qq"  class="form-control">
            </div>

            <div class="col-sm-2" style="line-height: 34px">
                <span  id="msgQq"></span>
            </div>
        </div>

        <div class="form-group has-success">
            <label class="col-sm-2 control-label">电话:</label>

            <div class="col-sm-8">
                <input id="phoneId" type="text"  name="phone"  class="form-control">
            </div>

            <div class="col-sm-2" style="line-height: 34px">
                <span id="msgPhone"></span>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-5">
                <button class="btn btn-primary" type="submit">保存内容</button>
                <button class="btn btn-white" type="submit">取消</button>
            </div>
        </div>
    </form>

<%--    <form class="form-horizontal">--%>
<%--        <div class="form-group">--%>
<%--            <label for="inputEmail3" class="col-sm-2 control-label">用户名:</label>--%>
<%--            <div class="col-sm-10">--%>
<%--                <input type="email" class="form-control" id="inputEmail3" placeholder="Email">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>--%>
<%--            <div class="col-sm-10">--%>
<%--                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <div class="col-sm-offset-2 col-sm-10">--%>
<%--                <button type="submit" class="btn btn-default">Sign in</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </form>--%>

    <script>

        // 添加之前  校验 用户名是否存在
        //思路: 01 input添加blur事件,把输入的用户名发送到服务器
        //     02  拿到服务器回写的数据, 进行dom操作 修改提示信息

        $("#usernameId").blur(function () {

            // 检查 用户名是否存在
            checkName();
        })

        // 完成表单校验

        // 用ajax提交数据
        //  导入 jquery.form.js 框架

        $("#addFormId").ajaxForm({
            beforeSubmit:function () {  // 在表单提交之前执行的方法

                //没有写 用户名校验
                // ajax的操作 要使用同步
                var checkNameFlag = checkName();

                // 进行表单校验
                // 密码的校验
                //密码6-8位,前2位一定要是字母"
                // 正则: /^[a-zA-z]{2}\w{4,6}$/
                var  pwdReg = /^[a-zA-z]{2}\w{4,6}$/;
                var pwdFlag = checkInputUtil("#passwordId","#msgPassword",pwdReg,"密码格式正确","密码格式错误");

                //真实姓名
                // 正则中有 模式
                // i  忽略大小写
                // g  全局配置
                var realNameReg = /^([\u4e00-\u9fa5]){2,8}$/;
                var realFlag = checkInputUtil("#realNameId","#msgRealName",realNameReg,"真实姓名格式正确","真实姓名格式错误");

                // 邮箱
                var emailReg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                var emailFlag = checkInputUtil("#emailId","#msgEmail",emailReg,"邮箱格式正确","邮箱格式错误");

                // 电话
                var  phoneReg =  /^1(3|4|5|7|8)\d{9}$/;
                var phoneFlag = checkInputUtil("#phoneId","#msgPhone",phoneReg,"电话格式正确","电话格式错误");

                // qq
                var qqReg = /[1-9][0-9]{4,10}/;
                var qqFlag = checkInputUtil("#qqId","#msgQq",qqReg,"qq格式正确","qq格式错误");

                // 返回false 不提交数据  返回true 提交数据
                console.log(checkNameFlag);
                console.log(pwdFlag);
                console.log(realFlag);
                console.log(emailFlag);
                console.log(phoneFlag);
                console.log(qqFlag);

                // 所有的条件都满足才提交数据

                return checkNameFlag && pwdFlag && realFlag && emailFlag && phoneFlag && qqFlag;
            },
            resetForm:true,             // 表单提交之前的 重置
            dataType:"json",            // 服务器返回的数据类型
            success:function (data) {   // 成功执行从函数

                alert(data.msg);
            }

        });

        /**
         * 表单校验的 封装的方法
         * @param objId         输入框的id
         * @param msgId         提示信息的id
         * @param reg           校验正则
         * @param successMsg    成功的信息提示
         * @param errMsg        失败的信息提示
         * @returns {boolean}   返回结果
         */
        function checkInputUtil(objId,msgId,reg,successMsg,errMsg){

            // 拿到 输入的内容
            var content = $(objId).val();
            //正则校验
            if (reg.test(content)){ //成功
                $(msgId).text(successMsg).css("color","green");
                return true;
            }else{  //是吧
                $(msgId).text(errMsg).css("color","red");
                return false;
            }

        }

        function checkName(){
            // 判断 input输入的内容
            var name = $("#usernameId").val();

            var flag = false;

            if (name.trim().length == 0){
                alert("不能为null");
            }else{
                //把数据发送到服务器
                $.ajax({

                    type:"get",                 // 请求的方式
                    url:"/pms/user",            // 请求的url
                    data:{                      // 发送给服务器的数据
                        method:"checkName",
                        username:name,
                    },
                    dataType:"json",           // 服务器返回的数据类型
                    async:false,                //  是否异步  同步

                    // ajax是异步操作 在成功方法中返回 值 不能接受
                    // 如果ajax 有返回值 在ajax外部定义一个变量 ,返回变量
                    //  ajax 是异步操作 返回的值 一定要是同步才可以

                    success:function (data) {  //  成功执行的函数
                        console.log(data);
                        // dom操作 信息提示
                        if (data.code == 300){ // 用户名存在 不能使用
                            $("#msgUserName").text(data.msg).css("color","red");
                            flag = false;
                        }
                        if (data.code == 301){ // 用户名不存在 可以使用
                            $("#msgUserName").text(data.msg).css("color","green");
                            flag = true;
                        }
                    }
                });
            }

            return flag;
        }
    </script>

</div>

</body>
</html>
