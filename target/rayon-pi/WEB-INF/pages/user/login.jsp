<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/30
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="/scripts/jquery/jquery-3.2.1.min.js"></script>
    <script src="/scripts/pi/user/login.js"></script>
    <link rel="stylesheet" href="/style/css/user/login.css" />
    <script type="text/javascript">
        loginKey='${key}';
    </script>
</head>
<body align="center">
<div id="logindiv">
    <form>
        <div>
            <label for="userName">账户：</label>
            <input id="userName" name="user" type="text"/>
        </div>

        <div>
            <label for="password">密码：</label>
            <input id="password" name="pswd" type="password"/>
        </div>
        <div id="note">
            <span></span>
        </div>
        <div>
            <a href="javascript:void(0)" onclick="loginexec()" >登录</a>
        </div>
    </form>
</div>
</body>
</html>
