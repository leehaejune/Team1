$(document).ready(function(){
	var idStatus = 0;
	var pwdStatus = 0;
	var nickStatus = 0;
	var emailStatus = 0;
	
//	회원가입
	$("#CheckForm").click(function(e) {
		e.preventDefault();
		var params = {
				id : $("#idCheckForm").val(),
				pwd : $("#pwd1").val(),
				nick : $("#nick").val(),
				email : $("#email").val()
		};
		$.ajax({
			type: "POST",
			url: "/signup",
			data: params,
			contentType: 'application/x-www-form-urlencoded; charset=euc-kr',  
		}).done(function(d){
			if (d == 1){
				$.ajax({
					type: "POST",
					url: "/login",
					data: {id : $("#idCheckForm").val(), pwd : $("#pwd1").val()},
					contentType: 'application/x-www-form-urlencoded; charset=euc-kr',  
				}).done(function(d){
					window.location.href = '/joinSuccess';
				});
			}
			
		});
	});
	
//	ID입력칸
	$("#idCheckForm").focus(function(){
		if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
			$("#CheckForm").css("background-color","#6db92a");
			$("#CheckForm").text("회원가입하기");
			$("#CheckForm").attr("disabled",false);
		} else {
			$("#CheckForm").text("ID 입력란입니다");
			$("#CheckForm").css("background-color","orange");
			$("#CheckForm").attr("disabled",true);
		};
	});
	$("#idCheckForm").keyup(function() {
		if ($("#idCheckForm").val() == ""){
			$("#CheckForm").css("background-color","orange");
			$("#CheckForm").text("ID를 작성해주세요");
			idStatus = 0;
			$("#CheckForm").attr("disabled",true);
		} else {
			$.ajax({
				type: "POST",
				url: "/idExist",
				data: {idExist : $("#idCheckForm").val(), _auth : document.getElementsByName("_auth")[0].value}
			}).done(function(d){
				if (d == 0){
					idStatus = 2;
					$("#idCheckForm").css({"color": "black"});
					if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
						$("#CheckForm").css("background-color","#6db92a");
						$("#CheckForm").text("회원가입하기");
						$("#CheckForm").attr("disabled",false);
					} else {
						$("#CheckForm").css("background-color","orange");
						$("#CheckForm").text("사용가능한 아이디입니다");
						$("#CheckForm").attr("disabled",true);
					}
				} else if (d >= 1){
					$("#idCheckForm").css({"color": "red"});
					$("#CheckForm").css("background-color","grey");
					$("#CheckForm").text("중복된 아이디입니다");
					idStatus = 1;
					$("#CheckForm").attr("disabled",true);
				}
			});
		}
	});
	$("#idCheckForm").blur(function(){
		if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
			$("#CheckForm").css("background-color","#6db92a");
			$("#CheckForm").text("회원가입하기");
			$("#CheckForm").attr("disabled",false);
		} else if (idStatus == 1 || pwdStatus == 1){
			$("#CheckForm").css("background-color","grey");
			$("#CheckForm").text("빨간 글씨를 수정해주세요");
			$("#CheckForm").attr("disabled",true);
		} else {
			$("#CheckForm").css("background-color","grey");
			$("#CheckForm").text("빈 칸을 모두 채워주세요");
			$("#CheckForm").attr("disabled",true);
		}
	});
	
//	비밀번호1
	$("#pwd1").focus(function(){
		if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
			$("#CheckForm").css("background-color","#6db92a");
			$("#CheckForm").text("회원가입하기");
			$("#CheckForm").attr("disabled",false);
		} else {
			$("#CheckForm").text("비밀번호 입력란입니다");
			$("#CheckForm").css("background-color","orange");
			$("#CheckForm").attr("disabled",true);
		};
	});
	$("#pwd1").keyup(function() {
		$("#pwd2").val("");
		if($("#pwd1").val() == "") {
			$("#CheckForm").css("background-color","orange");
			$("#CheckForm").text("비밀번호를 작성해주세요");
			$("#pwd2").attr("disabled",true);
		} else {
			if($("#pwd1").val().length > 20) {
				$("#pwd1").css({"color": "red"});
				$("#CheckForm").css("background-color","grey");
				var pwd1 = $("#pwd1").val();
				$("#pwd1").val(pwd1.substring(0, 20));
				$("#pwd2").attr("disabled",true);
			} else if($("#pwd1").val().length < 4) {
				$("#pwd1").css({"color": "red"});
				$("#CheckForm").css("background-color","grey");
				$("#CheckForm").text("비밀번호는 4자 이상 적어주세요");
				$("#pwd2").attr("disabled",true);
			} else {
				$("#pwd1").css({"color": "black"});
				$("#CheckForm").css("background-color","orange");
				$("#CheckForm").text("사용가능한 비밀번호입니다");
				$("#pwd2").attr("disabled",false);
			}
		}
	});
	
