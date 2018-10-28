<!-- 내 문제함 화면 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>내 문제함</title>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script
   src="${pageContext.request.contextPath}/resources/questionform.js"></script>
<script
   src="${pageContext.request.contextPath}/resources/jquery.magnific-popup.js"></script>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/magnific-popup.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!--  Scripts-->
<!-- Latest compiled and minified JavaScript -->
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
   <!-- <div class="img-plus">
                     <input type="image" class="img-plus"
                        src="${pageContext.request.contextPath}/resources/image/plusImg.png" />
                  </div>
-->
   <header id="main_header">
      <div class="div-nav">
         <button class=" btn-home" onclick="window.location.href='./home'">STM</button>
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
               <div onclick="location.href='./addQuestion'"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img">
                  <div class="img-plus">
                     <input type="image" class="img-add"
                        src="${pageContext.request.contextPath}/resources/image/plusImg.png" />
                  </div>
               </div>
               <div id="img-0"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img "></div>
               <div id="img-1"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img "></div>
               <div id="img-2"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img "></div>
               <div id="img-3" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-4" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
            </div>
            <div class="row">
               <div id="img-5" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-6" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-7" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-8" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-9" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-10"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
            </div>
            <div class="row">
               <div id="img-11"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-12"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-13"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-14"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-15"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
               <div id="img-16"
                  class="col-lg-2 col-md-2 col-sm-2 col-xs-2 div-img"></div>
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
<script>
   assignQuestion(${questionList});
   loadQuestionList();
</script>
<script>$(document).ready(function() {

    $('.image-popup-no-margins').magnificPopup({
type: 'image',
closeOnContentClick: true,
closeBtnInside: false,
fixedContentPos: true,
mainClass: 'mfp-no-margins mfp-with-zoom', // class to remove default margin from left and right side
image: {
  verticalFit: true
},
zoom: {
  enabled: true,
  duration: 300 // don't foget to change the duration also in CSS
  
}
});
});
}</script>
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

.img-add {
   width: 120px;
   height: 120px;
   padding: 0px;
   margin: auto;
   margin-top: 10px;
   margin-bottom: 15px;
   outline: none;
   cursor: pointer;
}

.img-plus {
   width: 150px;
   height: 150px;
   padding: 0px;
   margin: auto;
   margin-bottom: 15px;
   outline: none;
   cursor: crosshair;
}

.imgBigL {
   position: fixed;
   right: 30px;
   top: 10%;
   width: 0px;
   -webkit-transtition: width 0.3s linear 0s;
   z-index: 10;
}

.imgBigR {
   position: fixed;
   left: 30px;
   top: 10%;
   width: 0px;
   -webkit-transtition: width 0.3s linear 0s;
   z-index: 10;
}

.img-plus:hover+.imgBigL {
   width: 500px;
   height: auto;
}

.img-plus:hover+.imgBigR {
   width: 500px;
   height: auto;
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