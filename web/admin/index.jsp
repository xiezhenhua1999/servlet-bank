<%--
  Created by IntelliJ IDEA.
  User: xueJLcat
  Date: 2022/4/30
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>管理员登录</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/-Login-form-Page-BS4-.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
<div class="container-fluid">
    <div class="row mh-100vh">
        <div class="col-10 col-sm-8 col-md-6 col-lg-6 offset-1 offset-sm-2 offset-md-3 offset-lg-0 align-self-center d-lg-flex align-items-lg-center align-self-lg-stretch bg-white p-5 rounded rounded-lg-0 my-5 my-lg-0"
             id="login-block">
            <div class="m-auto w-lg-75 w-xl-50">
                <h2 class="text-info fw-light mb-5">管理员登录</h2>
                <form action="/adminlogin" method="post">
                    <div class="form-group mb-3"><label class="form-label text-secondary">用户名</label><input
                            class="form-control" type="text" inputmode="text" name="username"></div>
                    <div class="form-group mb-3"><label class="form-label text-secondary">密码</label><input
                            class="form-control" type="password" name="password"></div>
                    <button class="btn btn-info mt-2" type="submit">登录</button>
                </form>
            </div>
        </div>
        <div class="col-lg-6 d-flex align-items-end" id="bg-block"
             style="background-image:url(&quot;http://pic.nsk.kim/tkc/2022/05/01/626d60bd4c31f.jpg&quot;);background-size:cover;background-position:center center;">
            <p class="ms-auto small text-dark mb-2"><em>Photo by&nbsp;</em><a class="text-dark"
                                                                              href="https://unsplash.com/photos/v0zVmWULYTg?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText"
                                                                              target="_blank"><em>Aldain
                Austria</em></a><br></p>
        </div>
    </div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
