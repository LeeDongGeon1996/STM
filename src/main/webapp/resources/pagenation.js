function getPageHeight_out(){
	var pageDiv = CKEDITOR.instances.editor1.document.getById('page1_div');
	
	alert(pageDiv.style.height);
	
}

function onPageChange(){
	
	
}


function regilistener(){
	
	$('#page1_div').change(function(){
		getPageHeight();
		
	});
}


function getPageHeight(){
	var pageDiv = document.getElementById('page1_div');
	
	alert(pageDiv.style.height);
}

function aa(){
	alert('aa function');
	
}