var jsonTestList = [];

function assignTest(testList) {
	jsonTestList = testList;
}

function loadTestList() {

	var n = 0;
	while (jsonTestList[n] != null) {
		var test = jsonTestList[n].captestLink;
		// 이미지 태그 제작
		var mkimg = "";
		mkimg = mkimg + "<img />";
		console.log(test);
		setTimeout(appendChild(test, n), 200);
		n++;
	}
	console.log(n);
	for (var i = 0; i < n; i++) {
		var test = jsonTestList[i].captestLink;
		console.log(i);
		setTimeout(appendChild_hover(test, i), 400);
	}
}

function appendChild(test, n) {
	var img = document.createElement("input");
	img.type = "image";
	img.src = test;
	img.id = "capimg-" + n;
	img.onclick = function() {
		$(".checker").prop("checked", false);
		$("#radio-" + n).prop("checked", true);
		if ($("#radio-" + n).prop("checked") == true) {
			//라디오 버튼 통해 테두리 생성
			$(".img-plus").removeClass("border-checked");
			$(this).addClass("border-checked");
			//다운 경로생성
			$("#a_download").removeAttr("href");
			$("#a_download").attr("href",$('input:radio[name="test-radio"]:checked').val());
			//수정 값 넣어주기.
			var idx_no=$('input:radio[name="test-radio"]:checked').val();
			$("#testPaperIDNum").removeAttr("text");
			console.log(jsonTestList[idx_no].testPaperIDNum);
			$("#testPaperIDNum").attr("value", jsonTestList[idx_no].testPaperIDNum);
		}
	}
	img.classList.add("image-popup-no-margins");
	// img.classList.add("imgBig");
	img.classList.add("img-plus");
	var div = document.getElementById("img-" + n);
	div.append(img);
}

function appendChild_hover(test, n) {
	var img_hover = document.createElement("input");
	img_hover.type = "image";
	img_hover.src = test;
	img_hover.id = "capimg_hover-" + n;
	img_hover.classList.add("image-popup-no-margins");

	// 시작: 이미지 왼쪽 오른쪽 나눠서 확대된 이미지 보여주기(+ 버튼 제외)
	if (n <= 4) {
		if (n == 0 || n == 1) {
			img_hover.classList.add("imgBigL");
		} else if (2 <= n <= 4) {
			img_hover.classList.add("imgBigR");
		}
	} else if (n > 4) {
		if ((n % 6) == 2 || (n % 6) == 3 || (n % 6) == 4) {
			img_hover.classList.add("imgBigR");
		} else if ((n % 6) == 5 || (n % 6) == 0 || (n % 6) == 1) {
			img_hover.classList.add("imgBigL");
		}
	}
	//끝
	// img_hover.classList.add("img-plus");
	var div = document.getElementById("img-" + n);
	div.append(img_hover);
	//안보이는 라디오 버튼 생성( 시험지 넘겨주기 위해~)
	var radio = document.createElement("input");
	radio.type = "radio";
	radio.id = "radio-" + n;
	radio.name = "test-radio";
	radio.classList.add("checker");
	radio.value = n;
	div.append(radio);
	$(".checker").hide();//안보이는 jquery
}