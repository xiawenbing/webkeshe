<%--
  User: 夏文昺
  Date: 2020/10/15
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
        <meta charset="utf-8" />
        <title>用户注册</title>
        <link href="css/register.css" rel="stylesheet" />
        <script src="js/jquery-3.5.0.min.js"></script>
        <script src="js/register.js"></script>
</head>
<body>
<div id="loginForm">
    <div class="title">
        <span class="titleRegister">更改密码</span>
        <span class="titleLogin"><a href="login.html">重新登录</a></span>
    </div>
    <form id="registerForm">
        <p><input id="usepassword" name="usepassword" type="password" placeholder="原密码" />
            <span class="auth_err" id="usepasswordError"></span>
        
        <p><input id="password" name="password" type="password" placeholder="密码" />
            <span class="auth_err" id="passwordError"></span>
        </p>
        <p><input id="password1" name="password1" type="password" placeholder="确认密码" />
            <span class="auth_err" id="password1Error"></span>
        </p>
        <p>
            <input id="btLogin" type="button" value="提&nbsp;&nbsp;交" />
            <span class="auth_err" id="checkError"></span>
        </p>
    </form>
</div>
</body>
</html>
