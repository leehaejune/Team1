<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>오버워치 인벤</title>
<link rel="shortcut icon" type="image/x-icon" href="/res/img/favicon.ico?v=151218a">
<script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script>
<link rel="stylesheet" href="/res/css/board.css">
<link rel="stylesheet" href="../../../res/css/login.css">
<script src="/res/js/board.js"></script>
<script src="/res/js/index.js"></script>
<style type="text/css">
.active {background-color: #237dc0;}
#db6 a {padding: 5px 10px; border-radius: 8px;}
</style>

</head>
<body>
	<input type="hidden" id ="sid"   value = "${sessionScope.UserInfo.id}" >
	<input type="hidden" id ="snick" value = "${sessionScope.UserInfo.nick}" >
	<c:import url="/login" />
	<div id="body">
		<c:import url="/head" />
		<section>
			<c:import url="/stL" />
			<div id="stM">
			
					<div id = "dbno">
			<h3 class = "hero">
				<span>영웅 공략 </span>
			</h3>
			<div id = "db1">
				<dl id="boardList1"></dl>
				<dl id="boardList2"></dl>
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
			<div id = "db4">
				<div class = "mennu1">				
					   <div id="filter_left" style= "text-align: center; font-weight : 800; font-size :14px; color:#044077;"   >
					     <span >검색 기능</span> 
<!-- 					         <li id="filter_left_1"> -->
<!-- 					            <input type="radio" name="filter_left_input"> -->
<!-- 					            <label id="left_label1"></label> -->
<!-- 					         </li> -->
<!-- 					         <li id="filter_left_2"> -->
<!-- 					            <input type="radio" name="filter_left_input"> -->
<!-- 					            <label id="left_label2"></label> -->
<!-- 					         	</li> -->
					     
					   </div>
				</div>
				<form>
					<div class ="mennu2">
						<select name = "serch" id ="selectbar">
							<option id="ti"  value="subject">제목</option>
							<option id="ids" value="author">작성자</option>
						</select>
						<input type="text" id="blank" name = "blank" style = "width :300px"></input>
						<button type="button" id ="serch" class="btn1">검색</button>
						<button type="button" id="btn2" class= "btn2">글쓰기</button>					
						<button type="button" class="btn3">초기화</button>	
					</div>		
				</form>
			</div>	
			<div id = "db5"></div>
			
			<div id="db6"></div>
			
 		</div>
	</div>
			<c:import url="/stR" />
		</section>
		<c:import url="/footer" />
	</div>
</body>
</html>