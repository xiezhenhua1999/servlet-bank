<%--
  Created by IntelliJ IDEA.
  User: xueJLcat
  Date: 2022/5/1
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>failure</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Bootstrap-Callout-Warning.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
<div class="bs-callout bs-callout-warning">
    <h4>Error</h4>
    <p class="test">请求未成功执行，请检查您的输入。</p>
    <div id="box"></div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script>
    //5秒跳转页面
    var b = document.getElementById("box");
    b.innerHTML = "将在3秒后跳转回个人信息页";
    var time = 2;
    //每隔一秒执行定时器
    var timer = setInterval(function () {
        if (time > 0) {
            time--;
            b.innerHTML = time + "秒钟跳转回个人信息页";
        } else {
            //终止定时器
            //alert("跳转页面");
            //open("http://www.baidu.com");
            window.location.href = "/web/bank/userprofile.jsp";
            timer.clearInterval();
        }
    }, 1000);
</script>
</body>
</html>