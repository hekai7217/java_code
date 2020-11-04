<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0004
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房屋展示</title>

<%--    把jq引入进来 --%>
    <script src="/pms/js/jquery.min.js"></script>

</head>
<body>

<script>

    // 初始化  大厦数据
    $(function () {

        // ajax 的操作  get / post 方法
        //  $.get(url,data,func,"json")

        // $.ajax(
        // {
        //    type  类型 get/post
        //    url    请求地址
        //    data   发送数据
        //    async  是否异步
        //    dataType  服务器返回数据 类型
        //    success  请求成功执行的函数
        // })
        $.get(
            "/pms/room",
            {method:"findBuild"},
            function (data) {
                console.log(data);
                // dom操作
                // 在select 中 添加 option
                for (var i = 0; i <data.length ; i++) {
                    var obj = data[i];
                    $("#bid").append("<option value='" + obj.id + "'>"+ obj.buildname +"</option>");
                }
            }
            ,"json");

        // 给大厦添加change事件

        $("#bid").change(function () {

            $.ajax({
                   type:"get",
                   url:"/pms/room",
                   data:{
                       method:"findFloor",
                       bid:$("#bid").val()

                   },
                   async:true,
                   dataType:"json",
                   success:function (data) {
                       $("#fid").empty();
                        // dom操作
                        // 在select 中 添加 option
                       console.log(data);
                       for (var i = 0; i <data.length ; i++) {
                           var obj = data[i];
                           $("#fid").append("<option value='" + obj.id + "'>"+ obj.floorname +"</option>");
                       }
                   }
            })

        });

        // 给楼层添加change事件
        $("#fid").change(function () {

            $.ajax({
                type:"get",
                url:"/pms/room",
                data:{
                    method:"findRoom",
                    fid:$("#fid").val()

                },
                async:true,
                dataType:"json",
                success:function (data) {
                    $("#rid").empty();
                    // dom操作
                    // 在select 中 添加 option
                    console.log(data);
                    for (var i = 0; i <data.length ; i++) {
                        var obj = data[i];
                        $("#rid").append("<option value='" + obj.id + "'>"+ obj.roomname +"</option>");
                    }
                }
            })

        });
    });

    function test() {
        alert("选中了房间...")
    }

</script>

<select id="bid">
    <option>选择大厦</option>
</select>
<select id="fid">
    <option>选择楼层</option>
</select>
<select id="rid" onchange="test()">
    <option>选择房间</option>
</select>

</body>
</html>
