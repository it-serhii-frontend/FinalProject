<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${requestScope.lang}" />
<fmt:setBundle basename="messages" />

<!DOCTYPE html-->
<html lang="${requestScope.lang}">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><fmt:message key="header.title" /></title>

<link href="css/main.css" rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="view">
		<div class="pages">
			<jsp:include page="../admin/headerAdmin.jsp"></jsp:include>
		</div>
	</div>

	<sql:setDataSource user="root" password="s6401vr3"
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/eShop" var="prod" />

	<sql:query var="result" dataSource="${prod }">
 
		 select * from products_dish
		 
	   </sql:query>
	<div class="header2">
		<fmt:message key="admin.allProducts" />
	</div>

	<div class="container">
		<table style="table-layout: fixed; width: 100%;">
			<tr>
				<th><fmt:message key="admin.allProducts.id" /></th>
				<th><fmt:message key="admin.allProducts.name" /></th>
				<th><fmt:message key="admin.allProducts.description" /></th>
				<th><fmt:message key="admin.allProducts.price" /></th>
				<th><fmt:message key="admin.allProducts.category" /></th>
				<th><fmt:message key="admin.allProducts.img" /></th>
				<th><fmt:message key="admin.allProducts.action" /></th>
			</tr>

			<c:forEach items="${result.rows }" var="row">


				<tr>
					<td style="width: 50px;"><c:out value="${row.id }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.name }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.description }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.price }"></c:out>₴</td>
					<td style="width: 100px;"><c:out value="${row.category}" /></td>
					<td style="width: 100px;"><img src="${row.image}" height="150"
						width="150"></td>
					<td style="width: 100px;"><a
						href="<%= request.getContextPath() %>/admin?page=edit&id=${row.id}"
						style="color: #6bb1f8;"><fmt:message
								key="admin.allProducts.buttom.edit" /></a> / <a
						href="<%= request.getContextPath() %>/admin?page=delete&id=${row.id}"
						style="color: #6bb1f8;"><fmt:message
								key="admin.allProducts.buttom.delete" /></a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>