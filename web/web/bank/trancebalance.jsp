<%--
  Created by IntelliJ IDEA.
  User: xueJLcat
  Date: 2022/4/30
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>转账</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
<jsp:include page="/web/top.jsp"></jsp:include>
<div class="container"
     style="position:absolute; left:0; right:0; top: 50%; transform: translateY(-50%); -ms-transform: translateY(-50%); -moz-transform: translateY(-50%); -webkit-transform: translateY(-50%); -o-transform: translateY(-50%);">
    <div class="row d-flex d-xl-flex justify-content-center justify-content-xl-center">
        <div class="col-sm-12 col-lg-10 col-xl-9 col-xxl-7 bg-white shadow-lg" style="border-radius: 5px;">
            <div class="p-5">
                <div class="text-center">
                    <h4 class="text-dark mb-4">转账</h4>
                </div>
                <form class="user" action="/trancebalance" method="post">
                    <div class="mb-3">转出用户名：</div>
                    <div class="mb-3"><input class="form-control form-control-user" type="text" placeholder="转出账户"
                                             name="tranceoutuserid" value="${LoginUser.usrName}" readonly="readonly">
                    </div>
                    <div class="mb-3">转入用户名：</div>
                    <div class="mb-3"><input class="form-control form-control-user" type="text" name="tranceinusername"
                                             placeholder="请输入用户名"></div>
                    <div class="mb-3">转帐金额：</div>
                    <div class="mb-3"><input class="form-control form-control-user" type="number" name="trancequery"
                                             placeholder="请输入金额"></div>
                    <button class="btn btn-primary d-block btn-user w-100" id="submitBtn" type="submit"  onClick="return confirm('您的当前的余额为:${LoginUser.usrBalance},确定转账吗?');">转账</button>
                </form>
                <div class="text-center"></div>

            </div>
        </div>
    </div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>