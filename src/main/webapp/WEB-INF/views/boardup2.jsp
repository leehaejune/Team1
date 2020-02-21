<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>오버워치 인벤</title>
<link rel="shortcut icon" type="image/x-icon" href="img/res/favicon.ico?v=151218a">
<script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script>
<link rel="stylesheet" href="/res/css/boardup.css">
<!-- <script type="text/javascript" src="/res/editor/ckeditor/ckeditor.js"></script> -->
<script src="/res/js/boardup2.js"></script>
<script src="/res/js/index.js"></script>
</head>
<body>
	<input type="hidden" value = "${sessionScope.UserInfo.id}" id ="sid" >
	<input type="hidden" value = "${sessionScope.UserInfo.nick}" id ="snick">
	<input type="hidden" value = "${sessionScope.no}" id ="bno">
	<input type="hidden" value = "${sessionScope.UserInfo.nick}" id ="snick">
	
	
	<c:import url="/login" />
	<div id="body">
		<c:import url="/head" />
		<section>
			<c:import url="/stL" />
			<div id="stM">
				<div id = "mmain">
					<div id = "ddb1">
						<h3 class = "hhero"><span>영웅 공략 작성</span></h3>
					</div>
					<div id = "db2">
					<div class = "db2a">
						<div id = "db2aa"></div>
					</div>
					</div>
					<div id = "db3">
					<div class = "db3a">
						<div id = "db3aa"></div>
					</div>
					</div>
			<form action="/board4" method="post" id="write" name="form1">	
				<div id = "ddb11">
					<div class = "hero1"><img id="hero1" src ="${result.result5.heroimg}"/></div>
					<input type="hidden" value = "" id ="hno" >
					<div class = "map1"><img id="map1" src ="${result.result5.mapimg}"/></div>
					<input type="hidden" value = "" id ="mno" >
					
					<div class = "hero2"><span id= "heroname" style= " padding : 0px 5px 0px 0px">${result.result5.heroname}</span>&nbsp;<span id ="mapname">${result.result5.mapname}</span></div>
					<div class = "hero3"><textarea id = "edit1"  rows="4" cols="50"></textarea></div>
				</div>
			<div id = "ddb2">
				<ul id = "ddb2a">
				<li class = "brand-body" ><a onclick="brand2" style="cursor: pointer;">내용</a></li>
<!-- 				<li class = "brand-body" ><a onclick="brand2(1)" style="cursor: pointer;">추천조합</a></li> -->
<!-- 				<li class = "brand-body" ><a onclick="brand2(2)" style="cursor: pointer;">영웅상성</a></li> -->
<!-- 				<li class = "brand-body" ><a onclick="brand2(3)" style="cursor: pointer;">운용법</a></li> -->
<!-- 				<li class = "brand-body" ><a onclick="brand2(4)" style="cursor: pointer;">전장심화</a></li> -->
				</ul>
				<div id = "ddb2b"><textarea id ="edit">${result.result5.content1}</textarea>
			</div>
		</div>
	</div>
			
					
			<div id = "ddb3">

			<div id ="back">
<!-- 				<form id = ""> -->
<!-- 					<input class="file" type="file" name= "image"></input> -->
<!-- 				</form> -->
			</div>
			<div id = "icon">
				    <button type="button" id ="btnCancel" class="btn4">취소</button>
				    <button type="button" id ="btnOk" class="btn4" >확인</button>
			</div>
			
			</div>
		</form>
			</div>

			<c:import url="/stR" />
		</section>
		<c:import url="/footer" />
	</div>
</body>
</html>