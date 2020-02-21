$(document).ready(function(){
	
	params = {};
	var params2 = {};
	var params3 = {};
	var params4 = {};
	params5 = {};
	params6 = {};
	var listView4 = function(e){
		$.post("/getData").done(setView);

	}
	var setView = function(data){

		
		$("#db2aa").empty();
		data.HeroList.forEach(function(a, b) {
			var html =`
						<div  class = "img" data-hno="${a.no}"><div class = "img2" ><img class="heroimg" src ="${a.heroimg}"></div>
							<span class ="heroname234">${a.heroname}</span>
						</div>
					  `;
			$("#db2aa").append(html);
			
		});	
		
		$("#db3aa").empty();
		data.MapList.forEach(function(a, b) {
		var html =`
					<div class = "img3" data-mno="${a.no}"><div class ="img4" ><img src ="${a.mapimg}"></div><span>${a.mapname}</span></div>
				  `;
		$("#db3aa").append(html);
		});

		
		$('#hno').attr("value", data["hno"]);
		$('#mno').attr("value", data["mno"]);
		
		$("#db2aa > div").click(function(){		
		    var index = $("#db2aa > div").index(this);
		    hno = $("#db2aa > div").eq(index).attr("data-hno");
		    var div = $("#db2aa > div").children();
		    var img = div.children()[index].src;
		    heroname = $("#db2 span").eq(index).text();   
		    var name = div.children()[index].span;	    
		    $("#hero1").attr("src",img);
		    $("#hno").attr("value",hno);
		    $("#heroname").text(heroname);
	        params = {hno};
	        params5 = {heroname};
		    params2 ={img : img};
		    console.log(params);
		    console.log(params5);
					
		});	
		

		
			$("#db3aa > div").click(function(){
				var index = $("#db3aa > div").index(this);
				mno = $("#db3aa > div").eq(index).attr("data-mno");
				var div2 = $("#db3aa > div").children();
				var img2 = div2.children()[index].src;
				mapname =$("#db3 span").eq(index).text();
		    
		    $("#map1").attr("src", img2);
		    $("#mno").attr("value",mno);
		    $("#mapname").text(mapname);
		    	params3 = {mno : mno};
		    	params4 = {img2 : img2};
		    	params6 = {mapname};

		    	console.log(params3);
		    	console.log(params6);
		});
			
			
			
	}

	listView4();
	

			console.log(params);
	// 날짜 받아오기
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();

	if(dd<10) {
	    dd='0'+dd
	} 

	if(mm<10) {
	    mm='0'+mm
	} 

	today = yyyy+'-'+mm+'-'+dd;
	console.log(today);
	// 유저 받아오기

	var id = $("#sid").val();
	

// 게시글 작성
	$("#btnOk").click(function(){
	

	var click = {
			
		title : $("#edit1").val(),
		content1 : $("#edit").val(),
		id  : $("#sid").val(),
	    date : today,
		hno : $("#hno").val(),
		mno : $("#mno").val()
//		hno : hno,
//		mno : mno
		};
		console.log(click);
		$.ajax({
			type : "POST",
			url : "/setBoard",
			data : click
		}).done(function(d) {
			alert("글작성 완료");
			window.location.href = '/board';
			
		});
	});
	
	$("#btnCancel").click(function(){
			alert("이전 페이지로 돌아갑니다.");
			window.location.href = '/board';	
	});
	
});
	


