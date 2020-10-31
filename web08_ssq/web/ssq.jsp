<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0031
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市区三级联动</title>
    <script src="/ssq/js/jquery-1.9.1.js"></script>
</head>
<body>


<%--
    需要加载省的数据
       通过ajax 向 服务器请求数据
         01 添加jq
         02 使用jq 获取服务器的数据
--%>

<script>

    // 加载省 初始化数据
    $(function(){
        // 发送ajax 获取数据
        $.get("/ssq/findssq",
            {method:"findProvince"},
            function (data) {
                console.log(data);
                for(var i = 0;i < data.length ; i ++ ){
                    var obj = data[i];
                    $("#provinceId").append('<option value="'+ obj.areaId+'">'+ obj.areaName +'</option>');
                }

                // 默认选中 查询北京的 区
                var pid = $("#provinceId").val();
                console.log(pid)

                // 默认加载 北京 的 区
                // findCtiy(pid);
            },
            "json"
        );

        // 加载市 通过给 select 添加 change 事件
        $("#provinceId").change(function () {
            var pid = $("#provinceId").val();
            findCtiy(pid);
        });

        // 加载区 通过给 cityId 的 select 添加 change 事件

        $("#cityId").change(function () {

            $.get(
                "/ssq/findssq",
                {
                    method:"findTown",
                    cid:$("#cityId").val()  // 通过cid 和 findTown 参数查询 town
                },
                function (data) {

                    // 把之前的数据清理掉

                    $("#townId").empty();
                    console.log(data);
                    for(var i = 0;i < data.length ; i ++ ){
                        var obj = data[i];
                        $("#townId").append('<option value="'+ obj.areaId+'">'+ obj.areaName +'</option>');
                    }
                },
                "json"
            )
        });

        $("#townId").click(function () {

            // 拿到select 的option的长度
            var optionSize = $("#cityId").get(0).options.length;

            if (optionSize == 0){
                alert("先选择市")
            }

        });
    })

    function findCtiy(pid){


        $.get("/ssq/findssq",
            {   method: "findCity",
                pid: pid
            },
            function (data) {
                // 把 之前的选中的省的市 清楚
                // 把子节点 清空
                $("#cityId").empty();

                console.log(data);
                for(var i = 0;i < data.length ; i ++ ){
                    var obj = data[i];
                    $("#cityId").append('<option value="'+ obj.areaId+'">'+ obj.areaName +'</option>');
                }
            },
            "json"
        );
    }

</script>

选择省:<select id="provinceId"></select>
选择市:<select id="cityId"></select>
选择区:<select id="townId"></select>

</body>
</html>
