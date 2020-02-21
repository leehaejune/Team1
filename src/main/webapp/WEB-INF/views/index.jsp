<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>오버워치 인벤</title>
<link rel="shortcut icon" type="image/x-icon" href="res/img/favicon.ico?v=151218a">
<link rel="stylesheet" href="res/css/index.css">
<script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script>
<script src="res/js/index.js" type="text/javascript"></script>
</head>
<body>
	<c:import url="/login" />
	<div id="body">
		<c:import url="/head" />
		<section>
			<c:import url="/stL" />
			<div id="stM">
				<article id="mainImg">
					<article class="art1" style="background-position: left top;"></article>
					<article class="art1" style="background-position: right top; margin-left: 1px;"></article>
					<article class="art1" style="background-position: 0 65%; margin-top: 1px; "></article>
					<article class="art1" style="background-position: 100% 65%; margin: 1px 0 0 1px;"></article>
				</article>
				<article id="walkthrough">
					<a href="/board">
						<div style="background: url(res/img/title_logo.png) no-repeat 7px 9px; line-height:33px; text-indent:22px; position:absolute; left:0; width:722px; height:33px; background-color: #ffffff; border-width: 2px 1px 1px 1px; border-color: #333333 #d7d7d7 #d7d7d7 #d7d7d7; border-style: solid solid solid solid;">
							<b style="text-decoration: none; color:black;">오버워치 공략게시판</b>
						</div>
					</a>
					<ul id="WT">
						<c:forEach var="row" items="${sessionScope.indexboard}"><li>
							<div style="width:70%; padding-left:11px;"><a href="/board/${row.no}"><span style="color:#3d85c6">[<c:out value="${row.heroname}" />] </span><span style="color:#333;"><c:out value="${row.title}" /></span></a></div>
							<div style="width:15%; text-align:center;"><c:out value="${row.nick}" /></div>
							<div style="width:15%; text-align:center;"><c:out value="${row.date}" /></div>
						</li></c:forEach>
					</ul>
				</article>
				<article id="brand">
					<div id="bra">
						<div id="br_img"></div>
						<ul>
							<li id="br_li">
								<a onmouseover="brand(0)" onclick="brand(0)" style="cursor: pointer;">AMD 라이젠</a>
								<a onmouseover="brand(1)" onclick="brand(1)" style="cursor: pointer;">인텔(INTEL)</a>
								<a onmouseover="brand(2)" onclick="brand(2)" style="cursor: pointer;">Geforce NOW</a>
							</li>
							<li class="brand-body dsBlc">
								<div class="bran" id="bran1">
									<div class="fiv" style="background: url('../res/img/bran1_1.jpg') no-repeat; background-size: 151px;">라이젠 막내, 3500 캡쳐하면 CPU를 준다고?</div>
									<div class="fiv" style="background: url('res/img/bran1_2.jpg') no-repeat; background-size: 151px;">라이젠 최저가 첫자리 더하기 이벤트!</div>
									<div class="fiv" style="background: url('res/img/bran1_3.jpg') no-repeat; background-size: 151px;">나만의 라이젠 크리스마스카드 만들기!</div>
									<div class="fiv" style="background: url('res/img/bran1_4.jpg') no-repeat; background-size: 151px;">비교할 수 없는 성능! AMD 라이젠 제품 바로가기</div>
								</div>
							</li>
							<li class="brand-body">
								<div class="bran" id="bran2">
									<div class="fiv" style="background: url('res/img/bran2_1.jpg') no-repeat; background-size: 151px;">제 9차 인텔 모의고사</div>
									<div class="fiv" style="background: url('res/img/bran2_2.jpg') no-repeat; background-size: 151px;">인텔 CPU 유저들을 위한 전국~컴퓨터자랑!</div>
									<div class="fiv" style="background: url('res/img/bran2_3.jpg') no-repeat; background-size: 151px;">인텔 코어 i5-9600KF 프로세서 퀴즈 이벤트</div>
									<div class="fiv" style="background: url('res/img/bran2_4.jpg') no-repeat; background-size: 151px;">승리를 위한 선택! 인텔 제품 보러가기</div>
								</div>
							</li>
							<li class="brand-body">
								<div class="bran" id="bran3">
									<div class="fiv" style="background: url('res/img/bran3_1.jpg') no-repeat; background-size: 151px;">지포스나우가 바꿀 게임 생태계</div>
									<div class="fiv" style="background: url('res/img/bran3_2.jpg') no-repeat; background-size: 151px;">Geforce NOW 지원 게임 확인하러 가기</div>
									<div class="fiv" style="background: url('res/img/bran3_3.jpg') no-repeat; background-size: 151px;">랙 없어? 실제 써본 지포스 나우 체험</div>
									<div class="fiv" style="background: url('res/img/bran3_4.jpg') no-repeat; background-size: 151px;">5G로 시연하는 대작 게임! 체험 영상</div>
								</div>
							</li>
						</ul>
					</div>
				</article>
			</div>
			<c:import url="/stR" />
		</section>
		<c:import url="/footer" />
	</div>
</body>
</html>