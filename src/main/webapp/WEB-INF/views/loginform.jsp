<!-- 로그인 폼 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title> 로그인</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>


<body>

   <article class="container col-md-10 col-md-offset-1">

      <div class="page-header col-md-6">
         <!--왼쪽 이미지 박스-->
         <h1>
            Site info 
                <small>ST2M</small> 
         </h1>
         <img src="">
      </div>

      <div class="page-header col-md-6">
         <!--오른쪽 박스-->
         <h1>Login</h1>


         <form:form modelAttribute="infoVO" action="login" method="POST">
            <div class="form-group">
               <p>   
                  <!--이메일로 로그인하기-->
                  <label for="email" style="width: 55px">이메일</label>
                  <form:input path="email" type="email" length="400"
                     placeholder="이메일 주소(ID)" />
               </p>
               <p>
                  <!--비밀번호 넣기-->
                  <label for="InputPassword">비밀번호</label>
                        <form:input path="password" type="password" length="400" placeholder="비밀번호" />
               </p>
            <p>
					<input type="submit" value="Submit">
				</p>
            </div>
         </form:form>
      </div>
   </article>
</body>
</html>