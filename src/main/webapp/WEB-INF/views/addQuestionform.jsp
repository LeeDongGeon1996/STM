<!-- 문제 추가 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>

<head>
<title>문제 추가하기</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<div class="div-nav">
		<button class=" btn-home">STM</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<text class="text-page">문제 추가하기</text>
		<button class="btn-logout">Logout</button>
	</div>

	<div class="container-fluid">
		<div class="container-fluid outterB" style="width: 95%">
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8"
					style="padding: 0px">
					<div class="upperD" style="height: 350px">지문 입력하는 곳</div>
					<div class="downD" style="height: 250px">보기 입력하는 곳</div>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 rightD"
					style="height: 600px">문제 미리 보기</div>
			</div>
		</div>
	</div>
</body>

<style>
.outterB {
	border-style: solid;
	border-width: 3pt;
	border-color: rgb(51, 196, 241);
	margin: auto;
	border-radius: 50px;
}

.upperD {
	border: none;
	border-bottom: solid;
	border-width: 1pt;
	border-color: rgb(51, 196, 241);
	padding-top: 10px;
	padding-left: 20px;
}

.rightD {
	border: none;
	border-left: solid;
	border-width: 1pt;
	border-color: rgb(51, 196, 241);
	padding-top: 10px;
	padding-left: 20px;
}

.downD {
	padding-top: 10px;
	padding-left: 20px;
}

.div-nav {
	width: 1550px;
	margin: auto;
	margin-top: 25px;
	margin-bottom: 10px;
}

.btn-home {
	color: rgb(246, 129, 112);
	background-color: transparent;
	font-size: 21pt;
	border: none;
	cursor: pointer;
	font-family: typoSMB;
	position: absolute;
	top: 10px;
	left: 30px;
}

.btn-logout {
	border: none;
	color: rgb(7, 79, 102);
	background-color: transparent;
	font-size: 21pt;
	cursor: pointer;
	font-family: typoSMB;
	color: rgb(7, 79, 102);
	position: absolute;
	top: 10px;
	right: 30px;
}

.text-page {
	font-family: typoSMB;
	background-color: transparent;
	font-size: 35pt;
	color: black;
	margin-left: 90px;
}

@font-face {
	font-family: typoSMB;
	src: url(typoSMB.eot); /* IE 호환성 보기 */
	src:
		url('${pageContext.request.contextPath}/resources/font/typoSMB.eot')
		format('embedded-opentype'), /* IE 6 ~ 8 */  
		url('${pageContext.request.contextPath}/resources/font/typoSMB.woff')
		format('woff'), /* 모던 브라우저 */ 
		 url('${pageContext.request.contextPath}/resources/font/typoSMB.ttf')
		format('truetype');
}

@font-face {
	font-family: mbcL;
	src: url(mbcL.eot); /* IE 호환성 보기 */
	src: url('${pageContext.request.contextPath}/resources/font/mbcL.eot')
		format('embedded-opentype'), /* IE 6 ~ 8 */ 
		 url('${pageContext.request.contextPath}/resources/font/mbcL.woff')
		format('woff'), /* 모던 브라우저 */
      url('${pageContext.request.contextPath}/resources/font/mbcL.ttf')
		format('truetype');
}
</style>

</html>