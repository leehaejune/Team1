<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>오버워치 인벤</title>
<link rel="stylesheet" href="res/css/counterpick.css" type="text/css">
<link rel="shortcut icon" type="image/x-icon" href="/res/img/main_page/favicon.ico?v=151218a">
<script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script>
<script src="/res/js/index.js"></script>
<!-- <script src="res/js/counterpick_votechar.js"></script> -->
<!-- <script src="res/js/counterpick_herolist.js"></script> -->
<script src="/res/js/counterpick_main2.js"></script>
</head>
<body>
	<c:import url="/login" />
	<div id="body">
		<c:import url="/head" />
		<section>
			<c:import url="/stL" />
			<div id="stM">
				<div id="overwatchMain">
						<div id="counter">
							<h3>영웅별 상성/카운터</h3>
						</div>
						<div id="vote">
							<div id="votebox">
								<div id="votehidden">
									<div class="votetitle">상성 투표</div>
									<table id="votetable">
									<tbody>
										<tr id="votetr1">
											<td id="votechar1">
												<div class="votechar_img_div" data-hno="${results.no}">
													<img id="votechar_img1" class="votechar_img_src" src ="${results.heroimg}"/>
												</div>
												<div id="votechar_name_1" class="votechar_name">${results.heroname}</div>
											</td>
											<td id="votevs"></td>
											<td id="votechar2">
												<div class="votechar_img_div" data-hno="${results.no}">
													<img id="votechar_img2" class="votechar_img_src" src ="${results.heroimg}">
												</div>
												<div id="votechar_name_2" class="votechar_name">${results.heroname}</div>
											</td>
											<td id="votenext">
												<button id="votenext_button1" class="votenext_button">
													<img class="votenext_button" src="/res/img/etc/button_next.png">
												</button>
											</td>
										</tr>
										<tr id="votetr2">
											<td class="votetr2_td votetr2_td1">
												<div class="vote_button_strong_div">
													<button type="button" id="vote_button_strong_a_1" class="vote_button_strong_a">우세
													</button>
												</div>
											</td>
											<td class="votetr2_td votetr2_td2">
												<div class="vote_button_strong_div">
													<button type="button" id="vote_button_strong_a_2" class="vote_button_strong_a">동등
													</button>
												</div>
											</td>
											<td class="votetr2_td votetr2_td3">
												<div class="vote_button_strong_div">
													<button type="button" id="vote_button_strong_a_3" class="vote_button_strong_a">약세
													</button>
												</div>
											</td>
											<td id="vote_blank"></td>
										</tr>
									</tbody>
								</table>
								</div>
							</div>
							<div id="listbox">
								<div id="listbox_top">
								</div>
								<div id="listbox_mid">
									<div id="herobox">
										<div id="herobox_title">영웅별 투표 통계</div>
										<div id="herobox_herolist"></div>
									</div>
									<div id="heroportal">
										<div id="heroportal_heroinfo">
											<img id="heroportal_heroinfo_picture" src="/res/img/char/hero_null.png">
											<div id="heroportal_heroinfo_text">
												<div id="heroportal_heroinfo_text_top">
												영웅을 선택하세요.
												</div>
												<div id="heroportal_heroinfo_text_bottom">
													<div id="strong_hero"></div>
<!-- 													<div id="strong_hero">유리한 영웅:</div> -->
													<div id="strong_no"></div>
<!-- 													<div id="strong_no">6명</div> -->
<!-- 													<div id="weak_hero">불리한 영웅:</div> -->
<!-- 													<div id="weak_no">19명</div> -->
<!-- 													<div id="same_hero">동등/복합적 영웅:</div> -->
<!-- 													<div id="same_no">5명</div> -->
												</div>
											</div>
										</div>
										<div id="heroportal_heroinfolink">
											<a href="/herolist"></a>
										</div>
									</div>
<!-- 									<div id="filter"> -->
<!-- 										<div id="filter_left"> -->
<!-- 											<ul> -->
<!-- 												<li id="filter_left_1"> -->
<!-- 													<input type="radio" name="filter_left_input"> -->
<!-- 													<label id="left_label1">전체</label> -->
<!-- 												</li> -->
<!-- 												<li id="filter_left_2"> -->
<!-- 													<input type="radio" name="filter_left_input"> -->
<!-- 													<label id="left_label2">상성 유리</label> -->
<!-- 												</li> -->
<!-- 												<li id="filter_left_3"> -->
<!-- 													<input type="radio" name="filter_left_input"> -->
<!-- 													<label id="left_label3">상성 불리</label> -->
<!-- 												</li> -->
<!-- 												<li id="filter_left_4"> -->
<!-- 													<input type="radio" name="filter_left_input"> -->
<!-- 													<label id="left_label4">동급 & 복합적</label> -->
<!-- 												</li> -->
<!-- 											</ul> -->
<!-- 										</div> -->
<!-- 										<div id="filter_right"> -->
<!-- 											<ul> -->
<!-- 												<li id="filter_right_1"> -->
<!-- 													<input type="radio" name="filter_left_input"> -->
<!-- 													<label id="right_label1">VS 공격</label> -->
<!-- 												</li> -->
<!-- 												<li id="filter_right_2"> -->
<!-- 													<input type="radio" name="filter_left_input"> -->
<!-- 													<label id="right_label2">VS 돌격</label> -->
<!-- 												</li> -->
<!-- 												<li id="filter_right_3"> -->
<!-- 													<input type="radio" name="filter_left_input" checked="checked"> -->
<!-- 													<label id="right_label3">VS 지원</label> -->
<!-- 												</li> -->
<!-- 											</ul> -->
<!-- 										</div> -->
<!-- 									</div> -->
									<div id="vote_result_list">
										<ul id="vote_result_list_title">
											<li class="vote_result_list_title_1 "></li>
<!-- 											<li class="vote_result_list_title_1 ">순번</li> -->
											<li class="vote_result_list_title_2 ">아이콘</li>
<!-- 											<li class="vote_result_list_title_2 ">아이콘</li> -->
											<li class="vote_result_list_title_3 ">이름</li>
											<li class="vote_result_list_title_4 ">총 평가수</li>
											<li class="vote_result_list_title_5 ">평가</li>
											<li class="vote_result_list_title_6 "></li>
<!-- 											<li class="vote_result_list_title_6 ">분석</li> -->
										</ul>
										<div id="vote_result_list1"></div>
									</div>
								</div>
							</div>
							<div id="listbox_bottom">
							</div>
						</div>
<!-- 						<div id="comment"> -->
<!-- 						</div> -->
						<a></a>
					</div>
					
				
				
				
			</div>
			<c:import url="/stR" />
		</section>
		<c:import url="/footer" />
	</div>
</body>
</html>