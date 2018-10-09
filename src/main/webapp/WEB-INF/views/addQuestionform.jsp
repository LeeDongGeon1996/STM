<!-- 문제 추가 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>

<head>
<title>문제 추가하기</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<div>
		<button class=" btn-home">STM</button>
		<button class=" btn-logout">logout</button>
	</div>

	<div class="container-fluid">
		<div class="container-fluid outterB">
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8"
					style="padding: 0px">
					<div class="upperB" style="height: 250px">지문 입력하는 곳</div>
					<div>보기 입력하는 곳</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 rightB"
					style="height: 500px">문제 미리보기</div>
			</div>
		</div>
	</div>
</body>

<style>
img {
	max-width: 100%;
	max-height: 100%;
}

.outterB {
	border-style: solid;
	border-width: 3pt;
	border-color: rgb(23, 186, 239);
	margin: 10px;
}

.upperB {
	border: none;
	border-bottom: solid;
	border-width: 1pt;
	border-color: rgb(23, 186, 239);
}

.rightB {
	border: none;
	border-left: solid;
	border-width: 1pt;
	border-color: rgb(23, 186, 239);
}

.btn-home {
	color: rgb(238, 131, 111);
	background-color: transparent;
	font-size: 14pt;
	border: none;
	cursor: pointer;
}

.btn-logout {
	color: rgb(7, 79, 102);
	background-color: transparent;
	font-size: 14pt;
	border: none;
	cursor: pointer;
}
</style>

</html>