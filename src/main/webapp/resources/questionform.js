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
		setTimeout(appendChild(question,n),2000);
		n++;
	}
}

function appendChild(question,n) {
	var img = document.createElement("img");
	img.src=question;
	img.id="capimg-"+n;
	img.classList.add("image-popup-no-margins");
	var div = document.getElementById("img-"+n);
	div.append(img);
}
