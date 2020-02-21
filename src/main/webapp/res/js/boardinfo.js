$(document).ready(function(){

	var getNo = function(){
		var pathname = location.pathname;
		return pathname.substring(pathname.lastIndexOf("/") + 1, pathname.length);
	}
	
	var listview22 = function(e){
		
//		$("#boardList4").load("/boardinfosub", {});
		$("#boardList1").load("/boardsub1", {});
		$("#boardList2").load("/boardsub2", {});
		

		
	var url = "/boardinfosub/" + getNo();
		$("#boardList4").load(url, {}, function(d) {
			if(d == "") {location.href = "/board";}
		});
		
	}
	
	

	
	$("#delbutton").click(function(){
		id = $("#sid").val();
		bid = $("#bid").text();
		console.log(id);
		console.log(bid);
		
		if(id == bid) {
			a = confirm("정말로 삭제하시겟습니까?")
			
			if(a){
				$.ajax({
					type : "POST",
					url : "/delBoard",
					data : {no : getNo()}
				}).done(function(d){
					if(d == 1){
						alert("삭제되었습니다.");
						window.location.href = '/board';
					} else {
						alert("실패.");
					}				
				});
				
				} else{
				alert("취소되었습니다.");
				}
			
			}
			else {
			alert("권한이없슈");
		}
		
	});

	
	$("#upbutton").click(function(){
		id = $("#sid").val();
		bid = $("#bid").text();
		console.log(id);
		console.log(bid);
		
		if(id == bid){
			
			$.ajax({
				type : "POST",
				url : "/getBoardData",
				data : JSON.stringify({no : getNo()}),
				contentType : "application/json; charset=UTF-8"
			}).done(function(d){
	
				window.location.href = '/board/up2';	
			})
			

		}else{
			alert("권한이 없습니다.");
		}
	})
	
	
	listview22();
	
	
});

