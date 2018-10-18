var editor;
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
      // Make the editing area bigger than default.
      height : 800,
      // An array of stylesheets to style the WYSIWYG area.
      // Note: it is recommended to keep your own styles in a separate file in
      // order to make future updates painless.
      contentsCss : [ 'https://cdn.ckeditor.com/4.8.0/full-all/contents.css',
            'mystyles.css', 'resources/innerEditor.css' ],
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
      } ]
   });

   alert('에디터 생성11');
}

var QuestionList;
var questionCount = 0;
var passageDiv;
var choiceDiv;
var imgDiv;
var passageInput;
var choiceInput;
var questionDiv;

function createDiv() {

   createForm();

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

function createForm() {
   var editor = CKEDITOR.instances.editor1;

   editor.document
         .getBody()
         .setHtml(
               '<DIV id=\'head_div\'>         <h3 class=\'header\' id=\'test_paper_name\'>STM 문제지</h3>         <h3 class=\'header\' id=\'test_paper_page_num\'>1</h3>         <div class=\'header\' id=\'test_paper_time\'>제 1교시</div>         <h1 class=\'header\' id=\'subject\'>과목 영역</h1>                  <div class=\'header\' id=\'student_input_div\'>         <div class=\'header student_info\'>성명</div>         <div class=\'header student_info student_input_name\' id=\'student_input_name\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>         <div class=\'header student_info\'>수험번호</div>         <div class=\'header student_info student_input_id\' id=\'student_input_id_1\'>&nbsp;&nbsp;&nbsp;</div>         <div class=\'header student_info student_input_id\' id=\'student_input_id_2\'>&nbsp;&nbsp;&nbsp;</div>         <div class=\'header student_info student_input_id\' id=\'student_input_id_3\'>&nbsp;&nbsp;&nbsp;</div>         <div class=\'header student_info student_input_id\' id=\'student_input_id_4\'>&nbsp;&nbsp;&nbsp;</div>         <div class=\'header student_info student_input_id\' id=\'student_input_id_5\'>&nbsp;&nbsp;&nbsp;</div>         <div class=\'header student_info\'>-</div>         <div class=\'header student_info student_input_id\' id=\'student_input_id_6\'>&nbsp;&nbsp;&nbsp;</div>         <div class=\'header student_info student_input_id\' id=\'student_input_id_7\'>&nbsp;&nbsp;&nbsp;</div>         <div class=\'header student_info student_input_id\' id=\'student_input_id_8\'>&nbsp;&nbsp;&nbsp;</div>         <div class=\'header student_info student_input_id\' id=\'student_input_id_9\'>&nbsp;&nbsp;&nbsp;</div>         </div>      </DIV>     <hr color=\'#000\'/>     <DIV class=\'content\' id=\'question_div\'>         <p>1sadifjaoweifjaweofiawjefoiawjeofiawjeofiawjoefijawoeifje</p>                  <p>2sadifjaoweifjaweofiawjefoiawjeofiawjeofiawjoefijawoeifje</p>                  <p>3sadifjaoweifjaweofiawjefoiawjeofiawjeofiawjoefijawoeifje</p>                  <p>4sadifjaoweifjaweofiawjefoiawjeofiawjeofiawjoefijawoeifje</p>                  <p>5sadifjaoweifjaweofiawjefoiawjeofiawjeofiawjoefijawoeifje</p>                  <p>6sadifjaoweifjaweofiawjefoiawjeofiawjeofiawjoefijawoeifje</p>                  <p>7sadifjaoweifjaweofiawjefoiawjeofiawjeofiawjoefijawoeifje</p>                  <p>8sadifjaoweifjaweofiawjefoiawjeofiawjeofiawjoefijawoeifje</p>     </DIV>     <hr color=\'#000\'/>');
   questionDiv = editor.document.getById('question_div');
}

function loadQuestionList(jsonQuestionList) {
   document.getElementById('editor1').innerHTML = "<div id=\'question"
         + questionCount + "\'>" + jsonQuestionList[0].passage + "</div>";
   document.getElementById('editor1').innerHTML = "<img src=  \'"  + jsonQuestionList[0].imageLink  + "\' />";
   alert(jsonQuestionList[0].passage);

}

function insertQuestion() {

}
function removeQuestion() {
}

function onPassageChange() {

   if (passageDiv == null) {
      createDiv();
   }
   if (passageInput == null) {
      passageInput = document.getElementById('passageInput');
   }
   passageDiv.setHtml("<b>" + passageInput.value + "</b>");

   passageInput.focus();

}

function onChoiceChange() {

   alert('choice 함수');
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