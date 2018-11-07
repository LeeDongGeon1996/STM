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
			<text class="text-page">문제 추가하기</text>
			<button class="btn-logout">Logout</button>
		</div>
	</header>
	<!-- 섹션 부분 시작 -->
	<section id="main_section">
		<div style="width: 1000px; height: 580px;">
			<div class="container-fluid">
				<div class="container-fluid">
					<div class="tab-content custom-tab-content">
						<div>

							<!-- Nav tabs -->
							<ul class="nav nav-tabs custom-tab" role="tablist">
								<li role="presentation" class="active"><a href="#home"
									aria-controls="home" role="tab" data-toggle="tab"><i
										class="glyphicon icon"></i><span class="link-lable">
											객관식</span></a></li>
								<li role="presentation"><a href="#messages"
									aria-controls="messages" role="tab" data-toggle="tab"><i
										class="glyphicon"></i><span class="link-lable"> 주관식</span></a></li>
							</ul>

							<div class="tab-content">
								<!-- 객관식 부분 -->
								<div role="tabpanel" class="tab-pane fade in active" id="home">
									<div class="container-fluid ">
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6"
												style="padding: 0px">
												<form style="word-break: break-all">
													<input class="outterB topC" type="text"
														placeholder="지문을 입력해주세요" required="" autofocus="">
												</form>

												<div class="filebox">
													<label for="ex_filename">이미지 업로드</label> <input type="file"
														id="ex_filename" class="upload-hidden"> <input
														class="upload-name" value="파일선택" disabled="disabled">
												</div>
												<div class="outterB bottomC">
													<div>
														<label style="font-size: 15pt;">①&nbsp</label> <input
															class="bgInsert" type="text" required="" autofocus="">
													</div>
													<div>
														<label style="font-size: 15pt;">②&nbsp</label> <input
															class="bgInsert" type="text" required="" autofocus="">
													</div>
													<div>
														<label style="font-size: 15pt;">③&nbsp</label> <input
															class="bgInsert" type="text" required="" autofocus="">
													</div>
													<div>
														<label style="font-size: 15pt;">④&nbsp</label> <input
															class="bgInsert" type="text" required="" autofocus="">
													</div>
													<div>
														<label style="font-size: 15pt;">⑤&nbsp</label> <input
															class="bgInsert" type="text" required="" autofocus="">
													</div>
												</div>
												<div>
													<label class="label-answer">정답 입력</label> <label
														style="font-size: 15pt;">&nbsp;&nbsp;①&nbsp;</label><input
														type="radio" name="answer" value="1"> <label
														style="font-size: 15pt;">&nbsp;&nbsp;②&nbsp;</label><input
														type="radio" name="answer" value="2"> <label
														style="font-size: 15pt;">&nbsp;&nbsp;③&nbsp;</label><input
														type="radio" name="answer" value="3"> <label
														style="font-size: 15pt;">&nbsp;&nbsp;④&nbsp;</label><input
														type="radio" name="answer" value="4"> <label
														style="font-size: 15pt;">&nbsp;&nbsp;⑤&nbsp;</label><input
														type="radio" name="answer" value="5">
												</div>
											</div>

											<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6"
												style="text-align: center">

												<div class="outterB rightC">!!!!!!!!!!여기에 에디터
													넣어!!!!!!!!!!!!!</div>
												<div>
													<form:form action="testform" method="POST">
														<button class=" btn-save" type="submit">저장</button>
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<button class=" btn-new" type="submit">새로만들기</button>
													</form:form>
												</div>
											</div>
										</div>
									</div>
								</div>






								<!-- 주관식 부분 -->
								<div role="tabpanel" class="tab-pane fade" id="messages">
									<div class="container-fluid ">
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6"
												style="padding: 0px">
												<form>
													<textarea id="sleftC" class="outterB sleftC"
														placeholder="지문을 입력해주세요" required="" autofocus="" rows="4"
														cols="50"></textarea>
												</form>

												<div class="filebox2">
													<label for="ex_filename2">이미지 업로드</label> <input
														type="file" id="ex_filename2" class="upload-hidden2">
													<input class="upload-name2" value="파일선택"
														disabled="disabled">
												</div>

												<div style="vertical-align: top;">
													<label class="label-answer2">정답 입력</label> <input
														id="jdInsert" class="jdInsert" type="text">

												</div>
											</div>

											<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6"
												style="text-align: center">

												<div class="outterB srightC">!!!!!!!!!!여기에 에디터
													넣어!!!!!!!!!!!!!</div>
												<div>
													<form:form action="testform" method="POST">
														<button id="sbtn-save" class="sbtn-save" type="submit">저장</button>
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<button id="sbtn-new" class="sbtn-new" type="submit">새로
															만들기</button>
													</form:form>
												</div>
											</div>
										</div>
									</div>
								</div>


							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
