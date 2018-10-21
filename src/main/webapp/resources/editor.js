var editor;
var QuestionList;
var questionCount = 0;
var passageDiv;
var choiceDiv;
var imgDiv;
var passageInput;
var choiceInput;
var contentDiv;
var jsonQuestionList=[];

function assignQuestion(questionList){
	jsonQuestionList=questionList;
}

function makeTestPaper(){

	createEditor();
	setTimeout(function(){
		createTestPaper();
	},500);
	
}

function createEditor() {

	editor = CKEDITOR.replace('editor1', {
		// Define the toolbar:
		// http://docs.ckeditor.com/ckeditor4/docs/#!/guide/dev_toolbar
		// The full preset from CDN which we used as a base provides more
		// features
		// than we need.
		// Also by default it comes with a 3-line toolbar. Here we put all
		// buttons
		// in a single row.
		toolbar : [
				{
					name : 'document',
					items : [ 'Print' ]
				},
				{
					name : 'clipboard',
					items : [ 'Undo', 'Redo' ]
				},
				{
					name : 'styles',
					items : [ 'Format', 'Font', 'FontSize' ]
				},
				{
					name : 'basicstyles',
					items : [ 'Bold', 'Italic', 'Underline', 'Strike',
							'RemoveFormat', 'CopyFormatting' ]
				},
				{
					name : 'colors',
					items : [ 'TextColor', 'BGColor' ]
				},
				{
					name : 'align',
					items : [ 'JustifyLeft', 'JustifyCenter', 'JustifyRight',
							'JustifyBlock' ]
				},
				{
					name : 'links',
					items : [ 'Link', 'Unlink' ]
				},
				{
					name : 'paragraph',
					items : [ 'NumberedList', 'BulletedList', '-', 'Outdent',
							'Indent', '-', 'Blockquote' ]
				}, {
					name : 'insert',
					items : [ 'Image', 'Table' ]
				}, {
					name : 'tools',
					items : [ 'Maximize' ]
				}, {
					name : 'editing',
					items : [ 'Scayt' ]
				} ],
		// Since we define all configuration options here, let's instruct
		// CKEditor
		// to not load config.js which it does by default.
		// One HTTP request less will result in a faster startup time.
		// For more information check
		// http://docs.ckeditor.com/ckeditor4/docs/#!/api/CKEDITOR.config-cfg-customConfig
		customConfig : '',
		// Sometimes applications that convert HTML to PDF prefer setting image
		// width through attributes instead of CSS styles.
		// For more information check:
		// - About Advanced Content Filter:
		// http://docs.ckeditor.com/ckeditor4/docs/#!/guide/dev_advanced_content_filter
		// - About Disallowed Content:
		// http://docs.ckeditor.com/ckeditor4/docs/#!/guide/dev_disallowed_content
		// - About Allowed Content:
		// http://docs.ckeditor.com/ckeditor4/docs/#!/guide/dev_allowed_content_rules
		disallowedContent : 'img{width,height,float}',
		extraAllowedContent : 'img[width,height,align]',
		// Enabling extra plugins, available in the full-all preset:
		// http://ckeditor.com/presets-all
		extraPlugins : 'tableresize,uploadimage,uploadfile',
		/** ********************* File management support ********************** */
		// In order to turn on support for file uploads, CKEditor has to be
		// configured to use some server side
		// solution with file upload/management capabilities, like for example
		// CKFinder.
		// For more information see
		// http://docs.ckeditor.com/ckeditor4/docs/#!/guide/dev_ckfinder_integration
		// Uncomment and correct these lines after you setup your local CKFinder
		// instance.
		// filebrowserBrowseUrl: 'http://example.com/ckfinder/ckfinder.html',
		// filebrowserUploadUrl:
		// 'http://example.com/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files',
		/** ********************* File management support ********************** */
		
		// An array of stylesheets to style the WYSIWYG area.
		// Note: it is recommended to keep your own styles in a separate file in
		// order to make future updates painless.
		contentsCss : [ 'https://cdn.ckeditor.com/4.8.0/full-all/contents.css',
				 'resources/innerEditor.css' ],
		// This is optional, but will let us define multiple different styles
		// for
		// multiple editors using the same CSS file.
		bodyClass : 'document-editor',
		// Reduce the list of block elements listed in the Format dropdown to
		// the
		// most commonly used.
		format_tags : 'p;h1;h2;h3;pre',
		// Simplify the Image and Link dialog windows. The "Advanced" tab is not
		// needed in most cases.
		removeDialogTabs : 'image:advanced;link:advanced',
		// Define the list of styles which should be available in the Styles
		// dropdown list.
		// If the "class" attribute is used to style an element, make sure to
		// define
		// the style for the class in "mystyles.css"
		// (and on your website so that it rendered in the same way).
		// Note: by default CKEditor looks for styles.js file. Defining
		// stylesSet
		// inline (as below) stops CKEditor from loading
		// that file, which means one HTTP request less (and a faster startup).
		// For more information see
		// http://docs.ckeditor.com/ckeditor4/docs/#!/guide/dev_styles
		stylesSet : [
		/* Inline Styles */
		{
			name : 'Marker',
			element : 'span',
			attributes : {
				'class' : 'marker'
			}
		}, {
			name : 'Cited Work',
			element : 'cite'
		}, {
			name : 'Inline Quotation',
			element : 'q'
		},
		/* Object Styles */
		{
			name : 'Special Container',
			element : 'div',
			styles : {
				padding : '5px 10px',
				background : '#eee',
				border : '1px solid #ccc'
			}
		}, {
			name : 'Compact table',
			element : 'table',
			attributes : {
				cellpadding : '5',
				cellspacing : '0',
				border : '1',
				bordercolor : '#ccc'
			},
			styles : {
				'border-collapse' : 'collapse'
			}
		}, {
			name : 'Borderless Table',
			element : 'table',
			styles : {
				'border-style' : 'hidden',
				'background-color' : '#E6E6FA'
			}
		}, {
			name : 'Square Bulleted List',
			element : 'ul',
			styles : {
				'list-style-type' : 'square'
			}
		} ],
		
		
		resize_enabled : false,
		// Make the editing area bigger than default.
		height : '297mm',
		width : '210mm'
	});

}

