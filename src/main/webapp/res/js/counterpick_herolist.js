//$(document).ready(function(){
//	
//	var imgTag = document.getElementById('heroportal_heroinfo_picture');
//	var parentUrl = "http://192.168.3.231/img/char/";
//	var childUrl = ".png";
//	var nameTag = document.getElementsByClassName('herobox_heroname_name');
////	var nameTag1 = document.getElementsByClassName('herobox_heroname_name').value();
//	
//	var params = {
//			heroname : "",
//			heroimg : ""
//	};
//	
////	$(".herobox_hero").click(function herobox_herolink(){
////		
////		var check_hero = $(this).attr('id');
//		
////		console.log($(".herobox_hero").attr('id'));
////		console.log(check);
//		
////		var newSrc = parentUrl + check_hero + childUrl;
////		imgTag.src = newSrc;
////		$("#heroportal_heroinfo_text_top").html(check_hero);
//		
////	});
//	$("#herobox_herolist .herobox_heroname").click(function(){
//		var index = $("#herobox_herolist .herobox_heroname").index(this);
//		var heroname_english = $("#herobox_herolist .herobox_heroname").eq(index).find("a").attr("id");
//		var heroname = $("#herobox_herolist .herobox_heroname").eq(index).find("span").text();
////		console.log(heroname_english, heroname);
////		console.log(index);
////		params.heroname = heroname;
////		params.heroimg = heroimg;
//		
////		$("#heroportal_heroinfo_text_top").html(heroname);
//		
////		$.ajax({
////			type : "POST",
////			url : "/counterpick",
////			data : JSON.stringify(params),
////			contentType : "application/json; charset=UTF-8"
////		}).done(function(){
////			console.log(params);
////			$("#heroportal_heroinfo_text_top").html(heroname);
////		});
//		
//		$.ajax({
//			type : "POST",
//			url : "/counterpick",
//			data : heroname,
//			contentType : "application/json; charset=UTF-8"
//		}).done(function(d){
////			console.log(params);
////			console.log(heroname);
////			console.log(d);
////			console.log(d[0].heroimg);
//			
//			$("#heroportal_heroinfo_text_top").html(d[0].heroname);
////			$("#heroportal_heroinfo_picture").html(d[0].heroimg);
//			imgTag.src = d[0].heroimg;
//			
//			
//		});
//		
//	});
//	
//});
