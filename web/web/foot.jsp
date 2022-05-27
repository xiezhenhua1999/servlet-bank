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
    <title>尾部</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Footer-Basic.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
<footer class="text-center">
    <div class="container text-muted py-4 py-lg-5">
        <ul class="list-inline">
            <li class="list-inline-item me-4"><a class="link-secondary" href="http://xc.nsk.kim" target="_blank"
                                                 style="text-decoration:none;">雪之心</a></li>
            <li class="list-inline-item me-4"><a class="link-secondary" href="http://nsk.kim" target="_blank"
                                                 style="text-decoration:none;">猫之站</a></li>
            <li class="list-inline-item"><a class="link-secondary" href="http://kod.nsk.kim" target="_blank"
                                            style="text-decoration:none;">星之梦</a></li>
        </ul>
        <p id="RunTime" style="color:Dark;"></p>
        <p id="hitokoto">:D 获取中...</p>
        <p class="mb-0"><a class="link-secondary" href="https://github.com/xueJLcat" target="_blank"
                           style="text-decoration:none;">Copyright © 2022 Edit By xueJL</a></p>
    </div>
</footer>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="web/assets/bootstrap/js/bootstrap.min.js"></script>
<script>
    fetch('https://v1.hitokoto.cn?c=a&c=b&c=c')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            var hitokoto = document.getElementById('hitokoto');
            hitokoto.innerText = data.hitokoto;
        })
        .catch(function (err) {
            console.error(err);
        });
</script>
<script>
    var BootDate = new Date("2022/5/3 12:21:07");

    function ShowRunTime(id) {
        var NowDate = new Date();
        var RunDateM = parseInt(NowDate - BootDate);
        var RunDays = Math.floor(RunDateM / (24 * 3600 * 1000));
        var RunHours = Math.floor(RunDateM % (24 * 3600 * 1000) / (3600 * 1000));
        var RunMinutes = Math.floor(RunDateM % (24 * 3600 * 1000) % (3600 * 1000) / (60 * 1000));
        var RunSeconds = Math.round(RunDateM % (24 * 3600 * 1000) % (3600 * 1000) % (60 * 1000) / 1000);
        var RunTime = RunDays + "天" + RunHours + "时" + RunMinutes + "分" + RunSeconds + "秒";
        document.getElementById(id).innerHTML = "猫猫已经睡了:" + RunTime;
    }

    setInterval("ShowRunTime('RunTime')", 1000);
</script>
</body>

</html>