</body>
</html>

<style>
.custom-tab>li>a {
	-webkit-border-radius: 0;
	-moz-border-radius: 0;
	border-radius: 0;
}

.custom-tab>li {
	-webkit-border-radius: 0;
	-moz-border-radius: 0;
	border-radius: 0;
}

.custom-tab>li>a:link {
	border-top: 3px solid #00bfff;
	border-right: 1px solid #00bfff;
	border-left: 1px solid #00bfff;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover,
	.nav-tabs>li.active>a:visited {
	background-color: #00bfff;
	border-top: 3px solid #00bfff;
	border-right: 1px solid #00bfff;
	border-left: 1px solid #00bfff;
	color: #FFF;
}

i {
	color: #000;
}

.link-lable {
	text-decoration: none;
	font-size: 20px;
	font-family: mbcL;
}

@media screen and (max-width: 767px) {
	.link-lable {
		display: none;
	}
}
/*---------------객관식----------------*/
.filebox input[type="file"] {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
	cursor: pointer;
}

.filebox label {
	font-size: 15pt;
	font-family: mbcL;
	color: white;
	text-align: center;
	border-radius: 8px;
	border: none;
	width: 150px;
	padding: 5px;
	background: rgb(49, 207, 255);
	cursor: pointer;
}
/* named upload */
.filebox .upload-name {
	width: 310px;
	display: inline-block;
	padding: 5px; /* label의 패딩값과 일치 */
	font-size: inherit;
	font-family: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #f5f5f5;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
	-webkit-appearance: none; /* 네이티브 외형 감추기 */
	-moz-appearance: none;
	appearance: none;
}

.outterB {
	border-style: solid;
	border-width: 3pt;
	border-color: rgb(51, 196, 241);
	border-radius: 40px;
}

.topC {
	margin-right: 10px;
	margin-bottom: 5px;
	margin-top: 15px;
	height: 250px;
	width: 100%;
	word-break: break-all;
	word-wrap: break-word;
}

.bottomC {
	margin-right: 10px;
	margin-top: 5px;
	width: 100%;
	height: 225px;
	padding: 10px;
	padding-top: 23px;
}

.rightC {
	height: 530px;
	margin-top: 15px;
}

.bgInsert { /*객관식 보기 입력*/
	font-size: 15px;
	border: none;
	width: 400px;
}

.exp {
	font-family: mbcL;
	color: rgb(64);
	font-size: 15pt;
}

.label-answer {
	color: white;
	background-color: rgb(49, 207, 255);
	border-radius: 8px;
	border: none;
	text-align: center;
	width: 150px;
	font-size: 18pt;
	font-family: mbcL;
	font-weight: lighter;
	padding: 3px;
	margin-top: 7px;
}

.btn-save {
	color: white;
	background-color: rgb(250, 217, 86);
	border-radius: 8px;
	border: none;
	color: #FFFFFF;
	text-align: center;
	width: 150px;
	font-size: 18pt;
	font-family: mbcL;
	padding: 3px;
	margin-top: 10px;
}

.btn-new {
	color: white;
	background-color: rgb(7, 79, 102);
	border-radius: 8px;
	border: none;
	color: #FFFFFF;
	text-align: center;
	width: 150px;
	font-size: 18pt;
	font-family: mbcL;
	padding: 3px;
	margin-top: 10px;
}

/*---------------주관식----------------*/
.filebox2 input[type="file"] {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

.filebox2 label {
	color: white;
	background-color: rgb(49, 207, 255);
	border-radius: 8px;
	border: none;
	text-align: center;
	width: 150px;
	font-size: 18pt;
	font-family: mbcL;
	font-weight: lighter;
	padding: 3px;
	margin-top: 10px;
	cursor: pointer;
}
/* named upload */
.filebox2 .upload-name2 {
	width: 310px;
	display: inline-block;
	padding: 5px; /* label의 패딩값과 일치 */
	font-size: inherit;
	font-family: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #f5f5f5;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
	-webkit-appearance: none; /* 네이티브 외형 감추기 */
	-moz-appearance: none;
	appearance: none;
}

.sleftC {
	margin-right: 10px;
	margin-bottom: 5px;
	margin-top: 15px;
	padding: 15px;
	height: 480px;
	width: 100%;
	font-size: 18px;
}

.srightC {
	height: 530px;
	margin-top: 15px;
	width: 100%;
}

.label-answer2 {
	color: white;
	background-color: rgb(49, 207, 255);
	border-radius: 8px;
	border: none;
	text-align: center;
	width: 150px;
	font-size: 18pt;
	font-family: mbcL;
	font-weight: lighter;
}

.jdInsert { /*주관식 답 입력*/
	font-size: 16pt;
	width: 310px;
}

.sbtn-save {
	color: white;
	background-color: rgb(250, 217, 86);
	border-radius: 8px;
	border: none;
	text-align: center;
	width: 150px;
	font-size: 18pt;
	font-family: mbcL;
	padding: 3px;
	margin-top: 10px;
}

.sbtn-new {
	color: white;
	background-color: rgb(7, 79, 102);
	border-radius: 8px;
	border: none;
	text-align: center;
	width: 150px;
	font-size: 18pt;
	font-family: mbcL;
	padding: 3px;
	margin-top: 10px;
}

/* 전체 적용 코드 */
/*초기화 코드*/
* {
	margin: 0;
	padding: 0;
}

:focus {
	outline: none !important
}

li {
	list-style: none;
}

a {
	text-decoration: 0;
}

img {
	border: 0;
}

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

#main_footer {
	width: 1000px;
	margin: 0 auto;
	position: relative;
	bottom: 10px;
}

.btn-home {
	color: rgb(246, 129, 112);
	background-color: transparent;
	font-size: 21pt;
	border: none;
	cursor: pointer;
	font-family: typoSMB;
	position: absolute;
	left: 30px;
}

.btn-home:active {
text-shadow: 2px 2px 2px rgb(47, 51, 63);
transform: translateY(3px);
}


.btn-logout {
	border: none;
	color: rgb(7, 79, 102);
	background-color: transparent;
	font-size: 15pt;
	cursor: pointer;
	font-family: typoSMB;
	color: rgb(7, 79, 102);
	position: absolute;
	right: 30px;
}

.btn-logout:active {
text-shadow: 2px 2px 2px rgb(47, 51, 63);
transform: translateY(3px);
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

<script type="text/javascript">
	$(document).ready(
			function() {
				var fileTarget = $('.filebox .upload-hidden');
				fileTarget.on('change', function() {
					// 값이 변경되면 
					if (window.FileReader) { // modern browser 
						var filename = $(this)[0].files[0].name;
					} else { // old IE 
						var filename = $(this).val().split('/').pop().split(
								'\\').pop(); // 파일명만 추출 
					} // 추출한 파일명 삽입 
					$(this).siblings('.upload-name').val(filename);
				});
			});

	$(document).ready(
			function() {
				var fileTarget = $('.filebox2 .upload-hidden2');
				fileTarget.on('change', function() {
					// 값이 변경되면 
					if (window.FileReader) { // modern browser 
						var filename = $(this)[0].files[0].name;
					} else { // old IE 
						var filename = $(this).val().split('/').pop().split(
								'\\').pop(); // 파일명만 추출 
					} // 추출한 파일명 삽입 
					$(this).siblings('.upload-name2').val(filename);
				});
			});
	document.addEventListener('keydown', function(event) {
		if (event.keyCode === 13) {
			event.preventDefault();
		}
	}, true);
</script>