//	비밀번호2
	$("#pwd2").focus(function(){
		if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
			$("#CheckForm").css("background-color","#6db92a");
			$("#CheckForm").text("회원가입하기");
			$("#CheckForm").attr("disabled",false);
		} else {
			$("#CheckForm").text("비밀번호입력 확인란입니다");
			$("#CheckForm").css("background-color","orange");
			$("#CheckForm").attr("disabled",true);
		};
	});
	$("#pwd2").keyup(function() {
		if($("#pwd2").val() == "") {
			$("#CheckForm").css("background-color","orange");
			$("#CheckForm").text("비밀번호 확인을 작성해주세요");
			pwdStatus = 0;
			$("#CheckForm").attr("disabled",true);
		} else {
			if($("#pwd1").val() == $("#pwd2").val()) {
				$("#pwd2").css({"color": "black"});
				pwdStatus = 2;
				if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
					$("#CheckForm").css("background-color","#6db92a");
					$("#CheckForm").text("회원가입하기");
					$("#CheckForm").attr("disabled",false);
				} else {
					$("#CheckForm").css("background-color","orange");
					$("#CheckForm").text("사용가능한 비밀번호입니다");
					$("#CheckForm").attr("disabled",true);
				}
			} else {
				$("#pwd2").css({"color": "red"});
				$("#CheckForm").css("background-color","grey");
				$("#CheckForm").text("비밀번호가 일치하지 않습니다");
				pwdStatus = 1;
				$("#CheckForm").attr("disabled",true);
			}
		}
	});
	$("#pwd2").blur(function(){
		if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
			$("#CheckForm").css("background-color","#6db92a");
			$("#CheckForm").text("회원가입하기");
			$("#CheckForm").attr("disabled",false);
		} else if (idStatus == 1 || pwdStatus == 1){
			$("#CheckForm").css("background-color","grey");
			$("#CheckForm").text("빨간 글씨를 수정해주세요");
			$("#CheckForm").attr("disabled",true);
		} else {
			$("#CheckForm").css("background-color","grey");
			$("#CheckForm").text("빈 칸을 모두 채워주세요");
			$("#CheckForm").attr("disabled",true);
		}
	});
	
//	닉네임
	$("#nick").focus(function(){
		if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
			$("#CheckForm").css("background-color","#6db92a");
			$("#CheckForm").text("회원가입하기");
			$("#CheckForm").attr("disabled",false);
		} else {
			$("#CheckForm").text("닉네임 입력란입니다");
			$("#CheckForm").css("background-color","orange");
			$("#CheckForm").attr("disabled",true);
		};
	});
	$("#nick").keyup(function() {
		if($("#nick").val() == "") {
			$("#CheckForm").css("background-color","orange");
			$("#CheckForm").text("닉네임을 작성해주세요");
			nickStatus = 0;
			$("#CheckForm").attr("disabled",true);
		} else if ($("#nick").val() != ""){
			nickStatus = 2;
			if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
				$("#CheckForm").css("background-color","#6db92a");
				$("#CheckForm").text("회원가입하기");
				$("#CheckForm").attr("disabled",false);
			} else {
				$("#CheckForm").css("background-color","orange");
				$("#CheckForm").text("닉네임을 작성해주세요");
				$("#CheckForm").attr("disabled",true);
			}
		} 
	});
	$("#nick").blur(function(){
		if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
			$("#CheckForm").css("background-color","#6db92a");
			$("#CheckForm").text("회원가입하기");
			$("#CheckForm").attr("disabled",false);
		} else if (idStatus == 1 || pwdStatus == 1){
			$("#CheckForm").css("background-color","grey");
			$("#CheckForm").text("빨간 글씨를 수정해주세요");
			$("#CheckForm").attr("disabled",true);
		} else {
			$("#CheckForm").css("background-color","grey");
			$("#CheckForm").text("빈 칸을 모두 채워주세요");
			$("#CheckForm").attr("disabled",true);
		}
	});
	
//	이메일
	$("#email").focus(function(){
		if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
			$("#CheckForm").css("background-color","#6db92a");
			$("#CheckForm").text("회원가입하기");
			$("#CheckForm").attr("disabled",false);
		} else {
			$("#CheckForm").text("이메일 입력란입니다");
			$("#CheckForm").css("background-color","orange");
			$("#CheckForm").attr("disabled",true);
		};
	});
	$("#email").keyup(function() {
		if($("#email").val() == "") {
			$("#CheckForm").css("background-color","orange");
			$("#CheckForm").text("이메일을 작성해주세요");
			emailStatus = 0;
			$("#CheckForm").attr("disabled",true);
		} else if ($("#email").val() != ""){
			emailStatus = 2;
			if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
				$("#CheckForm").css("background-color","#6db92a");
				$("#CheckForm").text("회원가입하기");
				$("#CheckForm").attr("disabled",false);
			} else if (idStatus == 1 || pwdStatus == 1){
				$("#CheckForm").css("background-color","grey");
				$("#CheckForm").text("빨간 글씨를 수정해주세요");
				$("#CheckForm").attr("disabled",true);
			} else {
				$("#CheckForm").css("background-color","grey");
				$("#CheckForm").text("빈 칸을 모두 채워주세요");
				$("#CheckForm").attr("disabled",true);
			}
		}
	});
	$("#email").blur(function(){
		if (idStatus == 2 && pwdStatus == 2 && nickStatus == 2 && emailStatus == 2){
			$("#CheckForm").css("background-color","#6db92a");
			$("#CheckForm").text("회원가입하기");
			$("#CheckForm").attr("disabled",false);
		} else if (idStatus == 1 || pwdStatus == 1){
			$("#CheckForm").css("background-color","grey");
			$("#CheckForm").text("빨간 글씨를 수정해주세요");
			$("#CheckForm").attr("disabled",true);
		} else {
			$("#CheckForm").css("background-color","grey");
			$("#CheckForm").text("빈 칸을 모두 채워주세요");
			$("#CheckForm").attr("disabled",true);
		}
	});
});
