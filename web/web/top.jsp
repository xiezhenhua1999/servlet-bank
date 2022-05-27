<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xueJLcat
  Date: 2022/4/30
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>头部</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Navbar-Centered-Brand.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>

<nav class="navbar navbar-light navbar-expand-md py-3">
    <div class="container"><a class="navbar-brand d-flex align-items-center"
                              href="/index.jsp"><span>xueJL 's Bank</span></a>
        <button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-4"><span
                class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse flex-grow-0 order-md-first" id="navcol-4">

            <ul class="navbar-nav me-auto">
                <c:if test="${LoginUser!=null}">
                    <li class="nav-item"><a class="btn btn-light me-2" href="/web/bank/userprofile.jsp">我的信息</a></li>
                </c:if>
                <c:if test="${LoginUser==null}">
                    <li class="nav-item"><a class="nav-link active">您还未登录</a></li>
                </c:if>

            </ul>

            <c:if test="${LoginUser==null}">
                <div class="d-md-none my-2">
                        <%--                    <a class="btn btn-light me-2" href="<c:url value="/web/bank/addbalance.jsp"/>">存款</a>--%>
                    <a class="btn btn-light me-2" role="button" href="<c:url value="/web/register.jsp"/>">注册</a>

                    <a class="btn btn-primary" role="button" href="<c:url value="/web/userlogin.jsp"/>">登录</a>

                </div>
            </c:if>

            <c:if test="${LoginUser!=null}">
                <div class="d-md-none my-2">
                        <%--                    <a class="btn btn-light me-2" href="<c:url value="/web/bank/addbalance.jsp"/>">存款</a>--%>
                    <a class="btn btn-light me-2" href="<c:url value="/index.jsp"/>">欢迎${LoginUser.usrName}！</a>
                    <a class="btn btn-primary" role="button" href="<c:url value="/logout"/>">退出登录</a>
                </div>
            </c:if>
        </div>

        <c:if test="${LoginUser==null}">
            <div class="d-none d-md-block">
                    <%--                <a class="btn btn-light me-2" href="<c:url value="/web/bank/addbalance.jsp"/>">存款</a>--%>
                <a class="btn btn-light me-2" role="button" href="<c:url value="/web/register.jsp"/>">注册</a>
                <a class="btn btn-primary me-2" role="button" href="<c:url value="/web/userlogin.jsp"/>">登录</a>
            </div>
        </c:if>


        <c:if test="${LoginUser!=null}">
            <div class="d-none d-md-block">
                    <%--                <a class="btn btn-light me-2" href="<c:url value="/web/bank/addbalance.jsp"/>">存款</a>--%>
                <a class="btn btn-light me-2" href="<c:url value="/index.jsp"/>">欢迎${LoginUser.usrName}！</a>
                <a class="btn btn-primary" role="button" href="<c:url value="/logout"/>">退出登录</a>
            </div>
        </c:if>
    </div>
</nav>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="<c:url value="/web/assets/bootstrap/js/bootstrap.min.js"/>"></script>
</body>

</html>
