<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${requestScope.lang}" />
<fmt:setBundle basename="messages" />

<!DOCTYPE html-->
<html lang="${requestScope.lang}">

<link href="css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<nav class="navbar navbar-expand-lg navbar-dark navbar-custom ">

	<a class="navbar-brand" href="admin?page=main"> <img
		src="imgs/header.jpg" width="400" height="128" alt="">
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav menu-nav">

			<li class="nav-item active l1"><a class="nav-link"
				href="admin?page=main"><fmt:message key="admin.header.main" /><span
					class="sr-only">(current)</span> </a></li>


			<li class="nav-item active l1"><a class="nav-link"
				href="admin?page=allproducts"><fmt:message
						key="admin.header.products" /><span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active l1"><a class="nav-link"
				href="admin?page=addproduct"><fmt:message
						key="admin.header.addProducts" /><span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active l1"><a class="nav-link"
				href="admin?page=allusers"><fmt:message key="admin.header.users" /><span
					class="sr-only">(current)</span> </a></li>
			<li class="nav-item active l1"><a class="nav-link"
				href="admin?page=allorders"><fmt:message
						key="admin.header.orders" /><span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item active l1"><a class="nav-link"
				href="control?page=logout"><fmt:message
						key="admin.header.logout" /><span class="sr-only">(current)</span>
			</a></li>


			<c:choose>
				<c:when test="${requestScope.lang == 'en'}">
					<a href="javascript:settingsLang('uk')"
						class="nav-link text-secondary"><span
						class="text-center text-muted"><img alt=""
							src="imgs/ukr1.jpg" style="width: 40px; height: 40px;"></span></a>
				</c:when>
				<c:otherwise>
					<a href="javascript:settingsLang('en')"
						class="nav-link text-secondary"><span
						class="text-center text-muted"><img alt=""
							src="imgs/usa1.jpg" style="width: 37px; height: 37px;"></span></a>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>

</nav>
<script src="js/lang.js"></script>