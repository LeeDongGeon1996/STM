<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<title>이미지 업로드 테스트</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<form action="fileUpload" id="fileUpload" name="fileUplaod"
		method="POST" enctype="multipart/form-data">
		이름 : <input type="text" name="name" id="cmd" value="namevla"><br>
		파일 : <input type="file" name="file" placeholder="파일 선택"><br>
		<input type="submit" name="업로드" value="제출"><br>
	</form>

	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-xl-9 mx-auto">
				<div class="card card-signin flex-row my-5">
					<div class="card-img-left d-none d-md-flex"></div>
					<!-- Background image for card set in CSS!-->
					<div class="card-body">
						<!--div class="card-body"-->
						<h5 class="card-title text-center">Sign Up</h5>

						<!-- Page shown-->
						<form:form modelAttribute="infoVO" action="signup" method="POST"
							onSubmit="return Validate()" name="infos">
							<form class="form-signin">
								<!-- 이름넣기 -->
								<div class="form-label-group">
									<form:input path="userName" name="userName" type="text"
										class="form-control" placeholder="이름 입력" required=""
										autofocus=""></form:input>
									<div id="username_error" class="val_error"></div>
								</div>
								<!-- 이메일 넣기 -->
								<div class="form-label-group">
									<form:input path="email" name="email" type="email"
										class="form-control" placeholder="이메일 입력(ID)" required=""
										autofocus=""></form:input>
									<div id="email_error" class="val_error"></div>
								</div>
								<!--비밀번호 넣기-->
								<div class="form-label-group">
									<form:input path="password" name="password" type="password"
										class="form-control" placeholder="비밀번호" required=""
										autofocus=""></form:input>
									<div id="password_error" class="val_error"></div>
								</div>
								<!-- 비밀번호 중복 확인 -->
								<div class="form-label-group">
									<form:input path="" name="passwordConfirm" type="password"
										class="form-control" placeholder="비밀번호 재입력" required=""
										autofocus=""></form:input>
									<div id="passwordConfirm_error" class="val_error"></div>
								</div>
								<!-- 생일 -->
								<div class="form-label-group">
									<form:input path="birth" name="birth" type="date"
										class="form-control" placeholder="생년월일 입력" required=""
										autofocus=""></form:input>
									<div id="birth_error" class="val_error"></div>
								</div>
								<!-- 주소 -->
								<div class="form-label-group">
									<form:input path="address" name="address" type="text"
										class="form-control" placeholder="주소 입력" required=""
										autofocus=""></form:input>
									<div id="address_error" class="val_error"></div>
								</div>
								<!-- 전화번호 -->
								<div class="form-label-group">
									<form:input path="pNum" name="pNum" type="tel"
										pattern="[0-9]{11}" title="01012341234 형식으로 입력해주세요"
										class="form-control" placeholder="휴대폰 번호 : 숫자로만 입력해 주세요!"
										required="" autofocus=""></form:input>
									<div id="pNum_error" class="val_error"></div>
								</div>

								<!-- button -->
								<hr class="my-4">
								<div class="form-label-group">
									<p>
										<button
											class="btn btn-lg btn-primary btn-block text-uppercase"
											type="submit">Submit</button>
									</p>
								</div>

							</form>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>



</body>