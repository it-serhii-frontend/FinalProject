<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<jsp:include page="/header.jsp"></jsp:include>
		</div>
	</div>

	<div class="header2">
		<fmt:message key="login.log" />
	</div>
	<div class="container">
		<div class="row"
			style="margin-left: auto; margin-right: auto; width: 6em">
			<form method="post" action="control">

				<input type="hidden" name="page" value="loginForm">

				<div>
					<h4>
						<fmt:message key="login.log.user" />
					</h4>
				</div>
				<div class="signup-group">
					<label><fmt:message key="login.log.username" /></label> <input
						type="text" name="username" placeholder="Your Username"
						value="<c:out value="${username }"></c:out>">
				</div>
				<div class="signup-group">
					<label><fmt:message key="login.log.password" /></label> <input
						type="password" name="password" placeholder="Enter password">
				</div>
				
				<div class="signup-group">
					<button type="submit" name="login" class="signup-btn">
						<fmt:message key="login.buttom.in" />
					</button>
				</div>
			</form>
			<br> <br> <br>


		</div>
		<div class="row"
			style="margin-left: auto; margin-right: auto; width: 6em">


			<form method="post" action="admin">

				<input type="hidden" name="page" value="admin-login-form">

				<div>
					<h4>
						<fmt:message key="login.log.admin" />
					</h4>
				</div>
				<div class="signup-group">
					<label><fmt:message key="login.log.username" /></label> <input
						type="text" name="username" placeholder="Your Username"
						value="<c:out value="${username }"></c:out>">
				</div>
				<div class="signup-group">
					<label><fmt:message key="login.log.password" /></label> <input
						type="password" name="password" placeholder="Enter password">
				</div>
				<div class="signup-group">
					<button type="submit" name="login" class="signup-btn">
						<fmt:message key="login.buttom.in" />
					</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>