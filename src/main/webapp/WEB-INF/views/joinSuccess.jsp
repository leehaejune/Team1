<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>인벤 회원가입</title>
	<link rel="shortcut icon" type="image/x-icon" href="res/img/main_page/favicon.ico?v=151218a">
	<link rel="stylesheet" href="res/css/indexJoin.css">
	<script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script>
<!-- 	<script src="/res/js/indexJoin.js"></script> -->
</head>
<body>
	<div id="full_body">
		<div id="head"></div>
		<div id="body">
			<div id="div_no1">
				<form id="input_form">
					<div id="div_no0">인벤 <span style="color:#555;">회원가입</span></div>
					<div id="div_no2">
						<br><p style="color:#444; line-height:33px; font-weight:bold; text-align:center; letter-spacing:1.5px; font-size:17px;">
						<span style="color:orange; font-size:19px;">${sessionScope.UserInfo.nick}</span>님 반갑습니다!<br>
						회원가입과 로그인이 완료되었습니다
						</p><br>
						<button id="CheckForm" type="button" onclick="location.href='/'">홈으로 이동</button>
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