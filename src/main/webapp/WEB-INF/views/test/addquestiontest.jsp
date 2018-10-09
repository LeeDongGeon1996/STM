<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>AddQuestion</title>
<script type="text/javascript" src="/resources/script/html2canvas.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<script src="https://cdn.ckeditor.com/4.8.0/full-all/ckeditor.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/addQuestion_editor.js"></script>
<script>
	function onLoad() {
		createEditor();

	}
</script>
<script language="javascript">
	$(function(){
		$('#btn_submit').click(function(){
			html2canvas($('.printDiv'),{
				onrendered: function(canvas){
					if(typeof FlashCanvas != "undefined"){
						FlashCanvas.initElement(canvas);
					}
					var image = canvas.toDataURL("image/png");
					$("#imgData").val(image);
					$("#")
				}
			})
		})
	})
</script>
<body onload="onLoad();">

	<style>
#question_form {
	float: left;
}

#preview_editor {
	float: right;
}
</style>
</head>

<body>

	<div class="container">
		<div id="question_form" class="row">
			<div class="col-lg-10 col-xl-9 mx-auto">
				<div class="flex-row my-5">
					<div class="card-img-left d-none d-md-flex"></div>
					<!-- Background image for card set in CSS!-->
					<div class="body">
						<!--div class="card-body"-->
						<h5 class="card-title text-center">문제등록 테스트 페이지</h5>

						<!-- Page shown-->
						<form:form modelAttribute="questionVO" action="registerQuestion"
							method="POST" onSubmit="return Validate()" name="infos"
							enctype="multipart/form-data">
							<form class="form-signin">

								<!--  이미지 넣기  -->
								이미지 파일  <input type="file" name="file" placeholder="파일 선택"
									onchange="onFileSelected(this.files)"><br>

								<!-- 지문넣기 -->
								<div class="form-label-group">
									<form:input path="passage" name="passage" type="text"
										id="passageInput" class="form-control" placeholder="지문 입력"
										required="" autofocus="" onkeyup="onPassageChange();"></form:input>
									<div id="username_error" class="val_error"></div>
								</div>

								<!--보기 넣기-->
								<div class="form-label-group">
									<form:input path="mulChoice" name="mulChoice" type="text"
										class="form-control" placeholder="보기" required="" autofocus=""
										onkeyup="onChoiceChange();"></form:input>
									<div id="password_error" class="val_error"></div>
								</div>

								<!-- button -->
								<hr class="my-4">
								<div class="form-label-group">
									<p>
										<button id="btn_submit"
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

		<div id="preview_editor" class="flex-row my-5">
			<h2>
				<label for="editor1">문제 프리뷰</label>
			</h2>
			<div class="printDiv" id="editor1" contenteditable="true">
				
			</div>
		</div>
	</div>
</body>
</html>