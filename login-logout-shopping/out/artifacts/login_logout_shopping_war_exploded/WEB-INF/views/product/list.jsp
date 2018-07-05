<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>
	<div align="center">当前用户为：[${USER_IN_SESSION.username}]<a href="/cancel">注销</a>
	</div>
	<a href="/product?cmd=edit">添加商品信息</a>
	<table border="1" width="800px" cellpadding="0" cellspacing="0">
		<tr>
			<th>商品ID</th>
			<th>名称</th>
			<th>供应商</th>
			<th>价格</th>
			<th>库存</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${products}" var="p" varStatus="vs">
		<tr style='background-color:  ${vs.count%2 ==0? "gray":""}'>
			<td>${p.id}</td>
			<td>${p.product}</td>
			<td>${p.supplier}</td>
			<td>${p.price}</td>
			<td>${p.num}</td>
			<td><a href="/product?cmd=delete&id=${p.id}">删除</a> <a href="/product?cmd=edit&id=${p.id}">编辑</a></td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>