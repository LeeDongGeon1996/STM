<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<title>questionVO 등록 테스트</title>
<script src="https://cdn.ckeditor.com/4.8.0/full-all/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/editor.js"></script>
<script>
   function onLoad() {
	   makeTestPaper();
   }
</script>
</head>
<body onload="onLoad();">

   <div id="fakediv">test</div>


   <div class="container">
      <div class="row">
         <div class="col-lg-10 col-xl-9 mx-auto">
            <div class="card card-signin flex-row my-5">
               <div class="card-img-left d-none d-md-flex"></div>
               <!-- Background image for card set in CSS!-->
               <div class="card-body">
                  <!--div class="card-body"-->
                  <h5 class="card-title text-center">문제등록 테스트 페이지</h5>

                  <!-- Page shown-->
                  <form:form modelAttribute="questionVO" action="registerquestion"
                     method="POST" onSubmit="return Validate()" name="infos"
                     enctype="multipart/form-data">
                     <form class="form-signin">
                        <!-- 지문넣기 -->
                        <div class="form-label-group">
                           <form:input path="passage" name="passage" type="text"
                              id="passageInput" class="form-control" placeholder="지문 입력"
                              required="" autofocus="" onkeyup="onPassageChange();"></form:input>
                           <div id="username_error" class="val_error"></div>
                        </div>

                        <!--비밀번호 넣기-->
                        <div class="form-label-group">
                           <form:input path="mulChoice" name="mulChoice" type="text"
                              class="form-control" placeholder="보기" required="" autofocus=""
                              onkeyup="onChoiceChange();"></form:input>
                           <div id="password_error" class="val_error"></div>
                        </div>

                        <!-- 이미지 테스트 -->
                        <div class="form-label-group">
                           이름 : <input type="text" name="name" id="cmd" value="namevla"><br>
                           파일 : <input type="file" name="file" placeholder="파일 선택"
                              onchange="onFileSelected(this.files)"><br>
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


      <h2>
         <label for="editor1">Document Editor</label>
      </h2>
      <textarea id="editor1" disable>
      ??????aasdfasdf

      !!!!!
   </textarea>

   </div>



</body>