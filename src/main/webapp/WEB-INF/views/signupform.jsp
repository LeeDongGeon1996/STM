<!-- 회원가입 폼 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>회원가입 페이지</title>
<!--  Jquery -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<meta charset="utf-8">
<meta name="description"
	content="Test your JavaScript, CSS, HTML or CoffeeScript online with JSFiddle code editor.">
<meta name="keywords"
	content="online javascript editor, testing javascript online, online ide, online code editor, html, css, coffeescript, scss online editor">
<meta name="author" content="JSFiddle">
<meta name="copyright" content="share alike">

<meta name="robots" content="index, follow">
<meta name="googlebot" content="index, follow">

<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="theme-color" content="#0084ff">

<style>
:root { -
	-input-padding-x: 1.5rem; -
	-input-padding-y: .75rem;
}

body {
	background: #9CECFB;
	/* fallback for old browsers */
	background: -webkit-linear-gradient(to right, #0052D4, #65C7F7, #9CECFB);
	/* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to right, #0052D4, #65C7F7, #9CECFB);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

.card-signin {
	border: 0;
	border-radius: 1rem;
	box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
	overflow: hidden;
}

.card-signin .card-title {
	margin-bottom: 2rem;
	font-weight: 300;
	font-size: 1.5rem;
}

.card-signin .card-img-left {
	width: 45%;
	/* Link to your background image using in the property below! */
	background: scroll center
		url('/webapp/WEB-INF/views/image/STMimage.PNG');
	background-size: cover;
}

.card-signin .card-body {
	padding: 2rem;
}

.form-signin {
	width: 100%;
}

.form-signin .btn {
	font-size: 80%;
	border-radius: 5rem;
	letter-spacing: .1rem;
	font-weight: bold;
	padding: 1rem;
	transition: all 0.2s;
}

.form-label-group {
	position: relative;
	margin-bottom: 1rem;
}

.form-label-group input {
	border-radius: 2rem;
}

.form-label-group>input, .form-label-group>label {
	padding: var(- -input-padding-y) var(- -input-padding-x);
}

.form-label-group>label {
	position: absolute;
	top: 0;
	left: 0;
	display: block;
	width: 100%;
	margin-bottom: 0;
	/* Override default `<label>` margin */
	line-height: 1.5;
	color: #495057;
	border: 1px solid transparent;
	border-radius: .25rem;
	transition: all .1s ease-in-out;
}

.btn-signup {
	background: #d9d9d9
}

.val_error {
	color: #FF1F1F
}
</style>
<body>
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
						<form:form modelAttribute="infoVO" action="getinfo" method="POST"
							onSubmit="return Validate()" name="infos">
							<form class="form-signin">
								<!-- 이름넣기 -->
								<div class="form-label-group">
									<form:input path="username" name="username" type="text"
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
</html>


<!-- adding javascript for error message -->
<script type="text/javascript">
	//변수 선언
	var username = document.forms["infos"]["username"];
	var email = document.forms["infos"]["email"];
	var password = document.forms["infos"]["password"];
	var passwordConfirm = document.forms["infos"]["passwordConfirm"];
	var birth = document.forms["infos"]["birth"];
	var address = document.forms["infos"]["address"];
	var pNum = document.forms["infos"]["pNum"];
	var pString = pNum.value.length;
	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

	//에러 변수 선언
	var username_error = document.getElementById("username_error");
	var email_error = document.getElementById("email_error");
	var password_error = document.getElementById("password_error");
	var passwordConfirm_error = document
			.getElementById("passwordConfirm_error");
	var birth_error = document.getElementById("birth_error");
	var address_error = document.getElementById("address_error");
	var pNum_error = document.getElementById("pNum_error");

	//이벤트 리스너 등록
	username.addEventListener("blur", usernameVerify, true);
	email.addEventListener("blur", emailVerify, true);
	password.addEventListener("blur", passwordVerify, true);
	passwordConfirm.addEventListener("blur", passwordConfirmVerify, true);
	birth.addEventListener("blur", birthVerify, true);
	address.addEventListener("blur", addressVerify, true);
	pNum.addEventListener("blur", pNumVerify, true);

	//Validate() 함수 등록
	function Validate() {
		if (username.value == "") {
			username.style.border = "2px solid red";
			username_error.textContent = "Name is required";
			username.focus();
			return false;
		}
		if (email.value == "") {
			email.style.border = "2px solid red";
			email_error.textContent = "Email is required";
			email.focus();
			return false;
		}
		if (regExp.test(email.value) == false) {
			email.style.border = "2px solid red";
			email_error.textContent = "Proper email is required";
			email.focus();
			return false;
		}
		/*if () {
			email.style.border = "2px solid red";
			email_error.textContent = "Duplicated email. Please type a different email.";
			email.focus();
			return false;
		}*/
		if (password.value == "") {
			password.style.border = "2px solid red";
			password_error.textContent = "Password is required";
			password.focus();
			return false;
		}
		if (passwordConfirm.value == "") {
			passwordConfirm.style.border = "2px solid red";
			passwordConfirm_error.textContent = "Password confirmation is required";
			passwordConfirm.focus();
			return false;
		}
		if (birth.value == "") {
			birth.style.border = "2px solid red";
			birth_error.textContent = "Birthday is required";
			birth.focus();
			return false;
		}
		if (address.value == "") {
			address.style.border = "2px solid red";
			address_error.textContent = "Address is required";
			address.focus();
			return false;
		}
		if (pNum.value == "") {
			pNum.style.border = "2px solid red";
			pNum_error.textContent = "Phone number is required";
			pNum.focus();
			return false;
		}
		/*if (isNaN(pNum.value) == true) {
			pNum.style.border = "2px solid red";
			pNum_error.textContent = "Proper phone number is required";
			pNum.focus();
			return false;
		}
		if (pNum.value.length != 11) {
			pNum_error.textContent = "Type 11 numbers";
			pNum.focus();
			return false;
		}*/

		//비밀번호 중복확인
		if (password.value != passwordConfirm.value) {
			password.style.border = "2px solid red";
			passwordConfirm.style.border = "2px solid red";
			passwordConfirm_error.innerHTML = "Password does not match";
			return false;
		}
	}

	//event handler functions
	function usernameVerify() {
		if (username.value != "") {
			username.style = "#7ba6ed";
			username_error.innerHTML = "<span style='color: green'>Complete</span>";
			return true;
		}
	}

	function emailVerify() {
		if (email.value != "") {
			if (regExp.test(email.value) == true) {
				email.style = "#7ba6ed";
				email_error.innerHTML = "<span style='color: green'>Complete</span>";
				return true;
			}
		}
	}

	function passwordVerify() {
		if (password.value != "") {
			if (password.value != passwordConfirm.value) {
				password.style = "#7ba6ed";
				password_error.innerHTML = "<span style='color: green'>Complete</span>";
				return true;
			}
		}
	}

	function passwordConfirmVerify() {
		if (passwordConfirm.value != "") {
			passwordConfirm.style = "#7ba6ed";
			password.style = "#7ba6ed";
			passwordConfirm_error.innerHTML = "<span style='color: green'>Complete</span>";
			return true;
		}
	}

	function birthVerify() {
		if (birth.value != "") {
			birth.style = "#7ba6ed";
			birth_error.innerHTML = "<span style='color: green'>Complete</span>";
			return true;
		}
	}

	function addressVerify() {
		if (address.value != "") {
			address.style = "#7ba6ed";
			address_error.innerHTML = "<span style='color: green'>Complete</span>";
			return true;
		}
	}

	function pNumVerify() {

		if (pNum.value != "") {
			if (!isNaN(pNum.value) == true) {
				if (pNum.value.length == 11) {
					pNum.style = "#7ba6ed";
					pNum_error.innerHTML = "<span style='color: green'>Complete</span>";
					return true;
				}
			}
		}
	}
</script>

