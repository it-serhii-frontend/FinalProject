<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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


	<div class="header2"><fmt:message key="admin.addProduct.add" /></div>

	<div class="container">
		<form method="post" action="admin">

			<input type="hidden" name="page" value="add_product">

			<div class="signup-group">
			<label><fmt:message key="admin.addProduct.name" /></label><br>
				<input type="text" name="name" placeholder="Enter name" required>
			</div>
			<div class="signup-group">
			<label><fmt:message key="admin.addProduct.description" /></label><br>
				<input type="text" name="description" placeholder="Enter description"
					required>
			</div>
			<div class="signup-group">
			<label><fmt:message key="admin.addProduct.price" /></label><br>
				<input type="text" name="price" placeholder="Enter price" required>
			</div>
			<div class="signup-group">
			<label><fmt:message key="admin.addProduct.category" /></label><br>
				<input type="text" name="category" placeholder="Enter category"
					required>
			</div>
			<div class="signup-group">
			<label><fmt:message key="admin.addProduct.img" /></label><br>
				<label for="fileupload"><fmt:message key="admin.addProduct.buttom.img" /></label> <input type="file"
					name="image" required><br>
			</div>
			<div class="signup-group">
				<input class=" btn btn-dark" type="submit" value="<fmt:message key="admin.addProduct.buttom.add" />"/>
			</div>
		</form>
	</div>
</body>
</html>