function createTestPaper(){
	fetch("resources/dd.html")
	.then( response => response.text() )
	.then( text => editor.document.getBody().setHtml(text) );
	
	questionDiv = editor.document.getById('content_div');
}

function createDiv() {

	// 고칠필요가 있는구문이지만 아직 쓸일 이함수가 아직쓸일이 없어 서 안고치
	if(questionDiv == null){
		questionDiv = editor.document.getById('question_div');
	}
	
	if (passageDiv == null) {
		passageDiv = CKEDITOR.dom.element
				.createFromHtml('<div id="passage_div"></div><br>');
		// CKEDITOR.instances.editor1.insertElement(passageDiv);
		passageDiv.appendTo(questionDiv);
	}
	if (choiceDiv == null) {
		choiceDiv = CKEDITOR.dom.element
				.createFromHtml('<div id="choice_div"></div><br>');
		// CKEDITOR.instances.editor1.insertElement(choiceDiv);
		choiceDiv.appendTo(questionDiv);
	}
	if (imgDiv == null) {
		imgDiv = CKEDITOR.dom.element
				.createFromHtml('<div id="img_div"></div><br>');
		// CKEDITOR.instances.editor1.insertElement(imgDiv);
		imgDiv.appendTo(questionDiv);
	}

}

var aryQuestionDiv=[];
var aryPassageDiv=[];
var aryChoiceDiv=[];
var aryImgDiv=[];


function createQuestionDiv(num){
	
	var questionDiv;
	
	// content_div를 얻어옵니다. (content_div는 여러 문제들이 속해 있는 div입니다.)
	if(contentDiv == null){
		contentDiv = editor.document.getById('content_div');
	}
	
	// questionDiv를 생성합니다. (questionDiv는 문제 하나가 속한 div입니다. 문제별로 questionDiv가
	// 존재합니다.)
	questionDiv = CKEDITOR.dom.element.createFromHtml('<div id="content_div_' + num + '"></div><br>');
	aryQuestionDiv.push(questionDiv);
	questionDiv.appendTo(contentDiv);
	
}

function createPassageDiv(num){
	
	var passageDiv;
	
	passageDiv = CKEDITOR.dom.element
	.createFromHtml('<div id="passage_div_' + num + '"></div><br>');
	// CKEDITOR.instances.editor1.insertElement(passageDiv);
	aryPassageDiv.push(passageDiv);
	passageDiv.appendTo(questionDiv);
}

function createImgDiv(num){
	
}

