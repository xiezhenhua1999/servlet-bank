<%--
  Created by IntelliJ IDEA.
  User: xueJLcat
  Date: 2022/5/3
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>404</title>


    <meta http-equiv="keywords" content="404">
    <meta http-equiv="description" content="404">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <style type="text/css">

        @import url("https://fonts.googleapis.com/css?family=Libre+Franklin");

        body {
            margin: 0;
            min-height: 100vh;
            overflow: hidden;
            font-family: "Libre Franklin", sans-serif;
            font-size: 62.5%;
            background-image: linear-gradient(0deg, #e8f4f8, lightblue);
        }

        .error {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            display: flex;
            flex-direction: column;
            align-items: center;
            white-space: nowrap;
            text-transform: uppercase;
            font-size: 2rem;
            font-weight: 900;
            color: #ffffff;
            text-shadow: 10px 10px 50px #e6e6e6;
            opacity: 0.8;
            user-select: none;
        }

        .error span {
            display: block;
        }

        .error span:nth-child(2) {
            font-size: 10rem;
        }

        .sun {
            position: absolute;
            top: 4em;
            left: 4em;
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background-image: radial-gradient(circle at 50%, #ffffff 50%, #f5de19);
            box-shadow: 0px 0px 40px #f5de19, inset 0px 0px 100px #f5de19;
            animation: sun 5s linear infinite;
        }

        .clouds {
            position: absolute;
            right: 0;
            bottom: 35vh;
            left: 0;
            opacity: 0.5;
        }

        .clouds div {
            position: relative;
            left: -30%;
            width: 220px;
            height: 80px;
            border-radius: 50%;
            background-color: #ffffff;
            background-image: radial-gradient(ellipse at 50%, transparent, #fcfcfc, #f7f7f7);
            filter: blur(3px);
            animation: clouds 60s linear infinite, cloud 8s linear infinite;
        }

        .clouds div::before, .clouds div::after {
            position: absolute;
            content: "";
            width: inherit;
            height: inherit;
            border-radius: 50%;
            background-color: #f2f2f2;
            background-image: radial-gradient(ellipse at 50%, transparent, #f2f2f2, #f7f7f7);
            filter: blur(3px);
            animation: cloud 3s linear infinite;
        }

        .clouds div::after {
            background-color: #e6e6e6;
        }

        .clouds div:nth-child(2) {
            animation-delay: 5s;
        }

        .clouds div:nth-child(3) {
            animation-duration: 40s;
        }

        .birds {
            position: absolute;
            right: -10%;
            top: 30px;
            width: 10px;
            height: 10px;
            background-color: #070000;
            clip-path: polygon(70% 59%, 100% 54%, 64% 68%, 48% 83%, 81% 86%, 55% 90%, 0 92%, 19% 76%, 0 60%, 33% 71%);
            animation: birds 30s linear infinite, fly 1s linear infinite;
        }

        .sea {
            position: absolute;
            right: 0;
            bottom: 0;
            left: 0;
            z-index: -1;
            height: 25vh;
            background-color: lightblue;
        }

        .fish {
            position: relative;
        }

        .fish span {
            position: relative;
            top: 10%;
            left: 110%;
            display: block;
            width: 50px;
            height: 16px;
            background-color: #3a9fc0;
            background-image: linear-gradient(to top, #92cbde, #3a9fc0);
            border-radius: 52% 48% 51% 49% / 51% 56% 44% 49%;
            animation: fish 15s linear infinite;
        }

        .fish span::before, .fish span::after {
            position: absolute;
            content: "";
        }

        .fish span::before {
            left: 95%;
            top: calc(50% - 8px);
            width: 16px;
            height: 16px;
            background-color: inherit;
            background-image: linear-gradient(90deg, #3a9fc0, #2b758d);
            clip-path: polygon(100% 0%, 84% 49%, 100% 100%, 0 66%, 0% 50%, 0 35%);
        }

        .fish span::after {
            width: 10px;
            height: 10px;
            top: 50%;
            left: 30%;
            background-image: linear-gradient(135deg, #3a9fc0, #2b758d);
            clip-path: polygon(100% 27%, 86% 74%, 31% 100%, 0 22%, 0 0, 35% 0);
            transform-origin: 0 0;
            animation: side 0.5s linear infinite;
        }

        .fish span:nth-child(2) {
            animation-duration: 6s;
            animation-delay: 5s;
        }

        .fish span:nth-child(3) {
            animation-duration: 9s;
        }

        .wave {
            position: absolute;
            left: -25%;
            bottom: 0;
            width: 150%;
            height: 100%;
            background-color: lightblue;
            animation: vawe 20s linear infinite;
        }

        .wave.w-1 {
            background: #99cfe0;
            animation-delay: 2s;
        }

        .wave.w-2 {
            background: #86c5da;
        }

        .bottom {
            position: absolute;
            right: -2em;
            bottom: 0;
            left: -2em;
            height: 1.35em;
            border-radius: 78% 22% 52% 48% / 100% 100% 0% 0%;
            background-color: #3a0003;
            background-image: linear-gradient(0deg, #210001, #6d0005);
            opacity: 0.8;
        }

        .grass {
            position: absolute;
            bottom: 5px;
            left: 5em;
            width: 3px;
            height: 35px;
            background-color: #44882d;
            background-image: linear-gradient(45deg, #44882d, #274f1a);
            border-radius: 40%;
            transform-origin: 50% 100%;
            animation: grass 2s linear infinite;
        }

        .grass:nth-child(2) {
            bottom: 3px;
            left: 30%;
        }

        .grass:nth-child(3) {
            bottom: 8px;
            left: 60%;
        }

        .grass:nth-child(4) {
            bottom: 6px;
            left: 80%;
        }

        .grass span {
            position: absolute;
            left: -5px;
            width: 8px;
            height: 2px;
            background-color: #44882d;
            background-image: inherit;
            transform: rotate(45deg);
        }

        .grass span::before {
            position: absolute;
            top: 4px;
            left: 4px;
            content: "";
            width: inherit;
            height: inherit;
            background-color: inherit;
            transform: rotate(-90deg) translateX(100%);
        }

        .grass span:nth-child(2) {
            top: 10px;
        }

        .grass span:nth-child(3) {
            top: 15px;
        }

        .grass span:nth-child(3) {
            top: 20px;
        }

        .circle {
            position: absolute;
            bottom: 5px;
            left: 0;
            width: 100%;
            height: 25vh;
        }

        .circle span {
            position: absolute;
            bottom: 0;
            left: 12%;
            display: block;
            width: 7px;
            height: 7px;
            border-radius: 50%;
            background-color: #ffffff;
            opacity: 0.2;
            animation: circle 2s linear infinite;
        }

        .circle span::before, .circle span::after {
            position: absolute;
            bottom: 0;
            left: 10px;
            content: "";
            width: 5px;
            height: 5px;
            border-radius: inherit;
            background-color: inherit;
            animation: circle 4s linear infinite;
            animation-delay: 0.3s;
        }

        .circle span::after {
            right: -10px;
            animation-delay: 0.5s;
        }

        .circle span:nth-child(2) {
            left: 25%;
            animation-delay: 0.6s;
        }

        .circle span:nth-child(3) {
            left: 45%;
            animation-delay: 0.8s;
        }

        .circle span:nth-child(4) {
            left: 53%;
        }

        .circle span:nth-child(5) {
            left: 74%;
        }

        .grass_tw {
            position: absolute;
            bottom: 11px;
            left: 50%;
            width: 30px;
            height: 10px;
            background-color: #44882d;
            background-image: linear-gradient(180deg, #44882d, #1e3b14);
            clip-path: polygon(10% 84%, 14% 73%, 17% 24%, 20% 61%, 22% 88%, 32% 15%, 31% 68%, 35% 88%, 49% 11%, 63% 85%, 69% 10%, 77% 80%, 84% 16%, 89% 92%, 97% 41%, 100% 97%, 50% 96%, 0 100%, 4% 34%);
            animation: grass_tw 2s linear infinite;
        }

        .grass_tw:nth-last-child(2) {
            left: 75%;
            width: 80px;
        }

        .grass_tw:last-child {
            bottom: 8px;
            left: 20%;
            width: 50px;
        }

        @keyframes sun {
            50% {
                box-shadow: 0px 0px 60px 20px #f5de19, inset 0px 0px 100px #f5de19;
            }
        }

        @keyframes clouds {
            0% {
                left: -30%;
            }

            100% {
                left: 110%;
            }
        }

        @keyframes cloud {
            30% {
                border-radius: 22% 78% 51% 49% / 78% 66% 34% 22%;
            }

            40% {
                width: 180px;
            }

            60% {
                border-radius: 61% 39% 51% 49% / 50% 66% 34% 50%;
            }
        }

        @keyframes birds {
            100% {
                right: 110%;
                transform: scale(1.8) translateY(100px);
            }
        }

        @keyframes fly {
            50% {
                clip-path: polygon(70% 69%, 97% 80%, 70% 76%, 48% 83%, 81% 86%, 55% 90%, 0 92%, 19% 76%, 0 71%, 33% 71%);
            }
        }

        @keyframes fish {
            0% {
                left: 110%;
            }

            40% {
                transform: translateY(35px) rotate(-15deg);
            }

            70% {
                transform: translateY(-5px) rotate(15deg);
            }

            80% {
                transform: translateY(5px) rotate(0deg);
            }

            100% {
                left: -10%;
            }
        }

        @keyframes circle {
            0% {
                transform: translateY(0px) scale(0);
            }

            50%, 80% {
                transform: translateY(-25px) scale(1);
            }

            100% {
                transform: translateY(-30px) scale(0);
                opacity: 0;
            }
        }

        @keyframes side {
            50% {
                transform: rotate(-35deg);
            }
        }

        @keyframes vawe {
            20%, 40% {
                border-radius: 23% 77% 52% 48% / 100% 100% 0% 0%;
            }

            30%, 50%, 70% {
                border-radius: 37% 63% 100% 0% / 100% 100% 0% 0%;
            }

            80%, 60% {
                border-radius: 78% 22% 52% 48% / 100% 100% 0% 0%;
            }
        }

        @keyframes grass {
            50% {
                transform: rotate(5deg);
            }
        }

        @keyframes grass_tw {
            50% {
                clip-path: polygon(10% 84%, 14% 73%, 10% 28%, 20% 61%, 22% 88%, 24% 18%, 31% 68%, 35% 88%, 42% 15%, 63% 85%, 58% 14%, 77% 80%, 77% 18%, 89% 92%, 91% 43%, 100% 97%, 50% 96%, 0 100%, 3% 39%);
            }
        }


    </style>

</head>
<body>

<div class="error">
    <span>File not found</span><span>404</span>
    <div id="box"></div>
    <span>Error</span>
</div>
<div class="sun"></div>
<div class="clouds">
    <div></div>
    <div></div>
    <div></div>
</div>
<div class="birds"></div>
<div class="sea">
    <div class="wave w-1"></div>
    <div class="wave w-2"></div>
    <div class="fish">
        <span></span><span></span><span></span>
    </div>
</div>
<div class="bottom">
    <div class="grass">
        <span> </span><span> </span><span> </span>
    </div>
    <div class="grass">
        <span> </span><span> </span><span> </span>
    </div>
    <div class="grass">
        <span> </span><span> </span><span> </span>
    </div>
    <div class="grass">
        <span> </span><span> </span><span> </span>
    </div>
    <div class="circle">
        <span></span><span></span><span></span><span></span><span></span>
    </div>
    <div class="circle">
        <span></span><span></span><span></span><span></span><span></span>
    </div>
    <div class="circle">
        <span></span><span></span><span></span><span></span><span></span>
    </div>
    <div class="circle">
        <span></span><span></span><span></span><span></span><span></span>
    </div>
    <div class="grass_tw"></div>
    <div class="grass_tw"></div>
    <div class="grass_tw"></div>
</div>
<script>
    //5秒跳转页面
    var b = document.getElementById("box");
    b.innerHTML = "将在3秒后跳转回首页";
    var time = 2;
    //每隔一秒执行定时器
    var timer = setInterval(function () {
        if (time > 0) {
            time--;
            b.innerHTML = time + "秒钟跳转回首页";
        } else {
            //终止定时器
            //alert("跳转页面");
            //open("http://www.baidu.com");
            window.location.href = "/index.jsp";
            timer.clearInterval();
        }
    }, 1000);
</script>
</body>
</html>