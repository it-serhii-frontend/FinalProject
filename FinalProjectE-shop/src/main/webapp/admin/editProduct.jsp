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
	<div class="container">
		<div class="header2"><fmt:message key="admin.editProduct" /></div>

		<form method="post" action="admin">

			<input type="hidden" name="page" value="edit_product"> <input
				type="hidden" name="id" value="<c:out value="${p.getId() }"/>">

			<div class="signup-group">
				<label><fmt:message key="admin.editProduct.name" /></label> <input type="text" name="name"
					value="<c:out value="${p.getName() }"></c:out>" required>
			</div>
			<div class="signup-group">
				<label><fmt:message key="admin.editProduct.description" /></label> <input type="text" name="description"
					value="<c:out value="${p.getDescription() }"></c:out>" required>
			</div>
			<div class="signup-group">
				<label><fmt:message key="admin.editProduct.price" /></label> <input type="text" name="price"
					value="<c:out value="${p.getPrice() }"></c:out>" required>
			</div>
			<div class="signup-group">
				<label><fmt:message key="admin.editProduct.category" /></label> <input type="text" name="category"
					value="<c:out value="${p.getCategory() }"></c:out>" required>
			</div>
			<div class="signup-group">
				<label><fmt:message key="admin.editProduct.created" /></label> <input type="text" name="created"
					value="<c:out value="${p.getCreated_At() }"></c:out>" required>
			</div>
			<div class="signup-group">
				<label><fmt:message key="admin.editProduct.img" /></label> <img style="height: 160px; width: 160px;"
					src="<c:out value="${p.getImage() }"></c:out>">
			</div>
			<div class="signup-group">
				<input type="submit" value="<fmt:message key="admin.editProduct.buttom.edit" />">
			</div>
		</form>
	</div>


</body>

</html>