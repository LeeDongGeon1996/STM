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
  <button class=" btn-logout">logout</button>
  <div class="div-text">
    <text class="text-smallN">시험지 제작 툴 </text>
    <text class="text-bigN">STM</text>
  </div>
  <div class="div-exp">
    <text class="text-exp">Make your own optimized test paper using
		STM</text>
  </div>

  <!--button-->
  <div class="container" style="margin-left: 35%">
    <div class="row">
      <div class="div-btn">
        <form:form action="questionform" method="GET">
          <button class=" btn-question" type="submit">내 문제</button>
        </form:form>
      </div>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <div class="div-btn">
        <form:form action="testform" method="GET">
          <button class=" btn-paper" type="submit">내 시험지</button>
        </form:form>
      </div>
    </div>
  </div>
</body>

<style>
body {
  background-color: rgb(23, 186, 239);
}

.div-text {
  margin-bottom: 40px;
  margin-top: 5%;
}

.text-smallN {
  margin-left: 25%;
  color: rgb(7, 79, 102);
  font-size: 40pt;
}

.text-bigN {
  color: rgb(250, 217, 86);
  font-size: 88pt;
}

.text-exp {
  color: white;
  font-size: 20pt;
}

.div-exp {
  margin-left: 25%;
  margin-bottom: 40px;
}

.btn-question {
  color: white;
  background-color: rgb(250, 217, 86);
  border-radius: 8px;
  border: none;
  color: #FFFFFF;
  text-align: center;
  width: 140px;
  font-size: 16pt;
  padding: 5px;
}

.btn-paper {
  color: white;
  background-color: rgb(7, 79, 102);
  border-radius: 8px;
  border: none;
  color: #FFFFFF;
  text-align: center;
  width: 140px;
  font-size: 16pt;
  padding: 5px;
}

.div-btn {
  display: inline-block;
  margin: auto;
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