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

	<div class="container">
		<div class="header2">
			<fmt:message key="signup.log.user" />
		</div>
		<div class="row"
			style="margin-left: auto; margin-right: auto; width: 6em">

			<form method="post" action="control">
				<input type="hidden" name="page" value="checkCode">
				<div class="signup-group">
					<label>Input your email and we send you code</label> <input
						type="email" name="email" placeholder="Enter email" required>
				</div>

				<div class="signup-group">
					<button type="submit" name="checkCode" class="signup-btn">
						Send code!</button>
				</div>
			</form>

			<form method="post" action="control">

				<input type="hidden" name="page" value="signUpform">

				<div class="signup-group">
					<label><fmt:message key="signup.log.name" /></label> <input
						type="text" name="name" placeholder="Enter name"
						value="<c:out value="${name }"></c:out>" required>
				</div>
				<div class="signup-group">
					<label><fmt:message key="signup.log.email" /></label> <input
						type="email" name="email" placeholder="Enter email"
						value="<c:out value="${email }"></c:out>" required>
				</div>
				<div class="signup-group">
					<label><fmt:message key="signup.log.username" /></label> <input
						type="text" name="username" placeholder="Enter username"
						value="<c:out value="${username }"></c:out>" required>
				</div>

				<div class="signup-group">
					<label><fmt:message key="signup.log.address" /></label> <input
						type="text" name="address" placeholder="Enter address"
						value="<c:out value="${address }"></c:out>" required>
				</div>
				<div class="signup-group">
					<label><fmt:message key="signup.log.password" /></label> <input
						type="password" minlength="6" name="password_1"
						placeholder="Enter password, at least 6 symbols" required>
				</div>
				<div class="signup-group">
					<label><fmt:message key="signup.log.confirmPass" /></label> <input
						type="password" minlength="6" name="password_2"
						placeholder="Repeat password, at least 6 symbols" required>
				</div>

				<div class="signup-group">
					<label><fmt:message key="signup.log.code" /></label> <input type="number" name="code"
						placeholder="Enter code" required>
				</div>

				<div class="signup-group">
					<button type="submit" name="register" class="signup-btn">
						<fmt:message key="signup.buttom.regist" />
					</button>
				</div>
				<p>
					<fmt:message key="signup.log.haveAccount" />
					<a href="control?page=login" style="color: #F24638;">Login!</a>
				</p>
			</form>
			<br> <br> <br>
		</div>
	</div>
</body>
</html>