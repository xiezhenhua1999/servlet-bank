<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xueJLcat
  Date: 2022/4/30
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>编辑资料</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
<c:forEach items="${sessionScope.selectuserdata}" var="items">
    <div class="container"
         style="position:absolute; left:0; right:0; top: 50%; transform: translateY(-50%); -ms-transform: translateY(-50%); -moz-transform: translateY(-50%); -webkit-transform: translateY(-50%); -o-transform: translateY(-50%);">
        <div class="row d-flex d-xl-flex justify-content-center justify-content-xl-center">
            <div class="col-sm-12 col-lg-10 col-xl-9 col-xxl-7 bg-white shadow-lg" style="border-radius: 5px;">
                <div class="p-5">
                    <div class="text-center">
                        <h4 class="text-dark mb-4">编辑[${items.username}]的用户信息</h4>
                    </div>
                    <form class="user" action="/useredituserprofile" method="post">
                        <div class="mb-3" hidden="hidden">目标ID：</div>
                        <div class="mb-3" hidden="hidden"><input class="form-control form-control-user" type="number"
                                                                 name="targetuserid" value="${items.userid}"
                                                                 placeholder="要修改用户的ID"></div>
                        <div class="mb-3">账户ID：</div>
                        <div class="mb-3"><input class="form-control form-control-user" type="number"
                                                 name="targetnewuserid" value="${items.userid}" placeholder="请输入新的用户ID">
                        </div>
                        <div class="mb-3">用户名：</div>
                        <div class="mb-3"><input class="form-control form-control-user" type="text"
                                                 name="targetnewusername" value="${items.username}"
                                                 placeholder="请输入新的用户名"></div>
                        <div class="mb-3">用户邮箱：</div>
                        <div class="mb-3"><input class="form-control form-control-user" type="email"
                                                 name="targetnewuseremail" value="${items.useremail}"
                                                 placeholder="请输入新的邮箱"></div>
                        <div class="mb-3">手机号：</div>
                        <div class="mb-3"><input class="form-control form-control-user" type="number"
                                                 name="targetnewuserphone" value="${items.userphone}"
                                                 placeholder="请输入新的手机号"></div>
                        <div class="mb-3">账户密码：</div>
                        <div class="mb-3"><input class="form-control form-control-user" type="password"
                                                 name="targetnewuserpassword" value="${items.userpassword}"
                                                 placeholder="请输入新的密码"></div>
                        <button class="btn btn-primary d-block btn-user w-100" id="submitBtn" type="submit"  onClick="return confirm('确认修改吗？');">修改
                        </button>
                    </form>
                    <div class="text-center"></div>

                </div>
            </div>
        </div>
    </div>
</c:forEach>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