function createDivNum(num) {

	var questionDiv;
	var passageDiv;
	var choiceDiv;
	var imgDiv;
	
	// content_div를 얻어옵니다. (content_div는 여러 문제들이 속해 있는 div입니다.)
	if(contentDiv == null){
		contentDiv = editor.document.getById('content_div');
	}
	
	// questionDiv를 생성합니다. (questionDiv는 문제 하나가 속한 div입니다. 문제별로 questionDiv가
	// 존재합니다.)
	questionDiv = CKEDITOR.dom.element.createFromHtml('<div id="content_div_' + num + '"></div><br>');
	aryQuestionDiv.push(questionDiv);
	questionDiv.appendTo(contentDiv);
	
		passageDiv = CKEDITOR.dom.element
				.createFromHtml('<div id="passage_div_' + num + '"></div><br>');
		// CKEDITOR.instances.editor1.insertElement(passageDiv);
		aryPassageDiv.push(passageDiv);
		passageDiv.appendTo(questionDiv);
		
		imgDiv = CKEDITOR.dom.element
				.createFromHtml('<div id="img_div_' + num + '"></div><br>');
		// CKEDITOR.instances.editor1.insertElement(imgDiv);
		aryImgDiv.push(imgDiv);
		imgDiv.appendTo(questionDiv);
		

		choiceDiv = CKEDITOR.dom.element
				.createFromHtml('<div id="choice_div_' + num + '"></div><br>');
		// CKEDITOR.instances.editor1.insertElement(choiceDiv);
		aryChoiceDiv.push(choiceDiv);
		choiceDiv.appendTo(questionDiv);
		
}


function loadQuestionList() {
	
	var n=0;
	//이 부분을 작성해주세요.
	//jsonQuestionList는 서버에서 전달된 문제 배열입니다.
	//이 배열에 있는 문제를 웹페이지에 나열해주세요.
	//+추가적으로 사용자가 문제를 선택하면 addQuestionToEditor(num)을 호출해주세요.
	//num은 jsonQuestionList에서의 인덱스입니다.
	while(jsonQuestionList[n]!=null){
		var question=jsonQuestionList[n].capimageLink;
		console.log(question);
		n++;
		
	}
}


function loadQuestionList_old2(jsonQuestionList) {
	for(var i=0; i<jsonQuestionList.length; i++){
		createDivNum(i);
		passageDiv[i].setText(jsonQuestionList[i].passage);
		imgDiv[i].setHtml("<img id='question_img_" + i + "' width='" + 300 + "' src='" + jsonQuestionList[i].imageLink + "' >");
		choiceDiv[i].setText(jsonQuestionList[i].mulChoice_one);
	}
	alert(jsonQuestionList[0].passage);

}


function createForm() {
	var editor = CKEDITOR.instances.editor1;

	setTimeout(function(){questionDiv = editor.document.getById('question_div');alert(questionDiv)}, 3000)
	// questionDiv = editor.document.getById('question_div');
}

function loadQuestionList_old(jsonQuestionList) {
	document.getElementById('editor1').innerHTML = "<div id=\'question"
			+ questionCount + "\'>" + jsonQuestionList[0].passage + "</div>";
	document.getElementById('editor1').innerHTML = "<img src=  \'"  + jsonQuestionList[0].imageLink  + "\' />";
	alert(jsonQuestionList[0].passage);

}

function insertQuestion() {
	questionCount +=1;
	createDiv(questionCount);
}
function removeQuestion() {
}



















function onPassageChange() {

	if (passageDiv == null) {
		createDiv();
		createDivNum(3);
		createDivNum(4);
		
	}
	if (passageInput == null) {
		passageInput = document.getElementById('passageInput');
	}
	passageDiv.setHtml("<b>" + passageInput.value + "</b>");

	passageInput.focus();

}

function onChoiceChange() {

	if (choiceDiv == null) {
		createDiv();
	}
	if (choiceInput == null) {
		choiceInput = document.getElementById('mulChoice');
	}
	choiceDiv.setText(choiceInput.value);
	choiceInput.focus();
}

function onFileSelected(file) {

	// 파일의 인자로 input element의 files를 전달받습니다.

	if (imgDiv == null) {
		createDiv();
	}

	var fileReader = new FileReader();
	// fileReader객체로 input 태그에서 받아온 첫번째 파일의 URL을 받아옵니다.
	fileReader.readAsDataURL(file[0]);

	// 파일을 다읽어오면 콜백onload합수로 이미지 태그를 에디터안에 넣어줍니다.
	fileReader.onload = function() {
		imgDiv.setHtml('<img id=\"preview1\" width=\'' + 300 + '\' src=\''
				+ fileReader.result + '\' >');
	}

}
