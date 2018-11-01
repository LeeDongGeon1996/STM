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
   for(var i=0;i<n;i++){
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
   img.classList.add("img-plus");
   var div = document.getElementById("img-" + n);
   div.append(img);
}

function appendChild_hover(question,n){
   var img_hover = document.createElement("input");
   img_hover.type = "image";
   img_hover.src = question;
   img_hover.id = "capimg_hover-" + n;
   img_hover.classList.add("image-popup-no-margins");
   img_hover.classList.add("imgBig");
   var div = document.getElementById("img-" + n);
   div.append(img_hover);
}