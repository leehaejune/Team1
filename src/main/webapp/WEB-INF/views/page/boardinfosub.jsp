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
			<div class = "hero4"><a href="http://team1.gudi.kr/heroinfo?key=${result.result4.hno}"><img src ="/res/img/sungmin.png"></a></div>
			<div class = "hero3">${result.result4.title} <br><span style="color:#ffc70e;">작성자 : </span><span id ="bid">${result.result4.id}</span> <span style="color:#ffc70e;">| 조회수 :</span> ${result.result4.hits}</div>	
			
		</div>		
			<div id = "ddb2" class ="ddb2">
				<div class = "top"><span>머리말</span></div>
				<div class = "pen">${result.result4.content1}</div>
			</div>


<!-- 		<div id = "ddb5"> -->
<!-- 			<dl id="boardList1"></dl> -->
<!-- 			<dl id="boardList2"></dl> -->
<!-- 		</div> -->
	</div>

</body>
</html>


