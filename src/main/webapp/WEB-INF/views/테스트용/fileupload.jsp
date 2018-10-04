<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<title>이미지 업로드 테스트</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<form action="fileUpload"  id="fileUpload" name="fileUplaod" method="POST" enctype="multipart/form-data">
		이름 : <input type="text" name="name" id="cmd" value="namevla"><br>
		파일 : <input type="file"  name="file" placeholder="파일 선택"><br>
		<input type="submit" name="업로드" value="제출"><br>
	</form>
</body>