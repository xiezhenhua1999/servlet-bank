<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xueJLcat
  Date: 2022/5/1
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>管理员后台</title>
    <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="../assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="../assets/css/custom-buttons.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.2/css/theme.bootstrap_4.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css">
    <link rel="stylesheet" href="../assets/css/Ludens---1-Index-Table-with-Search--Sort-Filters-v20.css">
    <link rel="stylesheet" href="../assets/css/responsive-navbar.css">
    <link rel="stylesheet" href="../assets/css/styles.css">
    <link rel="stylesheet" href="../assets/css/Toggle-Buttons.css">
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-12 col-sm-6 col-md-6">
            <h3 class="text-dark mb-4">Admin</h3>
        </div>
        <div class="col-12 col-sm-6 col-md-6 text-end" style="margin-bottom: 30px;">
            <a class="btn btn-primary" role="button" href="/web/register.jsp"><i class="fa fa-plus"></i>&nbsp;注册新用户</a>
        </div>
    </div>
    <div class="card" id="TableSorterCard">
        <div class="card-header py-3">
            <div class="row table-topper align-items-center">
                <div class="col-12 col-sm-5 col-md-6 text-start" style="margin: 0px;padding: 5px 15px;">
                    <p class="text-primary m-0 fw-bold">用户列表</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="table-responsive">
                    <table class="table table-striped table tablesorter" id="ipi-table">
                        <thead class="thead-dark">
                        <tr>
                            <th class="text-center">用户id</th>
                            <th class="text-center">用户名</th>
                            <th class="text-center">余额</th>
                            <th class="text-center">创建时间</th>
                            <th class="text-center filter-false sorter-false">编辑用户</th>
                        </tr>
                        </thead>
                        <tbody class="text-center">
                        <c:forEach items="${sessionScope.allist}" var="alist">
                            <tr>
                                <td>${alist.userId}</td>
                                <td>${alist.userName}</td>
                                <td>${alist.userBalance}</td>
                                <td>${alist.createTime}</td>
                                <td class="text-center align-middle" style="max-height: 60px;height: 60px;">
                                    <a class="btn btnMaterial btn-flat primary semicircle" role="button"
                                       href="<c:url value="/idgetmessagetocheck?id=${alist.userId}"/>">
                                        <i class="far fa-eye"></i>
                                    </a>
                                    <a class="btn btnMaterial btn-flat success semicircle" role="button"
                                       href="<c:url value="/idgetmessagetochage?id=${alist.userId}"/>">
                                        <i class="fas fa-pen"></i>
                                    </a>
                                    <a class="btn btnMaterial btn-flat primary semicircle" role="button"
                                       style="margin-left: 5px;"  onClick="return confirm('用户[${alist.userName}]当前余额为:${alist.userBalance},确定删除吗?');" href="<c:url value="/iddeluser?id=${alist.userId}"/>">
                                        <i class="fas fa-trash btnNoBorders" style="color: #DC3545;">
                                        </i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-12 py-3">
            <div class="btn-group">
                <button class="btn btn-primary me-2" type="button"><a style="text-decoration:none; color:white; "
                                                                      href="<c:url value="/admin/bank/addbalance.jsp"/>">增加余额</a>
                </button>
                <button class="btn btn-primary me-2" type="button"><a style="text-decoration:none; color:white; "
                                                                      href="<c:url value="/admin/bank/reducebalance.jsp"/>">减少余额</a>
                </button>
                <button class="btn btn-primary me-2" type="button"><a style="text-decoration:none; color:white; "
                                                                      href="<c:url value="/admin/bank/trancebalance.jsp"/>">用户间转账</a>
                </button>
                <button class="btn btn-primary me-2" type="button"><a style="text-decoration:none; color:white; "
                                                                      onClick="return confirm('确定退出吗?');" href="<c:url value="/logout"/>">退出系统</a>
                </button>
            </div>
        </div>
    </div>
</div>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.2/js/jquery.tablesorter.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.2/js/widgets/widget-filter.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.2/js/widgets/widget-storage.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script src="../assets/js/Ludens---1-Index-Table-with-Search--Sort-Filters-v20-1.js"></script>
<script src="../assets/js/Ludens---1-Index-Table-with-Search--Sort-Filters-v20.js"></script>
</body>

</html>