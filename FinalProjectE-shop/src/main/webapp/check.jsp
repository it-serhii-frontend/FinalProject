<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ua.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
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
			<jsp:include page="/header.jsp"></jsp:include>
		</div>
	</div>

	<c:choose>
		<c:when test="${session == null}">
			<%
				JOptionPane.showMessageDialog(null, "Please Login first", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			%>
		</c:when>

		<c:when test="${x == 0}">

			<%
				JOptionPane.showMessageDialog(null, "Your shopping bag is empty", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			%>
		</c:when>

		<c:when test="${session != null}">


			<div class="container" style="margin-top: 60px; margin-bottom: 60px;">
				<div class="header2"><fmt:message key="check.thanks" /></div>
				<div class="header2">
					<fmt:message key="check.willConnect" />
					<c:out value="${email }"></c:out>
				</div>

			</div>
			<div class="container" style="width: 50%;">
				<a href="control?page=main&action=orders"><input type="button"
					value="<fmt:message key="check.buttom.agree" />" class="btn btn-dark"
					style="width: 100%; margin-bottom: 30px;"></a>
			</div>

		</c:when>

	</c:choose>



	<div class="view">
		<div class="pages">
			<jsp:include page="/footer.jsp"></jsp:include>
		</div>
	</div>