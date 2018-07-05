<%--
  Created by IntelliJ IDEA.
  User: watermelon
  Date: 2018/7/1
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>购物车列表</title>
    <div align="center">
    <table border="1" cellpadding="0" cellspacing="0" width="800px">
        <tr>
            <th>商品名</th>
            <th>单价</th>
            <th>数量</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${SESSION_IN_CART.listItem}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.num}</td>
                <td><a href="/shoppingCart?cmd=delete&id=${item.id}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" align="right">购物车总价：${SESSION_IN_CART.totalPrice}</td>
        </tr>
    </table>
    <a href="/shoppingCart?cmd=shopping">去购物</a>
    </div>
</head>
<body>

</body>
</html>
