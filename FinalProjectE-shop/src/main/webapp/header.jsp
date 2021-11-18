<link href="css/main.css" rel="stylesheet" type="text/css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${requestScope.lang}" />
<fmt:setBundle basename="messages" />

<!DOCTYPE html-->
<html lang="${requestScope.lang}">
<body>




	<nav class="navbar navbar-expand-lg navbar-dark navbar-custom ">

		<a class="navbar-brand" href="main.jsp"> <img
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
					href="main.jsp"> <fmt:message key="header.menu.main" /><span
						class="sr-only">(current)</span>
				</a></li>


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <fmt:message
							key="header.menu.catalog" />
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#"><fmt:message
								key="header.menu.tea" /></a> <a class="dropdown-item"
							href="allDish"><fmt:message key="header.menu.dish" /></a>
					</div></li>
				<c:choose>
					<c:when test="${session == null}">

						<li class="nav-item active l1"><a class="nav-link"
							href="login.jsp"><fmt:message key="header.menu.exit" /><span
								class="sr-only">(current)</span> </a></li>
						<li class="nav-item active l1"><a class="nav-link"
							href="control?page=signUp"><fmt:message
									key="header.menu.regist" /><span class="sr-only">(current)</span>
						</a></li>
					</c:when>
					<c:when test="${session != null}">

						<li class="nav-item active l1"><a class="nav-link"
							href="control?page=logout"><fmt:message
									key="header.menu.logout" /><span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item active l1"><a class="nav-link"
							href="control?page=userOrder"><fmt:message
									key="header.menu.yourCab" /> <c:out value="${username }"></c:out><span
								class="sr-only">(current)</span> </a></li>
					</c:when>
				</c:choose>

				<li class="nav-item active l1"><a class="nav-link"
					href="bucket"><fmt:message key="header.menu.bucket" /><span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item active l1"><a class="nav-link"
					href="aboutUs.jsp"><fmt:message key="header.menu.aboutUs" /><span
						class="sr-only">(current)</span> </a></li>


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


</body>


</html>
<script src="js/lang.js"></script>
