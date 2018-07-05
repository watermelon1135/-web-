<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写商品信息</title>
</head>
<body>
	<div align="center">当前用户为：[${USER_IN_SESSION.username}]</div>
			<h3>填写商品信息</h3><br/>
		<form action="/product?cmd=save"  method="post">
				<input type="hidden" name='id' value="${product.id}">
		商品名称：<input type="text" name="product" value="${product.product}"><br/>
		供应商：<input type="text" name="supplier" value="${product.supplier}"><br/>
		价格：<input type="number" name="price" value="${product.price}"><br/>
		库存：<input type="number" name="num" value="${product.num}"><br/>
				<input type="submit" value="提交">
		</form>
</body>
</html>