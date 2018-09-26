<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="description" content="ST2M">
        <meta name="author" content="최준만">

        <title>ST2M-Main</title>

        <!-- BOOTSTRAP-->
        <link href="${pageContext.request.contextPath}/resources/bootstrap.min.css" rel="stylesheet" type="text/css">

        <!-- ST2MCSS-->
        <link href="${pageContext.request.contextPath}/resources/ST2Mfrontpage.css" rel="stylesheet" type="text/css">

    </head>

    <body>
        <!--Navigator-->
        <nav class="navbar navbar-custom navbar-expand-lg fixed-top">
            <div class="container">
                <a class="navbar-brand" href="Main.html">ST2M</a>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">name : ${username}</li>
                        <li class="nav-item active">
                            <a class="nav-link" href="#">홈
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">시험지 제작</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">학생 관리</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <header class="ST2M-header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="display-2 text-center text-white mt-5">학생 시험지 제작 및 관리</h1>
                    </div>
                </div>
            </div>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-sm-3 my-4">
                    <div class="card">
                        <img class="card-img-top" src="http://www.educationviews.org/wp-content/uploads/2017/06/Standardized-Test-300x200.png" alt="test">
                        <div class="card-body">
                            <h4 class="card-title text-center">테스트 생성</h4>
                        </div>
                        <div class="card-footer text-center">
                            <a href="#" class="btn btn-primary">만들기</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 my-4">
                    <div class="card">
                        <img class="card-img-top" src="http://smca.or.kr/wp/wp-content/uploads/2017/02/2017-%EC%A4%91%ED%95%99%EA%B5%90-%EC%A1%B8%EC%97%85%EC%8B%9D-1%EB%B6%80-3-300x200.jpg" alt="test">
                        <div class="card-body">
                            <h4 class="card-title text-center">학생 관리</h4>
                        </div>
                        <div class="card-footer text-center">
                            <a href="#" class="btn btn-primary">관리하기</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 my-4">
                    <div class="card">
                        <img class="card-img-top" src="http://24eastmain.com/wp-content/uploads/2017/08/test.jpg" alt="myquestion">
                        <div class="card-body">
                            <h4 class="card-title text-center">내 문제함</h4>
                        </div>
                        <div class="card-footer text-center">
                            <a href="#" class="btn btn-primary">이동</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 my-4">
                    <div class="card">
                        <img class="card-img-top" src="http://semlab.com/semlab.com/2017/wp-content/uploads/2017/08/4-FotoliaComp_67313340_cu1CsgH8VXwG3X8PeLYmg9R7ffg7WRqz-849x566-300x200.jpg" alt="mytest">
                        <div class="card-body">
                            <h4 class="card-title text-center">내 기출문제</h4>
                        </div>
                        <div class="card-footer text-center">
                            <a href="#" class="btn btn-primary">이동</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>