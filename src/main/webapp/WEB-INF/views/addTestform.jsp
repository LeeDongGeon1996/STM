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
<script>
	function onLoad() {
		makeTestPaper();
	}
	assignQuestion(${questionList});
	setTimeout(function(){testScript();setTimeout(function(){testScript_re();},10000);},3000);
	
</script>
</head>
<body onload="onLoad();">
   <header id="main_header">
      <div class="div-nav">
         <button class=" btn-home">STM</button>
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
                     <div class="outterB topC"></div>

                     <text class="exp">선택된 문제는 아래와 같습니다</text>
                     <div class="outterB bottomC"></div>
                  </div>

                  <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8"
                     style="text-align: center">
                     <text class="exp">미리보기</text>
                     <div class="outterB rightC">
                     	<textarea id="editor1" disable></textarea>
                     </div>

                     <div class="div-btn">
                        <form:form action="testform" method="POST">
                           <button class=" btn-save" type="submit">저장</button>
                        </form:form>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>

   
</body>

<style>
.outterB {
   border-style: solid;
   border-width: 3pt;
   border-color: rgb(51, 196, 241);
   border-radius: 50px;
}

.topC {
   margin-right: 10px;
   margin-bottom: 5px;
   height: 350px;
}

.bottomC {
   margin-right: 10px;
   margin-top: 5px;
   height: 180px;
}

.rightC {
   height: 530px;
}

.exp {
   font-family: mbcL;
   color: rgb(64);
   font-size: 15pt;
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
   margin-top: 10px;
   cursor: pointer;
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