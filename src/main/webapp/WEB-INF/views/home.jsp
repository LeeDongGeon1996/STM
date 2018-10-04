<!-- 메인화면 홈 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>

<head>
<title>메인 홈 화면</title>
</head>

<body>
   <button class=" btn-home">STM</button>
   <div>
      <text class="text-smallN">시험지 제작 툴 </text>
      <text class="text-bigN">STM</text>
   </div>
   <div>
      <text class="text-exp">Make your own optimized test paper using STM</text>
   </div>
   
   <!--button-->
   <form:form action="questionform" method="GET">
      <button class=" btn-question" type="submit">내 문제함</button>
   </form:form>
   
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

   <form:form action="testform" method="GET">
      <button class=" btn-paper" type="submit">내 시험지함</button>
   </form:form>

</body>

<style>
body {
  background-color: rgb(23, 186, 239);
}

.text-smallN {
  color: rgb(7, 79, 102);
  font-size: 40pt;
}

.text-bigN {
  color: rgb(250, 217, 86);
  font-size: 88pt;
}

.text-exp {
  color: white;
  font-size: 16pt;
}

.btn-paper {
  color: white;
  background-color: rgb(250, 217, 86);
  display: inline-block;
  border-radius: 8px;
  border: none;
  color: #FFFFFF;
  text-align: center;
  width: 140px;
  font-size: 16pt;
  padding: 5px;
}

.btn-question {
  cursor: pointer;
  color: white;
  background-color: rgb(7, 79, 102);
  display: inline-block;
  border-radius: 8px;
  border: none;
  color: #FFFFFF;
  text-align: center;
  width: 140px;
  font-size: 16pt;
  padding: 5px;
}

.btn-home {
  color: white;
  background-color: transparent;
  border: none;
}
</style>

</html>