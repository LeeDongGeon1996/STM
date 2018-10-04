<!-- 메인화면 홈 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>

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
  width: 120px;
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
  width: 120px;
  font-size: 16pt;
  padding: 5px;
}

.btn-home {
  color: white;
  background-color: transparent;
  border: none;
}

</style>

  <head>
    <title>메인 홈 화면</title>
  </head>

  <body>
    <button class=" btn-home">STM</button>
    <div>
      <textarea class="textarea-smallN">시험지 제작 툴 </textarea>
      <textarea class="textarea-bigN">STM</textarea>
    </div>
    <div>
      <textarea class="textarea-exp">Make your own optimized test paper using STM</textarea>
    </div>
    <!--button-->
    <button class=" btn-paper">내 문제</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button class=" btn-question">내 시험지</button>

  </body>
</html>
