$(document).ready(function(){
	
	var listView4 = function(e){
		
		$("#boardList1").load("/boardsub1", {});
		$("#boardList2").load("/boardsub2", {});
		$("#db5").load("/boardsub3", {}, function(){
			getboradList3("/board/D/-1");
		});
		$.post("/getData").done(setView);
	}
	
	var setView = function(data){
		$("#db2aa").empty();
		data.HeroList.forEach(function(a, b) {
			var html =`
						<div  class = "img" data-hno="${a.no}"><div class = "img2" ><img class="heroimg" src ="${a.heroimg}"></div>
							<span>${a.heroname}</span>
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
		
		setViewEvent();
	}	
	
	listView4();
	
	
	var setViewEvent = function(){
		$("#db2aa > div").click(function(){
		    var index = $("#db2aa > div").index(this);
		    var hno = $("#db2aa > div").eq(index).attr("data-hno");
		    params = {hno : hno};
		    getboradList3("/board/D/-1");
		});
		$("#db3aa > div").click(function(){
		    var index = $("#db3aa > div").index(this);
		    var mno = $("#db3aa > div").eq(index).attr("data-mno");
		    params = {mno : mno};
		    getboradList3("/board/D/-1");
		});
		$("#serch").click(function(){
			if(option ==  "subject"){
		
			params = {title : $("#blank").val()};
			console.log(params);
			getboradList3("/board/D/-1", {title : $("#blank").val()});
			} else {
			console.log(params);
			params = {id : $("#blank").val()};
			getboradList3("/board/D/-1", {id : $("#blank").val()});
					
			}
		})
		
	
	}
	
	var option = $("#selectbar option:selected").val();

	var getboradList3 = function(url, params){
		console.log(url, params);
		$.ajax({
			"url": url,
			"type": "post",
			"data": params
			}
		).done(view);}
	
	var view = function(data){
//		console.log(data, "111");
		
		var vBlock = {start : 0, end : 0};
		data.pagination.forEach(function(a, b) {
			if(data.position == a.position) {
				var p = Math.ceil((b + 1) / 3);
				vBlock.end = (p * 3);
				vBlock.start = (vBlock.end - 3);
			}
		});
		
		$("#boardList3").empty();
		data.list.forEach(function(a, b) {
			var html =`
						<tr>
							<td name="no">${a.no}</td>
							<td><img src="${a.heroimg}" width="40px"></td>
							<td><b>${a.mapname}</b></td>
							<td class="name"><a href="/board/${a.no}">${a.title}</a></td>
							<td class="nick">${a.id}</td>
							<td class="date">${a.date}</td>
							<td>${a.hits}</td>
						</tr>
					  `;
			$("#boardList3").append(html);
		});
		
		$("#db6").empty();
		if(data.pagination.length > 0) {
			var html = `<a>이전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><span>`;
			$("#db6").append(html);
			data.pagination.forEach(function(a, b) {
			    html = `<a href="javascript:void(0);" data-position="${a.position}">${a.num}</a>`;
			    $("#db6").append(html);
			    if(data.position == a.position) {
			    	$("#db6 a").eq($("#db6 a").length - 1).addClass("active");
			    }
			});
			html = `</span><a>&nbsp;&nbsp;&nbsp;&nbsp;다음</a>`;
			$("#db6").append(html);
			btnEvent();
		}
	}
	var btnEvent = function(){
		$("#db6 a").click(function(){
			var index = $("#db6 a").index(this);
			if(index == 0) {
				getboradList3("/board/P/-1");
				return;
			}
			if(index == $("#db6 a").length - 1) {
				getboradList3("/board/N/-1");
				return;
			}
			var position = $("#db6 a").eq(index).attr("data-position");
			getboradList3("/board/D/" + position);
		});
	}
	
	// 아이디 담기
	var id = $("#sid").val();
	

	$("#btn2").click(function(){
		window.location.href = '/board/up';

	})
	

});

