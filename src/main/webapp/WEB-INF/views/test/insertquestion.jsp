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
   assignQuestion(${questionList});
</script>
<script>
	loadQuestionList();
</script>
</head>
<body onload="onLoad();">

   <div id="fakediv">test</div>



      <h2>
         <label for="editor1">Document Editor</label>
      </h2>
      <textarea id="editor1" disable>

   </textarea>
   </div>
</body>