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
    <title>用户信息</title>
    <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/Account-setting-or-edit-profile.css">
    <link rel="stylesheet" href="../assets/css/styles.css">

</head>

<body>
<c:forEach items="${sessionScope.selectuserdata}" var="items">
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
                            <h5 class="user-name">${items.username}</h5>
                        </div>
                        <div class="about">
                            <h5>余额</h5>
                            <p>您的余额为：${items.userbalance}</p>
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
                            <h6 class="mb-2 text-primary">用户信息</h6>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label for="fullName">用户id</label>
                                <input type="text" class="form-control" id="fullName" placeholder="Enter full name"
                                       value="${items.userid}" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label for="eMail">邮箱</label>
                                <input type="email" class="form-control" id="eMail" placeholder="Enter email ID"
                                       value="${items.useremail}" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label for="phone">手机号</label>
                                <input type="text" class="form-control" id="phone" placeholder="Enter phone number"
                                       value="${items.userphone}" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label for="website">密码</label>
                                <input type="url" class="form-control" id="website" placeholder="Website url "
                                       value="${items.userpassword}" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="row gutters">
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label for="Street">用户名</label>
                                <input type="name" class="form-control" id="Street" placeholder="Enter Street"
                                       value="${items.username}" readonly="readonly">
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label for="ciTy">创建时间</label>
                                <input type="name" class="form-control" id="ciTy" placeholder="null"
                                       value="${items.createtime}" readonly="readonly">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </c:forEach>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
