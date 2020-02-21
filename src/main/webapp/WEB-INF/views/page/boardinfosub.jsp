<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>
	<div class = "row4" id = "getboardList">
	<input type="hidden" value = "${sessionScope.UserInfo.id}" id ="sid" >
	<input type="hidden" value = "${sessionScope.UserInfo.nick}" id ="snick">
		<div id = "ddb1">
			<h3 class = "hhero"><span>영웅 공략: ${result.result4.heroname}</span></h3>
		</div>
		<div id = "ddb11">
			<div class = "hero1"><img src ="${result.result4.heroimg}"></div>
			<div class = "hero2">${result.result4.heroname}</div>
			<div class = "hero4"><a href="/heroinfo?key=${result.result4.hno}"><img src ="/res/img/sungmin.png"></a></div>
			<div class = "hero3">${result.result4.title} <br><span style="color:#ffc70e;">작성자 : </span><span id ="bid">${result.result4.id}</span> <span style="color:#ffc70e;">| 조회수 :</span> ${result.result4.hits}</div>	
				
			<div id = "ddb2" class ="ddb2">
				<div class = "top"><span>머리말</span></div>
				<div class = "pen">${result.result4.content1}</div>
			</div>
<!-- 			<div id = "ddb3" class ="ddb2"> -->
<!-- 				<div class = "top"><span>추천 조합</span></div> -->
<%-- 				<div class = "pen">${result.result4.content2}</div> --%>
<!-- 			</div> -->
<!-- 			<div id = "ddb4" class ="ddb2"> -->
<!-- 				<div class = "top"><span>운용법</span></div> -->
<%-- 				<div class = "pen">${result.result4.content3}</div> --%>
<!-- 			</div> -->
<!-- 			<div id = "ddb6" class ="ddb2"> -->
<!-- 				<div class = "top"><span>운용법</span></div> -->
<%-- 				<div class = "pen">${result.result4.content4}</div> --%>
<!-- 			</div> -->
<!-- 			<div id = "ddb7" class ="ddb2"> -->
<!-- 				<div class = "top"><span>운용법</span></div> -->
<%-- 				<div class = "pen">${result.result4.content5}</div> --%>
<!-- 			</div> -->
		</div>
	</div>
<!-- 	<div id = "ddb5"> -->
<!-- 		<dl id="boardList1"></dl> -->
<!-- 		<dl id="boardList2"></dl> -->
<!-- 			<dl> -->
<!-- 	 		<dt>이 -->
<!-- 				<span class ="dd">전장</span>의 다른 공략 -->
<!-- 			</dt> -->
<!-- 			<dd> -->
<!-- 				<ul> -->
<!-- 					<li><span>[겐지]</span><a> 38가지 다양한 팁들 (패치 이후)</a></li> -->
<!-- 					<li><span>[오리사]</span><a>b</a></li> -->
<!-- 					<li><span>[리퍼]</span><a>c</a></li> -->
<!-- 					<li><span>[둠피스트]</span><a>d</a></li> -->
<!-- 					<li><span>[메이]</span><a>e</a></li> -->
<!-- 					<li><span>[루시우]</span><a>f</a></li> -->
<!-- 					<li><span>[자리야]</span><a>a</a></li> -->
<!-- 				</ul> -->
<!-- 			</dd> -->
<!-- 		</dl> -->
<!-- 			<dl> -->
<!-- 			<dt> -->
<!-- 				<span class ="dd">작성자</span>의 다른 공략 -->
<!-- 			</dt> -->
<!-- 			<dd> -->
<!-- 			<ul> -->
<!-- 					<li><span>[겐지]</span><a>38가지 다양한 겐지 팁들 (패치 이후)</a></li> -->
<!-- 					<li><span>[오리사]</span><a>b</a></li> -->
<!-- 					<li><span>[리퍼]</span><a>c</a></li> -->
<!-- 					<li><span>[둠피스트]</span><a>d</a></li> -->
<!-- 					<li><span>[메이]</span><a>e</a></li> -->
<!-- 					<li><span>[루시우]</span><a>f</a></li> -->
<!-- 					<li><span>[자리야]</span><a>a</a></li> -->
<!-- 			</ul> -->
<!-- 		</dd> -->
<!-- 		</dl> -->
<!-- 	</div> -->
</body>
</html>


