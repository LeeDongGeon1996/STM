<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>문제 추가하기</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<header id="main_header">
		<div class="div-nav">
			<button class=" btn-home">STM</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<text class="text-page">내 문제함</text>
			<button class="btn-logout">Logout</button>
		</div>
	</header>
	<!-- 섹션 부분 시작 -->
	<section id="main_section">
		<div>
			<div class="container-fluid surB"
				style="width: 1000px; height: 580px; padding: 55px;">
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img ">
						<div class="img-plus">
							<input type="image" class="img-plus"
								src="${pageContext.request.contextPath}/resources/image/plusImg.png" />
						</div>
					</div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
				</div>
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
				</div>
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
				</div>


			</div>
		</div>
	</section>
	<!--  <div class="img-plus">
				<input type="image" class="img-plus"
					src="${pageContext.request.contextPath}/resources/image/plusImg.png" />
			</div> -->
</body>
</html>

<style>
/*초기화 코드*/
* {
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
}

a {
	text-decoration: 0;
}

img {
	border: 0;
	max-width: 100%;
	max-height: 100%;
}

.surB {
	border-style: solid;
	border-width: 3pt;
	border-color: rgb(51, 196, 241);
	border-radius: 40px;
	padding: 20px;
}

.div-img {
	border-width: 1pt;
	border-color: rgb(51, 196, 241);
	border-style: none;
	width: 150px;
	height: 150px;
}

.img-plus {
	width: 80px;
	height: 80px;
	padding: 0px;
	margin: auto;
	outline: none;
	
}
/* 전체 적용 코드 */

/*스타일 적용*/
#main_header {
	width: 1000px;
	margin: 0 auto;
	margin-bottom: 50px;
	height: 60px;
	position: relative;
	top: 15px;
}

#main_section {
	width: 1000px;
	margin: 20px auto;
	position: relative;
}

.btn-home { /*왼쪽 위 홈으로 가는 버튼*/
	color: rgb(246, 129, 112);
	background-color: transparent;
	font-size: 21pt;
	border: none;
	cursor: pointer;
	font-family: typoSMB;
	position: absolute;
	left: 30px;
	outline: none;
}

.btn-home:active {
text-shadow: 2px 2px 2px rgb(47, 51, 63);
transform: translateY(3px);
}

.btn-logout { /*오른쪽 위 로그인하는 버튼*/
	border: none;
	color: rgb(7, 79, 102);
	background-color: transparent;
	font-size: 15pt;
	cursor: pointer;
	font-family: typoSMB;
	color: rgb(7, 79, 102);
	position: absolute;
	right: 30px;
	outline: none;
}

.btn-logout:active {
text-shadow: 2px 2px 2px rgb(47, 51, 63);
transform: translateY(3px);
}

.text-page { /*상단 중앙 현재 무슨 페이지인지 나타냄*/
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
