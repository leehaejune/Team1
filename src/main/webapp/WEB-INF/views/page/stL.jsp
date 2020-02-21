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
	<div id="stL">
		<div id="loginDiv">
			<c:if test="${sessionScope.UserInfo eq null}">
				<div id="LoginL">
					<p style="margin:0px; padding:5px 0; text-align: center; color: white;">
					로그인하고<br><span style="color: #95ff7d;">출석보상</span> 받으세요!
					</p>
					<div id="invenlogin" class="logon">
						<div style="margin:5px 0 0 18px; vertical-align: middle;">
							<img alt="inven" src="../../../res/img/icon_logo.png">
							<span style=" font-weight:bold;">로그인</span>
						</div>
					</div>
				</div>
				<a href="/signup">
					<div style="color:black; line-height:28px; font-size:11px; font-family:gulim, 굴림; width:79px; height:28px; margin:0 0 0 45px; text-align: center;">
						| &nbsp; 회원가입 &nbsp; |
					</div>
				</a>
			</c:if>
			<c:if test="${sessionScope.UserInfo ne null}">
				<div style="width:169px; height:50px;"></div>
				<p style="line-height:19px; text-align: center; letter-spacing: 3px;"><b id="stLnick">${sessionScope.UserInfo.nick}</b>님 <br>안녕하세요!</p>
				<div style></div>
				<a href="/userUpdate">
					<div style="background-color:#FFF; border:1px solid #ff9c00; color:black; line-height:21px; font-size:11px; font-family:gulim, 굴림; width:89px; height:21px; margin:0 0 0 40px; text-align: center;">
						| &nbsp; 정보변경 &nbsp; |
					</div>
				</a>
				<a href="/logout">
					<div style="background-color:#FFF; border:1px solid #ff9c00; color:black; line-height:21px; font-size:11px; font-family:gulim, 굴림; width:89px; height:21px; margin:5px 0 0 40px; text-align: center;">
						| &nbsp; 로그아웃 &nbsp; |
					</div>
				</a>
			</c:if>
		</div>
		
		<div class="LeftUl">
			<span>팀 프로젝트</span>
		</div>
		<div class="LeftDiv">
			<div class="LeftLi" >
				박성진
			</div>
			<div class="LeftLi">
				남재규
			</div>
			<div class="LeftLi">
				이해준
			</div>
			<div class="LeftLi">
				박성민
			</div>
		</div>
		<div style="position:absolute; bottom:-5px; left:-210px; opacity: 30%">
			<img alt="" src="../../../res/img/pngfuel.png" width="550px">
		</div>
	</div>
</body>
</html>