var jsonQuestionList = [];

function assignQuestion(questionList) {
   jsonQuestionList = questionList;
}

function loadQuestionList() {

   var n = 0;
   // 이 부분을 작성해주세요.
   // jsonQuestionList는 서버에서 전달된 문제 배열입니다.
   // 이 배열에 있는 문제를 웹페이지에 나열해주세요.
   // +추가적으로 사용자가 문제를 선택하면 addQuestionToEditor(num)을 호출해주세요.
   // num은 jsonQuestionList에서의 인덱스입니다.
   while (jsonQuestionList[n] != null) {
      var question = jsonQuestionList[n].capimageLink;
      // 이미지 태그 제작
      var mkimg = "";
      mkimg = mkimg + "<img />";
      console.log(question);
      setTimeout(appendChild(question, n), 2000);
      n++;
   }
   console.log(n);
   for (var i = 0; i < n; i++) {
      var question = jsonQuestionList[i].capimageLink;
      console.log(i);
      setTimeout(appendChild_hover(question, i), 5000);
   }
}

function appendChild(question, n) {
   var img = document.createElement("input");
   img.type = "image";
   img.src = question;
   img.id = "capimg-" + n;
   img.classList.add("image-popup-no-margins");
   // img.classList.add("imgBig");
   img.classList.add("img-plus");
   var div = document.getElementById("img-" + n);
   div.append(img);
}

function appendChild_hover(question, n) {
   var img_hover = document.createElement("input");
   img_hover.type = "image";
   img_hover.src = question;
   img_hover.id = "capimg_hover-" + n;
   img_hover.classList.add("image-popup-no-margins");
   
   // 시작: 이미지 왼쪽 오른쪽 나눠서 확대된 이미지 보여주기(+ 버튼 제외)
   if(n<=4){
   if (n == 0 || n == 1) {
      img_hover.classList.add("imgBigL");
   } else if (2 <= n <= 4) {
      img_hover.classList.add("imgBigR");
   } 
   }
   else if(n>4){
       if ((n%6) == 2 || (n%6) == 3 || (n%6) == 4) {
            img_hover.classList.add("imgBigR");
         }
          else if((n%6)==5 || (n%6)==0 || (n%6)==1) {
               img_hover.classList.add("imgBigL");
      }
   }
   //끝
   // img_hover.classList.add("img-plus");
   var div = document.getElementById("img-" + n);
   div.append(img_hover);
}