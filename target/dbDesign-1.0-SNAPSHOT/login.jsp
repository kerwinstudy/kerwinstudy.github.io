<%--
  Created by IntelliJ IDEA.
  User: 19528
  Date: 2023/6/20
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        html {
            height: 100%;
        }
        body {
            height: 100%;
        }
        .container {
            height: 100%;
            background-image: linear-gradient(to right, #2a6f97, #a6c1ee);
        }
        /*#fbc2eb*/
        .login-wrapper {
            background-color: #fff;
            width: 358px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }
        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }
        .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128, 125, 125);
            font-size: 15px;
            outline: none;
        }
        .input-item:placeholder {
            text-transform: uppercase;
        }
        .btn {
            text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 40px;
            background-image: linear-gradient(to right, #a6c1ee, #2a6f97);
            color: #fff;
        }
        /*#fbc2eb*/
        .msg {
            text-align: center;
            line-height: 88px;
        }
        a {
            text-decoration-line: none;
            color: #abc1ee;
        }
    </style>
</head>
<body>

<%--
<form action="/servlet02_war/login" method="get">
    用户名：<input type="text" name="userName"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">
</form>--%>

<div class="container">
    <div class="login-wrapper">
        <div class="header">Login</div>
        <form class="loginForm" action="/loginDo" method="get">
<%--        <div class="info">${error}</div>--%>
        <div class="form-wrapper">
            <input type="text" name="username" placeholder="username" class="input-item">
            <input type="password" name="password" placeholder="password" class="input-item">
            <input type="submit" class="btn" value="Login">
        </div>
        </form>
        <div class="msg">
            Don't have account?
            <a href="/#">Sign up</a>
        </div>
    </div>
</div>
</body>
</html>