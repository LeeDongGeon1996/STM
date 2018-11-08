<!--시험지 만드는 화면-->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<title>시험지 만들기</title>

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

<script src="https://cdn.ckeditor.com/4.8.0/full-all/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/editor.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/html2canvas.js"></script>
<script>
	function onLoad() {
		makeTestPaper("${testpaperVO.htmlLink}");
	}
</script>
<script language="javascript">
   $(
         function() {
            $('#btn_submit')
                  .click(
                        function() {
                        	$("#cke_1_contents").attr("id","captureDiv");
                           html2canvas(
                                 document
                                       .querySelector("#captureDiv"))
                                 .then(
                                       function(canvas) {
                                          var image = new Image();
                                          image = canvas
                                                .toDataURL("image/png");
                                          console.log($(
                                                "#captestData")
                                                .val(image));
                                          document
                                                .getElementById("captestValue").value = image;
                                      
                                          		//html값 넘겨주는 함수 // editor.js 에 있다
                                      			submit_testpaper();
                                          $("#btnfinal").trigger(
                                                'click');
                                       })
                        })
         })
</script>
</head>
<body onload="onLoad();">
	<header id="main_header">
		<div class="div-nav">
			<button class=" btn-home" onclick="window.location.href='./home'">STM</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<text class="text-page">시험지 만들기</text>
			<button class="btn-logout">Logout</button>

		</div>
	</header>
	<section id="main_section">
		<div style="width: 1500px; height: 580px;">
			<div class="container-fluid">
				<div class="container-fluid ">
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"
							style="padding: 0px; text-align: center">
							<text class="exp">사용할 문제를 선택해주세요</text>
							<div class="outterB topC" id="row-container">
								<button class="arrow-button btn-left"
									onclick="btnOnclick_left()">
									<img
										src="${pageContext.request.contextPath}/resources/image/left_arrow.png">
								</button>
								<button class="arrow-button btn-right"
									onclick="btnOnclick_right()">
									<img
										src="${pageContext.request.contextPath}/resources/image/right_arrow.png">
								</button>
								<div class="row row-question row-0 on" id="row-up" value="0">
									<div id="img-0"
										class="col-lg-4 col-md-4 col-sm-4 col-xs-4 div-img"></div>
									<div id="img-1"
										class="col-lg-4 col-md-4 col-sm-4 col-xs-4 div-img"></div>
									<div id="img-2"
										class="col-lg-4 col-md-4 col-sm-4 col-xs-4 div-img"></div>
								</div>
								<br> <br>
								<div class="row row-question row-0 on" id="row-down" value="0">
									<div id="img-3"
										class="col-lg-4 col-md-4 col-sm-4 col-xs-4 div-img"></div>
									<div id="img-4"
										class="col-lg-4 col-md-4 col-sm-4 col-xs-4 div-img"></div>
									<div id="img-5"
										class="col-lg-4 col-md-4 col-sm-4 col-xs-4 div-img"></div>
								</div>
							</div>

							<text class="exp">선택된 문제는 아래와 같습니다</text>
							<div class="outterB bottomC innerPad">
								<div class="row" id="selectedQuestions"></div>
							</div>
						</div>

						<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8"
							style="text-align: center">
							<div class="printBtnZone" align="right">
								<button id="btn_submit" class="fix-savebutton btn-save">저장</button>
							</div>
							<div id="ck">
								<text class="exp">미리보기</text>
								<form name="captestForm" id="captestForm"
									enctype="multipart/form-data" method="post">
									<input type="hidden" id="captestData" name="captestData">
									<div class="outterB rightC">
										<div>
											<br>
											<textarea id="editor1" disable></textarea>
										</div>
									</div>
								</form>
							</div>
						</div>

						<form:form modelAttribute="testpaperVO" action="registerTest"
							method="POST" onSubmit="return Validate()" name="infos"
							enctype="multipart/form-data" id="form_testpaper_html">
							<form:input type="hidden" path="html" name="html" autofocus=""
								required="" id="testpaper_html"></form:input>
							<form:input path="CapTestValue" name="captestValue" autofocus=""
								required="" type="hidden" id="captestValue"></form:input>

							<button id="btnfinal" type="submit"></button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>

<script>
	assignQuestion(${questionList});
	loadQuestionList();
	$(".btn-left").hide();
</script>
<style>
img {
	border: 0;
	max-width: 100%;
	max-height: 100%;
}

.img-plus {
	width: 180px;
	height: 180px;
	padding: 0px;
	margin: auto;
	outline: none;
}

.innerPad {
	padding-left: 10%;
}

.outterB {
	border-style: solid;
	border-width: 3pt;
	border-color: rgb(51, 196, 241);
	border-radius: 50px;
	padding-left: 35px;
	padding-right: 30px;
}

.topC {
	margin-right: 10px;
	margin-bottom: 5px;
	height: 350px;
	z-index:100;
}

.bottomC {
	margin-right: 10px;
	margin-top: 5px;
	height: 180px;
}

.rightC {
   height: 1300px;
   padding-left: 35px;
}

.exp {
	font-family: mbcL;
	color: rgb(64);
	font-size: 15pt;
}

.arrow-button {
	position: absolute;
	width: 40px;
	opacity: 0.8;
	background-color: Transparent;
	background-repeat: no-repeat;
	border: none;
	cursor: pointer;
	overflow: hidden;
	outline: none;
}

.btn-left:active {
   transform: translateX(-5px);
}

.btn-right:active {
   transform: translateX(5px);
}

.btn-save:active {
   box-shadow: 2px 2px 1px rgb(118, 113, 113);
   transform: translateY(4px);
}

.btn-home:active {
   text-shadow: 2px 2px 2px rgb(47, 51, 63);
   transform: translateY(3px);
}

.btn-logout:active {
   text-shadow: 2px 2px 2px rgb(47, 51, 63);
   transform: translateY(3px);
}

.btn-left {
	top: 190px;
	left: 10px;
	z-index: 100;
}

.btn-right {
	top: 190px;
	right: 20px;
	z-index: 100;
}

.btn-save {
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
	position: absolute;
	top: -15px;
	right: 30px;
	outline: none;
	cursor: pointer;
}

.row {
	height: 40%;
}

.row-question{
	z-index:-1;
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
	width: 1500px;
	margin: 0 auto;
	margin-bottom: 50px;
	height: 60px;
	position: relative;
	top: 15px;
}

#main_section {
	width: 1500px;
	margin: auto;
	position: relative;
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