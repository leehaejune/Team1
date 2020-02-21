<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>인벤 회원가입</title>
	<link rel="shortcut icon" type="image/x-icon" href="res/img/main_page/favicon.ico?v=151218a">
	<link rel="stylesheet" href="res/css/indexJoin.css">
	<link rel="stylesheet" href="res/css/userUpdate.css">
	<script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script>
	<script src="/res/js/userUpdate.js"></script>
</head>
<body>
	<div id="full_body">
		<div id="head"></div>
		<div id="body">
			<div id="div_no1">
				<form id="input_form">
					<div id="div_no0" onclick="location.href='/'">인벤 <span style="color:#555;">정보수정</span></div>
					<div id="div_no2">
						<div class="input_div">
							<input id="idCheckForm" class="input_box" type="text" name="signid" placeholder="아이디" required="required" value="${sessionScope.UserInfo.id}" readonly="readonly">
						</div>
						<div class="input_div">
							<input class="input_box" type="password" name="pwd1" id="pwd1" placeholder="변경 비밀번호" required="required"><br>
						</div>
						<div class="input_div">
							<input class="input_box" type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인" required="required" disabled="disabled"><br><br>
						</div>
						<div class="input_div">
							<input class="input_box" type="text" name="nick" id="nick" placeholder="닉네임" required="required" value="${sessionScope.UserInfo.nick}"><br>
						</div>
						<div class="input_div">
							<input class="input_box" type="email" name="email" id="email" placeholder="이메일" required="required" value="${sessionScope.UserInfo.email}"><br>
						</div>
						<div>
							<button id="CheckForm" type="button" disabled="disabled">정보 수정하기</button>
							<button id="delete" type="button">회원탈퇴</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="foot">
			<div>
				<div id="foot_div2">Copyright ⓒ Inven. All rights reserved.
					          참고 사이트 : 
					<a href="http://overwatch.inven.co.kr/">오버워치 인벤</a>
				</div>				
			</div>
		</div>
	</div>
</body>
</html>