<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!-- <title>오버워치 인벤</title> -->
<!-- <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico?v=151218a"> -->
<link rel="stylesheet" href="../../../res/css/login.css">
<script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script>
<!-- <script src="res/js/index.js" type="text/javascript"></script> -->
<!-- </head> -->
<body>
	<div id="bg" class="logon" style="text-align:center; font-size:3px; color:grey;">${logindiv}</div>
	<div id="login">
		<div id="login_head" style="text-align:center; color:red; line-height:217px; font-weight: bold;"></div>
		<div id="login_body">
			<div id="div_no1">
				<form id="input_form" action="/login" method="post">
					<div id="div_no2">
						<div class="input_div">
							<input class="input_id input_box" type="text" name="id" placeholder="아이디"><br>
						</div>
						<div class="input_div">
							<input class="input_password input_box" type="password" name="pwd" placeholder="비밀번호"><br>
						</div>
						<div class="submit_button">
							<button id="login_button" type="submit">로그인</button>
						</div>
					</div>
					<div id="div_no3">
						<ul id="ul1">
							<label for="loging">
								<li id="li1" style="padding-right: 15px;">
								로그인상태 유지<input class="input_check" type="checkbox" id="loging">
							</li>
						</label>
						<label for="saveId">
							<li id="li1" style="padding-right: 15px;">
									아이디 저장<input class="input_check" type="checkbox" id="saveId">
								</li>
							</label>
							<a class="a_link" href="signup">
								<li id="li1">회원가입</li>
							</a>
						</ul>
					</div>
				</form>
			</div>
		</div>
		<div id="login_foot">
			<div>
				<div id="foot_div2">Copyright ⓒ Inven. All rights reserved.</div>
			</div>
		</div>
	</div>
</body>
</html>