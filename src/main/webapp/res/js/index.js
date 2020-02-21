$(document).ready(function(){
	$('#stL').height($('#stM').innerHeight());
	console.log($('#stLnick').text());
	var cookie1 = 'ajafjlka;g@$46wfa987235lk124j;af*$@j;21908409124owefahg925jl231498af0981242899jkaf9754325123aflkjaow346jfaogh1812498ajfl;;awegjgks9ei152afaeg1351ahajlfa87235lkalkf10jlkadsf2042adase16dfafyuf44151agsda^&*$)@$%@ro1452321$@231jrklw23452ef)(^*#@e135124aao12464ale#*&(kwr165689j';
	var cookie2 = 'haiowe;r71298237@&$*!*#&fjaewf;h12498127(*&@#(jlfkaj215198:KLJDSA924klk87154#%$@&824ajlafa8140'
	
	var parisUdea = getCookie("parisUdea");
	if (parisUdea != null) {
		var data = parisUdea.substr(cookie1.length).split(cookie2);
		$.ajax({
			type: "POST",
			url: "/login",
			data: {id : data[0], pwd : data[1]},
			contentType: 'application/x-www-form-urlencoded; charset=euc-kr'
		}).done(function(d){
		});
	};
	var logindiv = $('#bg').text();
	console.log("loginDiv", logindiv);
	if (logindiv == "1") {
		logon(parisUdea);
		$('#login_head').text('로그인이 필요합니다');
		logindiv = 0;
		$('#bg').text("0");
	} 
	
	$(document).keydown(function(e){
//		console.log("입력 키보드 코드 : " + e.keyCode);
		if (e.keyCode == 27){
			$('#bg').hide();
			$('#login').hide();
		}
	});	
	
	$('.logon').click(function(){
		logon(parisUdea);
	});
	
	$('#input_form').submit(function(){
		if ($("#saveId").prop("checked")){
            setCookie('saveId', $("input[name='id']").val(), 15);
        } else if (!$("#saveId").prop("checked")){
        	deleteCookie('saveId');
        }
		if ($("#loging").prop("checked")){
            setCookie('parisUdea', cookie1 + $("input[name='id']").val() + cookie2 + $("input[name='pwd']").val(), 15);
		} else if (!$("#loging").prop("checked")){
        	deleteCookie('parisUdea');
        }
	});
});

function logon(parisUdea){
//	if(ab.style.display == 'none'){
//		ab.style.display = 'block';
//		bc.style.display = 'block';
//		document.getElementsByClassName("input_id").autofocus;
//	} else  {
//		ab.style.display = 'none';
//		bc.style.display = 'none';
//	}
	$('#login_head').empty();
	var saveId = getCookie("saveId");
	$('#bg').toggle();
	$('#login').toggle();
	if (saveId != "") {
		$("input[name='id']").val(saveId);
//		$('input:checkbox[id="saveId"]').attr("checked", true);
		$("#saveId").prop("checked", true);
	}
	if (parisUdea != "") {
//		$('input:checkbox[id="loging"]').attr("checked", true);
		$("#loging").prop("checked", true);
	} else {}
}

function brand(index){
	var body = document.getElementsByClassName("brand-body");
	for(var i = 0; i < body.length; i++){
		body[i].classList.remove("dsBlc");
	}
 	body[index].classList.add("dsBlc");
}

function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue + ";path=/";
}

//function setCookie(cname, cvalue, exdays) {
//	  var d = new Date();
//	  d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
//	  var expires = "expires="+d.toUTCString();
//	  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
//}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}