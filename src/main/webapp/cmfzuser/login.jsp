<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head lang="en">

    <meta charset="UTF-8">

    <title>登录界面</title>

</head>

<body>

<div id="loginpanelwrap">

    <div class="loginheader">

        <div class="logintitle">登录</div>

    </div>

    <form action = "${pageContext.request.contextPath}/users/login">

        <div class="loginform">

            <div class="loginform_row">

                <label>用户名:</label>

                <input type="text" class="loginform_input" name="username" />

            </div>

            <div class="loginform_row">

                <label>密码:</label>

                <input type="password" class="loginform_input" name="password" />

            </div>

            <div class="loginform_row">

                <span class = "returnInfo"></span>

                <input type="submit" class="loginform_submit" value="登录" />

            </div>

            <div class="clear"></div>

        </div>

    </form>

</div>

</body>

</html>