$(document).ready(function(){
	
	var imgTag1 = document.getElementById('votechar_img1');
	var imgTag2 = document.getElementById('votechar_img2');
	var parentUrl = "http://192.168.3.231/img/char/";
	var urlArray = [
		"null.png",
		"Genji.png",
		"Doomfist.png",
		"Reaper.png",
		"McCree.png",
		"Mei.png",
		"Bastion.png",
		"Soldier76.png",
		"Sombra.png",
		"Symmetra.png",
		"Ashe.png",
		"Widowmaker.png",
		"Junkrat.png",
		"Torbjorn.png",
		"Tracer.png",
		"Pharah.png",
		"Hanzo.png",
		"DVa.png",
		"Reinhardt.png",
		"WreckingBall.png",
		"Roadhog.png",
		"Sigma.png",
		"Orisa.png",
		"Winston.png",
		"Zarya.png",
		"Lucio.png",
		"Mercy.png",
		"Moira.png",
		"Baptiste.png",
		"Brigitte.png",
		"Ana.png",
		"Zenyatta.png"
		];
	var votenum = 0;
	var imgTag = document.getElementById('heroportal_heroinfo_picture');
//	var parentUrl = "http://192.168.3.231/img/char/";
	var childUrl = ".png";
	var nameTag = document.getElementsByClassName('herobox_heroname_name');
//	var nameTag1 = document.getElementsByClassName('herobox_heroname_name').value();
	
	var params = {
			no : "",
			position : "",
			heroname : "",
			heroimg : "",
			heroname_english : ""
	};
	var number1 = 30;
	var number2 = 10;
	
	$("#votenext_button1").click(function random_image(){
		
		var random1 = Math.random() * urlArray.length;
		number1 = Math.floor(random1);
		
		var random2 = Math.random() * urlArray.length;
		number2 = Math.floor(random2);
		
		if(number1==0){
			number1 = 1;
		}
		if(number2==0){
			number2 = 1;
		}		
		if(number1==number2){
			number2 = number2 + 1;
		}
		
		var newSrc1 = parentUrl + urlArray[number1];
		var newSrc2 = parentUrl + urlArray[number2];
		
		imgTag1.src = newSrc1;
		imgTag2.src = newSrc2;
		
		var params = {
				number1 : number1, 
				number2	: number2
			};
		console.log("params");
		console.log(params);
		console.log(number1);
		$.ajax({
			type : "POST",
			url : "/counterpick",
			data : params,
			contentType : "application/json; charset=UTF-8"
		}).done(function(d){
			console.log("2");
			console.log(number1);
			console.log(votenum);
			console.log(d);
			$("#votechar_name_1").html(d[0].heroname);
//			imgTag.src = d[0].heroimg;
		});
		
	});
	
//	$(".votetr2_td #vote_button_strong_a_1").click(function(){
//		
//		var index = $("#votechar2 .votechar_name").index(this);
//		console.log(index);
//		var heroname = $("#herobox_herolist .herobox_heroname").eq(index).text();
//		votenum = 1;
//		var params = {
//				heroname : $(".votechar_name").val(),
//				votenum : votenum
//		};
//		console.log("1");
//		console.log(heroname);
//		console.log(votenum);
//		
//		$.ajax({
//			type : "PUT",
//			url : "/counterpick",
//			data : params,
//			contentType : "application/json; charset=UTF-8"
//		}).done(function(d){
//			console.log("2");
//			console.log(params);
//			console.log(votenum);
//			console.log(d);
//			
//		});
//		
//	});
	
	$("#herobox_herolist .herobox_heroname").click(function(){
		var index = $("#herobox_herolist .herobox_heroname").index(this);
		index = index + 1;
//		var heroname_english = $("#herobox_herolist .herobox_heroname").eq(index).find("a").attr("id");
//		var heroname = $("#herobox_herolist .herobox_heroname").eq(index).find("span").text();
		console.log(index);
		params.no = index;
		console.log(params);
		
		$.ajax({
			type : "POST",
			url : "/counterpick",
			data : index,
			contentType : "application/json; charset=UTF-8"
		}).done(function(d){
			console.log("index");
			console.log(index);
			console.log("params");
			console.log(params);
			console.log(d);			
		});
		
		
		
	});
	
});