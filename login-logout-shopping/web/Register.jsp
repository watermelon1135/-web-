<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
</head>
<body>
		<div align="center" style="width: 40%;background-color: #c6a1b9;margin-left: 30%">
            <h3 style="font-family: 微软雅黑;font-size: 20px">开始注册</h3>
		<span style="color: red"> ${errorMsg}</span>
		<form action="/register" method="POST">
		账号：<input type="text" name="username"/><br/>
		密码：<input type="password" name="password"/><br/>
		确认密码：<input type="password" name="passwordTwo"/><br/>
			<a href="/Login.jsp">返回登录</a>
		<input type="submit" value="点我注册"/>
		</form>
        </div>
</body>
</html>