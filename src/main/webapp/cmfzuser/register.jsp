<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head lang="en">

    <meta charset="UTF-8">

    <title>注册界面</title>

</head>

<body>

<div id="loginpanelwrap">

    <div class="loginheader">

        <div class="logintitle">注册</div>

    </div>

    <form action = "${pageContext.request.contextPath}/users/register">

        <div class="loginform">

            <div class="loginform_row">

                <label>用户名:</label>

                <input type="text" class="loginform_input" name="userName" />

            </div>

            <div class="loginform_row">

                <label>密码:</label>

                <input type="password" class="loginform_input" name="passWord" />

            </div>
            <div class="loginform_row">

                <label>真实姓名:</label>

                <input type="text" class="loginform_input" name="realName" />

            </div>
            <div class="loginform_row">

                <label>性别:</label>

                <input type="text" class="loginform_input" name="sex" />

            </div>
            <div class="loginform_row">

                <label>法名:</label>

                <input type="text" class="loginform_input" name="dharmaName" />

            </div>
            </div>
            <div class="loginform_row">

                <label>头像:</label>

                <input type="text" class="loginform_input" name="profile" />

            <div class="loginform_row">

                <label>地址:</label>

                <input type="text" class="loginform_input" name="address" />

            </div>
            <div class="loginform_row">

                <label>签名:</label>

                <input type="text" class="loginform_input" name="signature" />

            </div>
            <div class="loginform_row">

                <label>联系电话:</label>

                <input type="text" class="loginform_input" name="phone" />

            </div>

            <div class="loginform_row">

                <span class = "returnInfo"></span>

                <input type="submit" class="loginform_submit" value="注册" />

            </div>

            <div class="clear"></div>

        </div>

    </form>
</div>

</body>

</html>