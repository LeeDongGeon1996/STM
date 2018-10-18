<!-- 메인화면 홈 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>

<head>
<title>메인 홈 화면</title>
</head>

<body>
	<div class="div-nav">
		<button class=" btn-home">STM</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<text class="text-page">Main Page</text>
		<button class="btn-logout">Logout</button>
	</div>

	<div class="div-text">
		<text class="text-smallN">시험지 제작 툴 </text>
		<text class="text-bigN">STM</text>
	</div>

	<div class="div-exp">
		<text class="text-exp">Make your own optimized test paper using
		STM</text>
	</div>

	<!--button-->
	<div class="div-container">
		<div class="row">
			<div class="div-btn">
				<form:form action="questionform" method="GET">
					<button class=" btn-question" type="submit">내 문제</button>
				</form:form>
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div class="div-btn">
				<form:form action="testform" method="GET">
					<button class=" btn-paper" type="submit">내 시험지</button>
				</form:form>
			</div>
		</div>
	</div>
</body>

<style>
body {
	background-color: rgb(51, 196, 241);
}

.text-smallN {
	font-family: mbcL;
	color: rgb(7, 79, 102);
	font-size: 50pt;
}

.text-bigN {
	font-family: typoSMB;
	color: rgb(250, 217, 86);
	font-size: 98pt;
}

.text-exp {
	color: white;
	font-size: 27pt;
}

.div-text {
	margin-left: 27%;
	margin-top: 5%;
}

.div-exp {
	margin-left: 25%;
	margin-top: 30px;
}

.div-container {
	width: 500px;
	margin: auto;
	margin-top: 90px;
}

.btn-question {
	color: white;
	background-color: rgb(250, 217, 86);
	border-radius: 8px;
	border: none;
	color: #FFFFFF;
	text-align: center;
	width: 150px;
	font-size: 20pt;
	font-family: mbcL;
	padding: 9px;
	cursor: pointer;
}

.btn-paper {
	color: white;
	background-color: rgb(7, 79, 102);
	border-radius: 8px;
	border: none;
	color: #FFFFFF;
	text-align: center;
	width: 150px;
	font-size: 20pt;
	font-family: mbcL;
	padding: 9px;
	cursor: pointer;
}

.div-btn {
	display: inline-block;
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
	font-family: typoSMB;
	color: rgb(7, 79, 102);
	position: absolute;
	top: 10px;
	right: 30px;
	cursor: pointer;
}

.text-page {
	font-family: typoSMB;
	background-color: transparent;
	font-size: 35pt;
	color: rgb(51, 196, 241);
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