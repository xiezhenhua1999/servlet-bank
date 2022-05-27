<%--
  Created by IntelliJ IDEA.
  User: xueJLcat
  Date: 2022/5/1
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>我的信息</title>
    <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/Account-setting-or-edit-profile.css">
    <link rel="stylesheet" href="../assets/css/styles.css">

</head>

<body>
<jsp:include page="/web/top.jsp"></jsp:include>
<div class="container">
    <div class="row gutters">
        <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
            <div class="card h-100">
                <div class="card-body">
                    <div class="account-settings">
                        <div class="user-profile">
                            <div class="user-avatar">
                                <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Maxwell Admin">
                            </div>
                            <h5 class="user-name">${LoginUser.usrName}</h5>
                        </div>
                        <div class="about">
                            <h5>余额</h5>
                            <p>您的余额为：${LoginUser.usrBalance}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
            <div class="card h-100">
                <div class="card-body">
                    <div class="row gutters">
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <h6 class="mb-2 text-primary">详细信息</h6>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label for="fullName">用户ID:</label>
                                <input type="text" class="form-control" id="fullName" placeholder="Enter full name"
                                       value="${LoginUser.usrId}" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label for="Street">用户名:</label>
                                <input type="name" class="form-control" id="Street" placeholder="Enter Street"
                                       value="${LoginUser.usrName}" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label for="eMail">邮箱:</label>
                                <input type="email" class="form-control" id="eMail" placeholder="Enter email ID"
                                       value="${LoginUser.usrEmail}" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label for="phone">手机号:</label>
                                <input type="text" class="form-control" id="phone" placeholder="Enter phone number"
                                       value="${LoginUser.usrPhone}" readonly="readonly">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 py-5">
                                <div class="btn-group">
                                    <button class="btn btn-primary me-1" type="button"><a
                                            style="text-decoration:none; color:white; "
                                            href="<c:url value="/web/bank/addbalance.jsp"/>">存款</a>
                                    </button>
                                    <button class="btn btn-primary me-1" type="button"><a
                                            style="text-decoration:none; color:white; "
                                            href="<c:url value="/web/bank/reducebalance.jsp"/>">取款</a>
                                    </button>
                                    <button class="btn btn-primary me-1" type="button"><a
                                            style="text-decoration:none; color:white; "
                                            href="<c:url value="/web/bank/trancebalance.jsp"/>">转账</a>
                                    </button>
                                    <button class="btn btn-primary me-1" type="button"><a
                                            style="text-decoration:none; color:white; "
                                            href="<c:url value="/useridgetmessagetocheck?id=${LoginUser.usrId}"/>">编辑资料</a>
                                    </button>
                                    <button class="btn btn-danger me-2 " type="button"><a
                                            style="text-decoration:none; color:white; "
                                            onClick="return confirm('您的当前的余额为：${LoginUser.usrBalance},确定销户吗?');"
                                            href="<c:url value="/selfiddeluser?id=${LoginUser.usrId}"/>">销户</a>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
</div>
<jsp:include page="/web/foot.jsp"></jsp:include>
</body>

</html>
