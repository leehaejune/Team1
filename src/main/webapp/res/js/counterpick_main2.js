$(document).ready(function(){
	var test1;
	var test2;
	var params;
	var params1;
	var imgTag;
	var index;
	var hno;
	var hheroname;
	var random1;
	var number1 = 30;
	var sum;
	var result_vote_sum;
	firsttest();
	counterPickView();
	
	var vote_result = function (){
//	    var hheroname = $("#herobox_heroname_name > span").eq(index).attr("data-hname");
	    params = {
	    		no : hno
	    };
	    console.log(params);
	    $.ajax({
			type : "POST",
			url : "/getName",
			data : params
		}).done(function(d){
			console.log("224");
			console.log(d);
			hheroname = d[0].heroname;
			console.log(hheroname);
			$("#heroportal_heroinfo_text_top").html(d[0].heroname);
			imgTag.src = d[0].heroimg;
//			var params = "?no=" + hno + "&heroname=" +hheroname;
//			$("#vote_result_list1").load("/getVoteData" + params, {}, function(d){
//				console.log(d);
//			});
			var imgTag1 = document.getElementById('vote_result_list_col_2_picture');
			var imgsrc = d[0].heroimg;
	    	params = {
		    		no : hno,
		    		heroname : hheroname,
		    		heroimg : imgsrc
		    };
	    	$.ajax({
				type : "POST",
				url : "/getVoteData",
				data : params
			}).done(function(d){
				console.log("2222");
				console.log(params);
				params1 = {
						heroname : params.heroname	
				};
				console.log("params1");
				console.log(params1);
				console.log(imgsrc);
				console.log(d);
				//
				$("#vote_result_list1").html(d);
				$('#stL').height($('#stM').innerHeight());
				console.log(params.heroname);
				var Iheroname = params.heroname;
				params = {
					heroname : Iheroname	
				};
				console.log(params);
				if(params.heroname=="아나" || params.heroname=="애쉬"){
//					alert("1");
					$.ajax({
						type : "POST",
						url : "/getImg",
						data : params
					}).done(function(d){
						console.log("7777");
						console.log(d);
//						console.log(d[0].heroimg);
						var img1 = document.getElementById('vote_result_list_col_2_picture');
//						img1.src = d[0].heroimg;
						var img2 = document.getElementsByClassName('col_2_here_picture');
						console.log(img2);
						for(var i=0;i<30;i++){
							img2[i].src = d[i].heroimg;
//							img1.src = d[i].heroimg;
						}
						sum = 0;
						result_vote_sum = 0;
						result_vote_sum = document.getElementsByClassName('vote_result_list_col_4');
						for(var i=0;i<30;i++){
							var inta;
							console.log(result_vote_sum[i]);
							console.log(result_vote_sum[i].getAttribute("value"));
							inta = (result_vote_sum[i].getAttribute("value")) * 1;
							console.log(inta);
							sum = sum + inta;
//							console.log(result_vote_sum[i].find("li").text());
						}
//						console.log("8888");
//						console.log(params.heroname);
						if(params1.heroname=="아나"){
							$("#strong_hero").html("전체 평가수: ");
							$("#strong_no").html(sum);
						} else if(params1.heroname=="애쉬"){
							$("#strong_hero").html("전체 평가수: ");
							$("#strong_no").html(sum);
						} else {
							
						}
						
//						console.log(sum);
//						$("#strong_hero").html("전체 평가수: ");
//						$("#strong_no").html(sum);
					});
					
				}
				else {

					$("#strong_hero").html("");
					$("#strong_no").html(null);
				}
				
			});
	    	
		});
	    
	}
	
	function counterPickView(){
//		$.ajax({
//			url:"/getData",
//			type: "POST"
//		}).done(function(d){
//			console.log(d);
//			$("#herobox_herolist").html(d);
//		});
		$("#herobox_herolist").load("/getData_cp", {}, function(){
			$("#herobox_herolist > div").click(function(){
				imgTag = document.getElementById('heroportal_heroinfo_picture');
			    index = $("#herobox_herolist > div").index(this);
			    hno = $("#herobox_herolist > div").eq(index).attr("data-hno");
				vote_result();
			});
			
			$("#votenext_button1").click(function(){
				random1 = Math.random() * 31;
//				number1 = Math.floor(random1);
				console.log(random1);
				console.log(number1);
				var random2 = Math.random() * 31;
				var number2 = Math.floor(random2);
				console.log(random2);
				console.log(number2);
				//아나로 고정(테스트용)
				if(number1==10){
					number1=30;
				} else if(number1==30){
					number1=10;
				}
				//				
				if(number1==0){
					number1 = 1;
				}
				if(number2==0){
					number2 = 1;
				}		
				if(number1==number2){
					number2 = number2 + 1;
				}
				
				var imgTag1 = document.getElementById('votechar_img1');
				var imgTag2 = document.getElementById('votechar_img2');
				
			    params = {
			    		no1 : number1,
			    		no2 : number2
			    };
			    console.log(params);
			    $.ajax({
					type : "POST",
					url : "/getVote",
					data : params
				}).done(function(d){
					console.log("22");
					console.log(d);
					console.log(d.no2[0].heroname);
					$("#votechar_name_1").html(d.no1[0].heroname);
//					$("#heroportal_heroinfo_text_top").html(d[0].heroname);
//					imgTag1.src = d[0].heroimg;
					imgTag1.src = d.no1[0].heroimg;
					$("#votechar_name_2").html(d.no2[0].heroname);
					imgTag2.src = d.no2[0].heroimg;				
					//우세버튼
					
					test1=d.no1[0].heroname;
					test2=d.no2[0].heroname;
					
				});
				
			});
			
		});
		//우세버튼
		$("#vote_button_strong_a_1").click(function(){
			console.log("vote_button_strong_a_1");
			params = {
					mnhero : test1,
					cnhero : test2
		    };
			$.ajax({
				type : "POST",
				url : "/getVoteno1",
				data : params
			}).done(function(d){
				console.log("55");
				console.log(d);
				var plus = d[0].voteno1;
				console.log(plus);
				var plus2 = plus + 1;
				console.log(plus2);
				params = {
						mnhero : test1,
						cnhero : test2,
						voteno1 : plus2
			    };
				console.log("params");
				console.log(params);
				$.ajax({
					type : "POST",
					url : "/setVoteUpdate1",
					data : params
				}).done(function(d){
					console.log("22");
					console.log(d);
					vote_result();
				});
			});
		});
		//동등버튼
		$("#vote_button_strong_a_2").click(function(){
			console.log("vote_button_strong_a_2");
			params = {
					mnhero : test1,
					cnhero : test2
		    };
			$.ajax({
				type : "POST",
				url : "/getVoteno2",
				data : params
			}).done(function(d){
				console.log("55");
				console.log(d);
				var plus = d[0].voteno2;
				console.log(plus);
				var plus2 = plus + 1;
				console.log(plus2);
				params = {
						mnhero : test1,
						cnhero : test2,
						voteno2 : plus2
			    };
				console.log("params");
				console.log(params);
				$.ajax({
					type : "POST",
					url : "/setVoteUpdate2",
					data : params
				}).done(function(d){
					console.log("22");
					console.log(d);
					vote_result();
				});
			});
		});
		//약세버튼
		$("#vote_button_strong_a_3").click(function(){
			console.log("vote_button_strong_a_3");
			params = {
					mnhero : test1,
					cnhero : test2
		    };
			$.ajax({
				type : "POST",
				url : "/getVoteno3",
				data : params
			}).done(function(d){
				console.log("55");
				console.log(d);
				var plus = d[0].voteno3;
				console.log(plus);
				var plus2 = plus + 1;
				console.log(plus2);
				params = {
						mnhero : test1,
						cnhero : test2,
						voteno3 : plus2
			    };
				console.log("params");
				console.log(params);
				$.ajax({
					type : "POST",
					url : "/setVoteUpdate3",
					data : params
				}).done(function(d){
					console.log("22");
					console.log(d);
					vote_result();
				});
			});
		});
		
	}
	
	function firsttest(){
		var imgTag1 = document.getElementById('votechar_img1');
		$("#votechar_name_1").html("영웅1");
		imgTag1.src = "/res/img/char/hero_null.png";
		var imgTag2 = document.getElementById('votechar_img2');
		$("#votechar_name_2").html("영웅2");
		imgTag2.src = "/res/img/char/hero_null.png";
	}
	
});
	


