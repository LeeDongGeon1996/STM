<!-- 내 문제함 화면 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>

<head>
<title>내 문제함</title>
</head>

<body>
	<div>
		<button class=" btn-home">STM</button>
		<button class=" btn-logout">logout</button>

	</div>
	<div class="container">
	<div>
		<div class="img-plus">
		<input type="image" class="img-plus"
		src="${pageContext.request.contextPath}/resources/image/plusImg.png"/>
		</div>
		</div>
	</div>
</body>

<style>
img {
    max-width: 100%;
    max-height: 100%;
}

.container {
	border-style: solid;
	border-width: 3pt;
	border-color: rgb(23, 186, 239);
	margin: 3% 5%;
	height: 600px;
	padding: 0% 2%;
}

.img-plus {
	width: 100px; /*width of your image*/
	height: 100px; /*height of your image*/
	margin: 3%; /* If you want no margin */
	padding: 0; /*if your want to padding */
	border: none;
}

.btn-home {
	color: rgb(238, 131, 111);
	background-color: transparent;
	font-size: 14pt;
	border: none;
	cursor: pointer;
}

.btn-logout {
	color: rgb(7, 79, 102);
	background-color: transparent;
	font-size: 14pt;
	border: none;
	cursor: pointer;
}
</style>

</html>