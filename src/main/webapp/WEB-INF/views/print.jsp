<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script>

function printTestPaper(){

	fetch("${testpaperVO.htmlLink}").then(response=>response.text()).then(function(text){
		var popupWindow = window.open("", "_blank");
		
		popupWindow.document.write(text);
		popupWindow.document.close();
		popupWindow.onload = function(){popupWindow.print();popupWindow.close();window.location.href='/st2m/testform';};
	});
}
printTestPaper();
</script>
</head>
<body>
잠시만 기다려주세요.

</body>
</html>