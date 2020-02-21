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
<!-- <link rel="stylesheet" href="res/css/index.css"> -->
<!-- <script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script> -->
<!-- <script src="res/js/index.js" type="text/javascript"></script> -->
<!-- </head> -->
<body>
	<header>
		<div id="hd1">
			<img src="../../../res/img/title_logo.png" style="display:block; margin:8px 0 0 7px; float:left;">
			<div style="display:block; width:130px; height:25px; float:right !important;">
				<span  style="display:block; float:left; line-height: 31px; ">
					<c:if test="${sessionScope.UserInfo eq null}">
					<a href="signup">회원가입 | </a>
					</c:if>
					<c:if test="${sessionScope.UserInfo ne null}">
					<span style="color:#EEE;">회원가입 | </span>
					</c:if>
				</span>
				<div>
					<c:if test="${sessionScope.UserInfo eq null}">
						<a class="logon" style="cursor:pointer; margin:4px 0 0 5px; display:block; width:61px; height:19px; overflow:hidden; float:left;"><img src="../../../res/img/button_login.gif" ></a>
					</c:if>
					<c:if test="${sessionScope.UserInfo ne null}">
						<a href="/logout" style="cursor:pointer; margin:4px 0 0 5px; display:block; width:61px; height:19px; overflow:hidden; float:left;"><img src="../../../res/img/button_logout.gif" position="30px 0"></a>
					</c:if>
				</div>
			</div>
		</div>
		<div id="hd2">
			<a href="/"><div id="logo"></div></a>
			<a target="_blank" href="https://www.kr.playblackdesert.com/Intro/guardian_update#utm_campaign=Guardian_update&utm_source=inven_pc&utm_term=191217&utm_medium=da&utm_content=inven1" target="blank">
				<div id="hd2-2"></div>
			</a>
		</div>
		<ul id="hd3">
			<a href="/"><li class="menu1 link">홈</li></a>
			<a href="/herolist"><li class="menu1 link">영웅정보</li></a>
			<a href="/board"><li class="menu1 link">공략툴</li></a>
			<a href="/counterpick"><li class="menu1 link">카운터픽</li></a>
			<li class="menu1" style="color:#AAA;">방송</li>
			<li class="menu1" style="color:#AAA; width:155px;">오버워치 리그</li>
		</ul>
	</header>
</body>
</html>