<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${requestScope.lang}" />
<fmt:setBundle basename="messages" />

<!DOCTYPE html-->
<html lang="${requestScope.lang}">
<head>
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


	<div id="carouselExampleSlidesOnly" class="carousel slide"
		data-ride="carousel">

		<div class="txt-b">
			<span class="sm">Vantea</span> <br> <span class="txt">Каталог
				посуду</span> <br> <span class="sm">Тут ви знайдете найзручніше
				начиння для чаювання</span> <br>
		</div>


		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" src="imgs/teaBack.jpg" alt="First slide">

			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="imgs/teaBack1.jpg"
					alt="Second slide">
			</div>

		</div>
	</div>

	<div class="header2">Виберіть чайний посуд під ваш настрій</div>

	<div class="subHead">
		<div class="subHead2">У нас є все, що може зробити ваш затишний
			вечір чи бадьорий ранок. Достатньо обрати Чашку, додати Чайник
			необхідного розміру і оформити замовлення.</div>
	</div>

	<div class="container" style="max-width: 80%">


		<div class="cont">
			<h5>
				<fmt:message key="allProducts.sort.name" />
			</h5>

			<form action="allDish" method="post"
				style="border: none; margin: 0px; padding: 0px; margin-bottom: 20px;">
				<input type="hidden" name="variant" value="sortName"> <select
					name="sort">
					<option value="asc"><fmt:message
							key="allProducts.sort.nameA-Z" /></option>
					<option value="desc"><fmt:message
							key="allProducts.sort.nameZ-A" /></option>
				</select> <input type="submit"
					value="<fmt:message
						key="allProducts.buttom.search" />">
			</form>
		</div>


		<div class="cont">
			<h5>
				<fmt:message key="allProducts.sort.price" />
			</h5>

			<form action="allDish" method="post"
				style="border: none; margin: 0px; padding: 0px; margin-bottom: 20px;">
				<input type="hidden" name="variant" value="sortPrice"> <select
					name="sort">
					<option value="asc"><fmt:message
							key="allProducts.sort.priceFromCheap" /></option>
					<option value="desc"><fmt:message
							key="allProducts.sort.priceFromRich" /></option>
				</select> <input type="submit"
					value="<fmt:message
						key="allProducts.buttom.search" />">
			</form>
		</div>

		<div class="cont">
			<h5>
				<fmt:message key="allProducts.sort.nov" />
			</h5>

			<form action="allDish" method="post"
				style="border: none; margin: 0px; padding: 0px; margin-bottom: 20px;">
				<input type="hidden" name="variant" value="sortDate"> <select
					name="sort">
					<option value="asc"><fmt:message
							key="allProducts.sort.novFromNew" /></option>
					<option value="desc"><fmt:message
							key="allProducts.sort.novFromOld" /></option>
				</select> <input type="submit"
					value="<fmt:message
						key="allProducts.buttom.search" />">
			</form>
		</div>

		<div class="cont">
			<h5>
				<fmt:message key="allProducts.sort.category" />
				:
			</h5>

			<form action="allDish" method="post"
				style="border: none; margin: 0px; padding: 0px; margin-bottom: 20px;">
				<input type="hidden" name="variant" value="sortCateg"> <select
					name="sort">
					<option value="all"><fmt:message
							key="allProducts.sort.categoryAll" /></option>
					<option value="glass"><fmt:message
							key="allProducts.sort.novGlass" /></option>
					<option value="kettle"><fmt:message
							key="allProducts.sort.novKettle" /></option>
				</select> <input type="submit"
					value="<fmt:message
						key="allProducts.buttom.search" />">
			</form>
		</div>
		<div class="cont">
			<h5>
				<fmt:message key="allProducts.sort.years" />
			</h5>

			<form action="allDish" method="post"
				style="border: none; margin: 0px; padding: 0px; margin-bottom: 20px;">
				<input type="hidden" name="variant" value="sortYear"> <select
					name="sort">
					<option value="all"><fmt:message
							key="allProducts.sort.yearsAll" /></option>
					<option value="2019"><fmt:message
							key="allProducts.sort.years2019" /></option>
					<option value="2020"><fmt:message
							key="allProducts.sort.years2020" /></option>
					<option value="2021"><fmt:message
							key="allProducts.sort.years2021" /></option>

				</select> <input type="submit"
					value="<fmt:message
						key="allProducts.buttom.search" />">
			</form>
		</div>

		<div class="cont">
			<h5>
				<fmt:message key="allProducts.sort.pages" />
				:
			</h5>

			<form action="allDish" method="post"
				style="border: none; margin: 0px; padding: 0px; margin-bottom: 20px;">
				<input type="hidden" name="variant" value="page"> <select
					name="sort">
					<option value="first"><fmt:message
							key="allProducts.sort.pagesOne" /></option>
					<option value="second"><fmt:message
							key="allProducts.sort.pagesTwo" /></option>
					<option value="all"><fmt:message
							key="allProducts.sort.pagesAll" /></option>
				</select> <input type="submit"
					value="<fmt:message
						key="allProducts.buttom.search" />">
			</form>
		</div>

	</div>

	<div class="container">
		<ul id="display-inline-block-example">
			<c:forEach items="${productlist}" var="product">
				<li style="margin-right: 150px"><img alt=""
					src="${product.image}" class="img-responsive"></li>
				<li><a style="color: black;"><c:out value="${product.name}"></c:out></a></li>
				<li><p>
						<c:out value="${product.price}"></c:out>
						₴
					</p></li>
				<li><p style="text-align: center;">

						<c:out value="${product.description}"></c:out>
					</p></li>


				<div class="text-center">
					<a class="btn btn-primary"
						href="control?page=addtocart&action=allproducts&id=<c:out value="${product.getId()}"/>"><fmt:message
							key="allProducts.buttom.addToCart" /></a>
				</div>

			</c:forEach>
		</ul>
	</div>


	<div class="view">
		<div class="pages">
			<jsp:include page="/footer.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>