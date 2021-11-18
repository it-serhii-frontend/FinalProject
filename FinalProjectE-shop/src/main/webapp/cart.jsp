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
		<fmt:message key="bucket.name" />
	</div>

	<div class="container">

		<c:set var="sum" value="0"></c:set>
		<c:forEach items="${cartList }" var="i">
			<c:forEach items="${productlist }" var="Product">
				<c:if test="${i == Product.getId() }">

					<c:set var="sum" value="${sum + Product.getPrice() }"></c:set>

					<table style="table-layout: fixed; width: 100%;">
						<tr>
							<td style="width: 100px;"><img src="${Product.getImage()}"
								height="100" width="150"> (<c:out
									value="${Product.getName()}" />)</td>
							<td style="width: 50px;"><c:out
									value="${Product.getDescription()}" /></td>
							<td style="width: 50px;"><c:out
									value="${Product.getPrice()}" />₴</td>
							<td style="width: 100px;"><c:out
									value="${Product.getCategory()}" /></td>
							<td style="width: 100px;"><a
								href="control?page=remove&id=<c:out value="${Product.getId()}"/>"><span
									class="btn btn-danger">X</span></a></td>
						</tr>
					</table>
					<div class="container">
						<a
							href="control?page=success&prodid=<c:out value="${Product.getId()}&user=${email}"></c:out>"><input
							type="submit" value="<fmt:message key="bucket.buttom.buy" />"
							class="btn btn-dark"
							style="width: 50%; padding: 8px; font-size: 16px; margin-bottom: 30px;"></a>
						<br> <a href="allDish"><input type="button"
							value="<fmt:message key="bucket.buttom.continue" />"
							class="btn btn-dark"
							style="width: 50%; padding: 8px; font-size: 16px; margin-bottom: 30px;"></a>
					</div>
				</c:if>
			</c:forEach>
		</c:forEach>


		<h4 style="margin-top: 40px; margin-bottom: 270px;">
			<fmt:message key="bucket.allSum" />
			<c:out value="${ sum}"></c:out>
			₴
		</h4>

	</div>
	<div class="view">
		<div class="pages">
			<jsp:include page="/footer.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>