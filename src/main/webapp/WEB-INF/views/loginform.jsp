<!-- 로그인 폼 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
    <title> 로그인 시험중</title>
    <!--  Jquery -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

    <meta charset="utf-8">
    <meta name="description" content="Test your JavaScript, CSS, HTML or CoffeeScript online with JSFiddle code editor.">
    <meta name="keywords" content="online javascript editor, testing javascript online, online ide, online code editor, html, css, coffeescript, scss online editor">
    <meta name="author" content="JSFiddle">
    <meta name="copyright" content="share alike">

    <meta name="robots" content="index, follow">
    <meta name="googlebot" content="index, follow">

    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="theme-color" content="#0084ff">

    <style>
        :root {
            --input-padding-x: 1.5rem;
            --input-padding-y: .75rem;
        }

        body {
            background: #9CECFB;
            /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #0052D4, #65C7F7, #9CECFB);
            /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #0052D4, #65C7F7, #9CECFB);
            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        }

        .card-signin {
            border: 0;
            border-radius: 1rem;
            box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        .card-signin .card-title {
            margin-bottom: 2rem;
            font-weight: 300;
            font-size: 1.5rem;
        }

        .card-signin .card-img-left {
            width: 45%;
            /* Link to your background image using in the property below! */
            background: scroll center url('https://source.unsplash.com/WEQbe2jBg40/414x512');
            background-size: cover;
        }

        .card-signin .card-body {
            padding: 2rem;
        }

        .form-signin {
            width: 100%;
        }

        .form-signin .btn {
            font-size: 80%;
            border-radius: 5rem;
            letter-spacing: .1rem;
            font-weight: bold;
            padding: 1rem;
            transition: all 0.2s;
        }

        .form-label-group {
            position: relative;
            margin-bottom: 1rem;
        }

        .form-label-group input {
            border-radius: 2rem;
        }

        .form-label-group>input,
        .form-label-group>label {
            padding: var(--input-padding-y) var(--input-padding-x);
        }

        .form-label-group>label {
            position: absolute;
            top: 0;
            left: 0;
            display: block;
            width: 100%;
            margin-bottom: 0;
            /* Override default `<label>` margin */
            line-height: 1.5;
            color: #495057;
            border: 1px solid transparent;
            border-radius: .25rem;
            transition: all .1s ease-in-out;
        }
        
        .btn-signup {
          background: #d9d9d9
        }
        
        
    </style>
    <!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->

    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-9 mx-auto">
                    <div class="card card-signin flex-row my-5">
                        <div class="card-img-left d-none d-md-flex">
                            <!-- Background image for card set in CSS!-->
                        </div>
                        <div class="card-body">
                            <!--div class="card-body"-->
                            <h5 class="card-title text-center">Login</h5>

                            <!-- Page shown-->
                            <form:form modelAttribute="infoVO" action="login" method="POST">
                                <form class="form-signin">

                                    <div class="form-label-group">
                                        <form:input path="email" type="email" id="email" class="form-control" placeholder="Type your email" required="" autofocus="" ></form:input>
                                    </div>
                                    <div class="form-label-group">
                                        <form:input path="password" type="password" id="password" class="form-control" placeholder="Type your password" required="" autofocus="" ></form:input>
                                    </div>

                                    <!-- button -->
                                    <hr class="my-4">
                                    <div class="form-label-group">
                                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Login</button>
                                    </div>
                                </form>
                            </form:form>

                            <form:form modelAttribute="infoVO" action="insertinfo" method="GET">
                                <form class="form-signin">
                                    <div class="form-label-group">
                                        <button class="btn btn-lg btn-signup btn-block text-uppercase" type="submit">Sign Up </button>
                                    </div>
                                </form>
                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    </html>