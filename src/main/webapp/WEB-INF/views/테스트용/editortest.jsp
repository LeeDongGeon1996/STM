<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://cdn.ckeditor.com/4.8.0/full-all/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/editor.js"></script>
<script>

function onLoad(){
	createEditor();
}
</script>
</head>
<body onload="onLoad();">

	<div class="container">
		<h2>
			<label for="editor1">Document Editor</label>
		</h2>
		<textarea id="editor1">
		??????aasdfasdf


		
		!!!!!
	</textarea>
	</div>

</body>
<script>
loadQuestionList(${questionList});
</script>
</html>