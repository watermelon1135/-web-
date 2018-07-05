<%--
  Created by IntelliJ IDEA.
  User: watermelon
  Date: 2018/7/1
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <form action="/shoppingCart?cmd=save" method="post">
        <select name="p_name">
            <option>iphonex</option>
            <option>手表</option>
            <option>衣服</option>
            <option>裤子</option>
        </select>
        <br/>
        购买数量<input type="number" min="1" name="p_num"/>
        <br/>
        <input type="submit" value="加入购物车"/>
    </form>
</body>
</html>
