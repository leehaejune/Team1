$(document).ready(function(){
	$('#stL').height($('#stM').innerHeight());
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1;
	var yyyy = today.getFullYear();
		if(dd<10) {
			dd='0'+dd
		} 
		if(mm<10) {
			mm='0'+mm
		} 
	today = yyyy+'-' + mm+'-'+dd;
	
	$("#btn").on("click", function(){
		var data = {
				content : $('#textbox').val(),
				date : today
				}
		console.log(data);
		$.ajax({
			type: "POST",
			url: "/herocomment",
			data: data
		}).done(function(d) {
			if(d == 1){
				alert("댓글이 작성되었습니다");
				location.reload();
			} else {
				alert("댓글등록 실패");
				location.reload();
			}
        });
	});
	
});


	
