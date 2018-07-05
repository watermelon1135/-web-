<%--
  Created by IntelliJ IDEA.
  User: watermelon
  Date: 2018/7/2
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账界面</title>
</head>
<body>
    <form action="/transForm" method="post">
        <input type="hidden" name="token" value="${token}"/>
        转账：<input type="text" name="money" required/><br>
        <input type="submit" value="我要转账！"/>
    </form>
</body>
</html>
