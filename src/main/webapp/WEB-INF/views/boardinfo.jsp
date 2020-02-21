<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>오버워치 인벤</title>
<link rel="shortcut icon" type="image/x-icon" href="/res/img/favicon.ico?v=151218a">
<script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script>
<link rel="stylesheet" href="/res/css/boardinfo.css">
<script src="/res/js/boardinfo.js"></script>
<script src="/res/js/index.js"></script>
</head>
<body>
	<input type="hidden" value = "${sessionScope.no}" id ="bno">
	<input type="hidden" value = "${sessionScope.UserInfo.id}" id ="sid" >
	<input type="hidden" value = "${sessionScope.UserInfo.nick}" id ="snick">

	<c:import url="/login" />
	<div id="body">
		<c:import url="/head" />
		<section>
			<c:import url="/stL" />
			
				<div id="stM">
					<div id = "mmain">
						<div id ="boardList4"></div>
			
						<div id = "ddb5">
							<dl id="boardList1"></dl>
							<dl id="boardList2"></dl>
						</div>
					</div>
					
					<c:if test="${sessionScope.UserInfo ne null}">
						<div id = ddbar style ="float:right; margin-right:18px">
							<button id ="upbutton" type ="button">수정</button>
							<button id ="delbutton" type = "button">삭제</button>
						</div> 
					</c:if>
				</div>
				
			<c:import url="/stR" />
		</section>
		<c:import url="/footer" />
	</div>
</body>
</html>