<%@page contentType="text/html;charset=UTF-8"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!DOCTYPE html>
    <html>

    <head>

      <meta charset="utf-8">

      <title>ST2M-Main</title>

      <!-- BOOTSTRAP-->
      <link href="${pageContext.request.contextPath}/resources/bootstrap.min.css" rel="stylesheet" type="text/css">

      <!-- ST2MCSS-->
      <link href="${pageContext.request.contextPath}/resources/ST2Mfrontpage.css" rel="stylesheet" type="text/css">

      <title>내 문제함 - 첫 페이지</title>
      <!-- css 초기화 코드 -->
      <style>
        html,
        body,
        div,
        span,
        applet,
        object,
        iframe,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6,
        p,
        blockquote,
        pre,
        a,
        abbr,
        acronym,
        address,
        big,
        cite,
        code,
        del,
        dfn,
        em,
        img,
        ins,
        kbd,
        q,
        s,
        samp,
        small,
        strike,
        strong,
        sub,
        sup,
        tt,
        var,
        b,
        u,
        i,
        center,
        dl,
        dt,
        dd,
        ol,
        ul,
        li,
        fieldset,
        form,
        label,
        legend,
        table,
        caption,
        tbody,
        tfoot,
        thead,
        tr,
        th,
        td,
        article,
        aside,
        canvas,
        details,
        embed,
        figure,
        figcaption,
        footer,
        header,
        hgroup,
        menu,
        nav,
        output,
        ruby,
        section,
        summary,
        time,
        mark,
        audio,
        video {
          margin: 0;
          padding: 0;
          border: 0;
          font-size: 100%;
          font: inherit;
          vertical-align: baseline;
        }

        /* HTML5 display-role reset for older browsers */

        article,
        aside,
        details,
        figcaption,
        figure,
        footer,
        header,
        hgroup,
        menu,
        nav,
        section {
          display: block;
        }

        body {
          line-height: 1;
        }

        ol,
        ul {
          list-style: none;
        }

        blockquote,
        q {
          quotes: none;
        }

        blockquote:before,
        blockquote:after,
        q:before,
        q:after {
          content: '';
          content: none;
        }

        table {
          border-collapse: collapse;
          border-spacing: 0;
        }

      </style>

      <!--figure 스타일 시트  &  JS-->
      <style>
        @import url(https://fonts.googleapis.com/css?family=Raleway:400,500,800);
        figure.snip1132 {
          margin-top: 6%;
          font-family: 'Raleway', Arial, sans-serif;
          font-size: 30px;
          position: relative;
          float: left;
          overflow: hidden;
          width: 100%;
          background: #000000;
          color: #ffffff;
          text-align: center;
          box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
        }

        figure.snip1132 * {
          -webkit-box-sizing: border-box;
          box-sizing: border-box;
          -webkit-transition: all 0.45s ease-in-out;
          transition: all 0.45s ease-in-out;
        }

        figure.snip1132 img {
          max-width: 100%;
          position: relative;
          opacity: 1;
        }

        figure.snip1132 figcaption {
          position: absolute;
          top: 20px;
          left: 20px;
          right: 20px;
          bottom: 20px;
          border: 1px solid white;
          border-width: 0 1px;
        }

        figure.snip1132 .heading {
          overflow: hidden;
          -webkit-transform: translateY(-50%);
          transform: translateY(-50%);
        }

        figure.snip1132 .caption {
          overflow: hidden;
          -webkit-transform: translateY(50%);
          transform: translateY(50%);
          position: absolute;
          width: 100%;
          bottom: 0;
        }

        figure.snip1132 h3,
        figure.snip1132 p {
          display: table;
          margin: 0 auto;
          padding: 0 10px;
          position: relative;
          text-align: center;
          width: auto;
          text-transform: uppercase;
          font-weight: 400;
        }

        figure.snip1132 h3 span,
        figure.snip1132 p span {
          font-weight: 800;
        }

        figure.snip1132 h3:before,
        figure.snip1132 p:before,
        figure.snip1132 h3:after,
        figure.snip1132 p:after {
          position: absolute;
          display: block;
          width: 1000%;
          height: 1px;
          content: '';
          background: white;
        }

        figure.snip1132 h3:before,
        figure.snip1132 p:before {
          left: -1000%;
        }

        figure.snip1132 h3:after,
        figure.snip1132 p:after {
          right: -1000%;
        }

        figure.snip1132 h3:before,
        figure.snip1132 h3:after {
          top: 50%;
        }

        figure.snip1132 p {
          font-size: 0.8em;
          font-weight: 500;
        }

        figure.snip1132 p:before,
        figure.snip1132 p:after {
          bottom: 50%;
        }

        figure.snip1132 a {
          left: 0;
          right: 0;
          top: 0;
          bottom: 0;
          position: absolute;
          z-index: 1;
        }

        figure.snip1132:hover img,
        figure.snip1132.hover img {
          opacity: 0.35;
          -webkit-transform: scale(1.15);
          transform: scale(1.15);
        }

      </style>
      <script>
        $(".hover").mouseleave(
          function() {
            $(this).removeClass("hover");
          }
        );

      </script>

      <!-- css 스타일 시트 -->
      <style>
        .content_container {
          width: 100%;
          height: 90%;
          margin: 0 0 0 0;
          display: flex;
        }

        .content {
          width: 50%;
        }

        .content img {
          position: relative;
          top: 0;
          left: 0;
          width: 100%;
          height: 100%;
        }

        #makeq {
          float: left;
        }

        #viewq {
          float: right;
        }

      </style>
    </head>

    <body>
      <nav class="navbar navbar-custom navbar-expand-lg fixed-top">
        <div class="container">
          <a class="navbar-brand" href="Main.html">ST2M</a>
          <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">

              <li class="nav-item">name : ${userName}</li>

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


      <div class="content_container">
        <div class="content" id="makeq">
          <figure class="snip1132">
            <img src="https://t1.daumcdn.net/cfile/tistory/2169664E53D9CAD605" />
            <figcaption>
              <div class="heading">
                <h1>내
                  <span>문제만들기</span>
                </h1>
              </div>
              <div class="caption">
                <p>클릭하세요</p>
              </div>
            </figcaption>
          </figure>
        </div>
        <div class="content" id="viewq">
          <figure class="snip1132">
            <img src="http://jayeonmiin.com/web/product/medium/201608/3763_shop1_532600.jpg">
            <figcaption>
              <div class="heading">
                <h1>내
                  <span>문제함</span>
                </h1>
              </div>
              <div class="caption">
                <p>클릭하세요</p>
              </div>
            </figcaption>
          </figure>
        </div>
      </div>
    </body>
