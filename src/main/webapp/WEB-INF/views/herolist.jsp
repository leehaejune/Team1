<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html oncontextmenu="return false">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>herolist</title>
	<link rel="shortcut icon" type="image/x-icon" href="/res/img/favicon.ico?v=151218a">
	<link rel="stylesheet" href="/res/css/herolist.css">
	<script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script>
	<script src="/res/js/index.js"></script>
</head>
<body>
	<c:import url="/login" />
	<div id="body">
		<c:import url="/head" />
		<section>
			<c:import url="/stL" />
			<div id="stM">
				
				<div id="buudi">
		<div id="title">오버워치 영웅정보
		</div>
		<div id="box">
		<div id="bbox">
               <div class="bbox1">
                  <img src="/res/img/herotype_icon1_41x39.png" class="/res/herotype_img">
                  <span class="type" style="color:#00c3ff">공격 역할군
               </span>
					</div>
					<div class="bbox2">
					<ul>
					<c:forEach var="row" items="${Att}">
						<li class ="char0">
		               		<a href="/heroinfo?key=${row.no}">
		               			<div class="Icon">
		               				<img src="${row.heroimg}">
		               			</div>
		               			<span>${row.heroname}</span>
		             		</a>
						</li>
					</c:forEach>
				
					</ul>
					</div>
				
				<div class="bbox1" style="padding-left:4px">
					<img src="/res/img/herotype_icon3_41x39.png" class="/res/herotype_img">
					<span class="type" style="color:#00c3ff"> 돌격 역할군
               </span>
					</div>
					<div class="bbox2">
					<ul>
						<c:forEach var="row" items="${Cha}">
						<li class ="char0">
		               		<a href="/heroinfo?key=${row.no}">
		               			<div class="Icon">
		               				<img src="${row.heroimg}">
		               			</div>
		               			<span>${row.heroname}</span>
		             		</a>
						</li>
					</c:forEach>
					</ul>
					</div>
				<div class="bbox1">
					<img src="/res/img/herotype_icon4_41x39.png" class="/res/herotype_img">
					<span class="type" style="color:#00c3ff">지원 역할군
               </span>
				</div>
				<div class="bbox2">
				<ul>
					<c:forEach var="row" items="${Sub}">
						<li class ="char0">
		               		<a href="/heroinfo?key=${row.no}">
		               			<div class="Icon">
		               				<img src="${row.heroimg}">
		               			</div>
		               			<span>${row.heroname}</span>
		             		</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
				
				
				
					
				
			</div>
			<c:import url="/stR" />
		</section>
		<c:import url="/footer" />
	</div>
</body>
</html>