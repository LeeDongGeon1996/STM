<!-- 회원가입 폼 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>회원가입</title>
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
				사이트 설명 <small>ST2M</small>
			</h1>
			<img src="">
		</div>

		<div class="page-header col-md-6">
			<!--오른쪽 박스-->
			<h1>회원가입</h1>


			<form:form modelAttribute="infoVO" action="getinfo" method="POST">
				<div class="form-group">
					<p>
						<!--이름넣기-->
						<label for="InputName">이름</label>
						<form:input path="name" type="textbox" class="form-control"
							placeholder="성함" />
					</p>
					<p>
						<!--이메일주소넣기-->
						<label for="InputEmail">이메일 주소(ID)</label>
						<form:input path="email" type="email" class="form-control"
							placeholder="이메일 주소(ID)" />
					</p>
					<p>
						<!--비밀번호넣기-->
						<label for="InputPassword1">비밀번호</label>
						<form:input path="password" type="password" class="form-control"
							placeholder="비밀번호" />
					</p>
					<p>
						<!--비밀번호 확인하기-->
						<label for="InputPassword2">비밀번호 확인</label>
						<form:input path="password" class="form-control"
							placeholder="비밀번호 확인" />
					<p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>

					<p>
						<!--생일넣기-->
						<label for="InputBirthday">생일</label>
						<form:input path="birth" type="date" class="form-control"
							placeholder="생년월일" />
					</p>
					<p>
						<!--주소넣기-->
						<label for="InputAddress">주소</label>
						<form:input path="address" type="textbox" class="form-control"
							placeholder="자택 주소" />
					</p>
					<p>
						<!--전화번호넣기-->
						<label for="InputPhoneNum">휴대폰 번호</label>
						<form:input path="pNum" type="tel" class="form-control"
							placeholder="휴대폰 번호 : - 없이 입력해 주세요!" />
					</p>

				</div>

				<p>
					<input type="submit" value="Submit">
				</p>
			</form:form>
		</div>

	</article>
</body>
</html>