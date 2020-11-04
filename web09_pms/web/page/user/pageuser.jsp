<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- jstl 标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%-- 格式化标签 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%
    // 项目的访问路径 pms
    String contextPath = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<base href="<%=basePath%>">

<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>分页查询</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">

            <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline" role="grid">
                <table class="table table-striped table-bordered table-hover dataTables-example dataTable"
                       id="DataTables_Table_0"
                       aria-describedby="DataTables_Table_0_info">
                    <tr role="row">
                        <th class="sorting_asc" style="width:80px;">
                            id
                        </th>
                        <th class="sorting" style="width:100px;">
                            用户名
                        </th>
                        <th class="sorting" style="width:100px;">
                            真实姓名
                        </th>
                        <th style="width:100px;">
                            邮箱
                        </th>
                        <th class="sorting" style="width:100px;">
                            电话
                        </th>
                        <th class="sorting" style="width:80px;">
                            qq
                        </th>
                        <th style="width:150px;">
                            注册时间
                        </th>
                    </tr>

                    <c:forEach var="u" items="${pageUtils.data}">
                        <tr class="gradeA even">
                            <td>${u.id}</td>
                            <td>${u.username}</td>
                            <td>${u.realname}</td>
                            <td>${u.email}</td>
                            <td>${u.phone}</td>
                            <td>${u.qq}</td>
                            <td>
                                <fmt:formatDate value="${u.regtime}" pattern="yyyy-MM-dd:HH:mm:ss"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="dataTables_info" id="DataTables_Table_0_info" role="alert"
                             aria-live="polite" aria-relevant="all">
                            显示 ${pageUtils.index + 1} 到 ${pageUtils.index + pageUtils.pageSize}
                            项，共 ${pageUtils.totalCount} 项
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">
                            <ul class="pagination">

                                <%--                                        如果是第一页 上一页 不能点击 --%>
                                <c:if test="${pageUtils.firstPage == pageUtils.currentPage}">
                                    <li class="paginate_button previous disabled" aria-controls="DataTables_Table_0"
                                        tabindex="0" id="DataTables_Table_0_previous">
                                        <a href="#">上一页</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageUtils.firstPage != pageUtils.currentPage}">
                                    <li class="paginate_button previous" aria-controls="DataTables_Table_0"
                                        tabindex="0" id="DataTables_Table_0_previous">
                                        <a href="/pms/user?method=pageUser&currentPage=${pageUtils.prePage}&pageSize=10">上一页</a>
                                    </li>
                                </c:if>

                                <%--                                       active 高亮   --%>
                                <c:forEach var="index" begin="${pageUtils.startNav}" end="${pageUtils.endNav}">

                                    <c:if test="${index == pageUtils.currentPage}">
                                        <li class="paginate_button active" aria-controls="DataTables_Table_0"
                                            tabindex="0">
                                            <a href="#">${index}</a>
                                        </li>
                                    </c:if>

                                    <c:if test="${index != pageUtils.currentPage}">
                                        <li class="paginate_button" aria-controls="DataTables_Table_0"
                                            tabindex="0">
                                            <a href="/pms/user?method=pageUser&currentPage=${index}&pageSize=10">${index}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>

                                <%-- 最后 一页  不能点击--%>
                                <c:if test="${pageUtils.lastPage ==pageUtils.currentPage}">
                                    <li class="paginate_button next disabled" aria-controls="DataTables_Table_0"
                                        tabindex="0"
                                        id="DataTables_Table_0_next">
                                        <a href="#">下一页</a>
                                    </li>
                                </c:if>
                                <%--    不是最后一页可以点击--%>
                                <c:if test="${pageUtils.lastPage !=pageUtils.currentPage}">
                                    <li class="paginate_button next" aria-controls="DataTables_Table_0" tabindex="0"
                                        id="DataTables_Table_0_next">
                                        <a href="/pms/user?method=pageUser&currentPage=${pageUtils.nextPage}&pageSize=10">下一页</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>